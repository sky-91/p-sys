package cn.qsky.policesys.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;

/**
 * @author qsky
 */
public class DozerMapper {

  private static DozerBeanMapper mapper = DozerBeanMapperFactory.getMapper();

  /**
   * 转换对象套对象，主体对象的简单属性默认转换
   * option写了哪个子对象的field名称，则该子对象会自动转换
   *
   * @param inObject source
   * @param outObject target
   * @param options list<target对象要转的field名称>
   */
  public static <I, O> O convertObjectByOption(I inObject, O outObject, List<String> options) {
    CglibBeanUtil.copyProperties(inObject, outObject);
    if (options == null || options.isEmpty()) {
      return outObject;
    }
    try {
      Map<String, Field> inFieldMap = new HashMap<>();
      for (Field inField : inObject.getClass().getDeclaredFields()) {
        inField.setAccessible(true);
        if (!isJavaClass(inField, inObject)) {
          inFieldMap.put(inField.getName(), inField);
        }
      }
      Map<String, Field> outFieldMap = new HashMap<>();
      for (Field outField : outObject.getClass().getDeclaredFields()) {
        outField.setAccessible(true);
        if (!isJavaClass(outField, null)) {
          outFieldMap.put(outField.getName(), outField);
        }
      }
      for (String option : options) {
        if (inFieldMap.containsKey(option) && outFieldMap.containsKey(option)) {
          if (Collection.class.isAssignableFrom(outFieldMap.get(option).getType())) {
            ParameterizedType type = (ParameterizedType) outFieldMap.get(option).getGenericType();
            Class<?> listInClass = (Class<?>) type.getActualTypeArguments()[0];
            List<Object> sourceList = (List<Object>) inFieldMap.get(option).get(inObject);
            List<Object> targetList = new ArrayList<>();
            for (Object source : sourceList) {
              targetList.add(mapper.map(source, listInClass));
            }
            outFieldMap.get(option).set(outObject, targetList);
          } else {
            Object target =
                mapper.map(inFieldMap.get(option).get(inObject), outFieldMap.get(option).getType());
            outFieldMap.get(option).set(outObject, target);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return outObject;
  }

  private static boolean isJavaClass(Field field, Object object) {
    Class<?> clz;
    try {
      if (object == null) {
        clz = field.getType();
        if (Collection.class.isAssignableFrom(clz)) {
          Type genericType = field.getGenericType();
          if (genericType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) genericType;
            clz = (Class<?>) pt.getActualTypeArguments()[0];
          }
        }
      } else {
        if (field.get(object) == null) {
          return true;
        }
        Object value = field.get(object);
        if (value instanceof String && StringUtils.isEmpty((String) value)) {
          return true;
        }
        clz = field.get(object).getClass();
        if (value instanceof Collection && CollectionUtils.isEmpty((Collection) value)) {
          return true;
        } else if (value instanceof Collection && !CollectionUtils.isEmpty((Collection) value)) {
          clz = ((Collection) field.get(object)).iterator().next().getClass();
        }
      }
      return clz != null && clz.getClassLoader() == null;
    } catch (Exception e) {
      e.printStackTrace();
      return true;
    }
  }

  /**
   * 用dozer来转换list
   *
   * @param inList inList
   * @param o 装出对象的class
   * @return List<O>
   */
  public static <O, I> List<O> converterListByDozer(List<I> inList, Class<O> o) {
    if (CollectionUtils.isEmpty(inList)) {
      return Collections.emptyList();
    }
    List<O> outList = new ArrayList<>(inList.size());
    for (I i : inList) {
      O oo = BeanUtils.instantiate(o);
      mapper.map(i, oo);
      outList.add(oo);
    }
    return outList;
  }
}
