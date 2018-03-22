package cn.qsky.policesys.web.aop;

import cn.qsky.policesys.common.exception.DataInvalidException;
import cn.qsky.policesys.common.exception.SourceNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qsky on 2018/3/20
 */
@ControllerAdvice
public class MyControllerAdvice {

  /**
   * 全局异常捕捉处理
   */
  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public Map errorHandler(Exception ex) {
    ex.printStackTrace();
    Map map = new HashMap();
    map.put("httpStatus", 500);
    map.put("message", "内部服务器错误");
    return map;
  }

  /**
   * 拦截捕捉自定义异常 SourceNotFoundException.class
   */
  @ResponseBody
  @ExceptionHandler(value = SourceNotFoundException.class)
  public Map sourceNotFoundHandler(SourceNotFoundException ex) {
    Map map = new HashMap();
    map.put("httpStatus", 404);
    map.put("message", "请求的资源未找到");
    return map;
  }

  /**
   * 拦截捕捉自定义异常 DataInvalidException.class
   */
  @ResponseBody
  @ExceptionHandler(value = DataInvalidException.class)
  public Map dataInvalidHandler(DataInvalidException ex) {
    Map map = new HashMap();
    map.put("httpStatus", 400);
    map.put("message", "数据已失效,请稍后重试");
    return map;
  }

}
