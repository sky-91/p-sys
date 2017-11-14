package cn.qsky.policesys.web.aop;

import cn.qsky.policesys.common.log.DateInjectionException;
import cn.qsky.policesys.common.log.enums.SystemErrorCode;
import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.core.generator.GeneratorService;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * aop注入主键、创建时间和修改时间 注入dao层insert和update开头的方法 参数必须是一个切包含以上三个字段
 *
 * @author qsky
 */
@Component
@Aspect
public class PrimaryKeyDateInjection {

  private static final String INSERT = "insert";
  private static final String FIELD_PK = "pk";
  private static final String FIELD_CREATED_TIME = "createdTime";
  private static final String FIELD_MODIFIED_TIME = "modifiedTime";
  private static final String FIELD_CREATOR = "creator";
  private static final String FIELD_MODIFIER = "modifier";
  private static final Logger LOG = LoggerFactory.getLogger(PrimaryKeyDateInjection.class);

  @Resource
  private GeneratorService generatorService;

  /**
   * 切点配置insert和update开头的方法
   */
  @Pointcut("execution(public * cn.qsky.policesys.core.dao.mapper.*.update*(..)) || "
      + "execution(public * cn.qsky.policesys.core.dao.mapper.*.insert*(..))")
  public void primaryKeyDate() {
    LOG.debug("call primaryKeyDate method");
  }

  @Before("primaryKeyDate()")
  public void before(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    LOG.debug("aop injection data method name:{}", methodName);
    Object[] args = joinPoint.getArgs();
    if (args == null || args.length == 0) {
      throw new DateInjectionException(SystemErrorCode.METHOD_PARAMETER.getErrorCode());
    }
    if (args[0] instanceof List) {
      List<Object> listModel = (List<Object>) args[0];
      for (Object model : listModel) {
        insertOrUpdateInjection(methodName, model);
      }
    } else {
      insertOrUpdateInjection(methodName, args[0]);
    }
  }

  private void insertOrUpdateInjection(String methodName, Object model) {
    Date date = DateUtil.getCurrentDate();
    if (methodName.startsWith(INSERT)) {
      injectionData(model, FIELD_PK, generatorService.generatePK());
      injectionData(model, FIELD_CREATED_TIME, date);
      // getUserId, The user needs to login
      //injectionData(model, FIELD_CREATOR, getUserId());
    }
    injectionData(model, FIELD_MODIFIED_TIME, date);
    // getUserId, The user needs to login
    //injectionData(model, FIELD_MODIFIER, getUserId());
  }

  private String getUserId() {
    try {
      return "";
    } catch (Exception e) {
      LOG.error(e.getMessage());
    }
    return null;
  }

  private void injectionData(Object arg, String fieldName, Object objInjection) {
    try {
      Field field = arg.getClass().getDeclaredField(fieldName);
      if (field != null) {
        field.setAccessible(true);
        field.set(arg, objInjection);
        LOG.debug("injection fieldName {} data {}", fieldName, objInjection);
      }
    } catch (NoSuchFieldException e) {
      if (!FIELD_CREATOR.equals(fieldName) && !FIELD_MODIFIER.equals(fieldName)) {
        throw new DateInjectionException(SystemErrorCode.FIELD_ACCESS.getErrorCode(), e);
      }
    } catch (IllegalAccessException e) {
      throw new DateInjectionException(SystemErrorCode.FIELD_ACCESS.getErrorCode(), e);
    }
  }
}
