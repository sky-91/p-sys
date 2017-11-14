package cn.qsky.policesys.core.generator.exception.enums;

/**
 * 生成编码异常偏移量定义枚举
 *
 * @author jiangbin on 2017/6/18.
 */
public enum GeneratorErrorCode {

  /**
   * 配置未找到
   */
  NOT_FOUND(1),

  /**
   * 流水码并发访问
   */
  VERSION_LOCKED(2),

  /**
   * 未知主机
   */
  UNKNOWN_HOST(3),

  /**
   * 时间错误
   */
  TIMESTAMP(4),

  /**
   * 分布式工作id错误
   */
  WORKER_ID(5);

  private Integer errorCode;

  GeneratorErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public Integer getErrorCode() {
    return errorCode;
  }

}
