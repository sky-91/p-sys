package cn.qsky.policesys.core.generator;

/**
 * @author qsky on 17/11/13
 */
public interface GeneratorService {

  /**
   * 生成数据库主键
   *
   * @return 主键long
   */
  Long generatePK();
}
