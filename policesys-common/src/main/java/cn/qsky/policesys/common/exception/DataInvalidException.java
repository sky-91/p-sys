package cn.qsky.policesys.common.exception;

import cn.qsky.policesys.common.log.GeneralException;
import cn.qsky.policesys.common.log.enums.ErrorCode;
import cn.qsky.policesys.common.log.enums.SystemErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author qsky on 2018/3/20
 */
public class DataInvalidException extends GeneralException {

  private static final long serialVersionUID = 1L;

  public DataInvalidException() {
    super(ErrorCode.SYSTEM, SystemErrorCode.METHOD_PARAMETER.getErrorCode(), HttpStatus.NOT_FOUND,
        null);
  }
}
