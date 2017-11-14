package cn.qsky.policesys.common.log;

import cn.qsky.policesys.common.log.enums.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * 主键、创建时间和修改时间注入异常
 *
 * @author qsky
 */
public class DateInjectionException extends GeneralException {

  private static final long serialVersionUID = -3530651138795841368L;

  public DateInjectionException(Integer errorCodeOffset) {
    super(ErrorCode.SYSTEM, errorCodeOffset, HttpStatus.INTERNAL_SERVER_ERROR, null);
  }

  public DateInjectionException(Integer errorCodeOffset, Throwable cause) {
    super(ErrorCode.SYSTEM, errorCodeOffset, HttpStatus.INTERNAL_SERVER_ERROR, cause);
  }
}
