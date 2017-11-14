package cn.qsky.policesys.core.generator.exception;

import cn.qsky.policesys.common.log.GeneralException;
import cn.qsky.policesys.common.log.enums.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * 生成编码异常
 *
 * @author qsky
 */
public class GeneratorException extends GeneralException {

  private static final long serialVersionUID = -4436875711317811442L;

  public GeneratorException(Integer errorCodeOffset, HttpStatus status) {
    super(ErrorCode.SYSTEM, errorCodeOffset, null, status);
  }

  public GeneratorException(Integer errorCodeOffset, Throwable cause, HttpStatus status) {
    super(ErrorCode.SYSTEM, errorCodeOffset, cause, status);
  }

  public GeneratorException(Integer errorCodeOffset, HttpStatus status, Object... messageArgs) {
    super(ErrorCode.SYSTEM, errorCodeOffset, status, null, messageArgs);
  }

}
