package cn.qsky.policesys.common.util;

import java.math.BigDecimal;

/**
 * 数学计算工具类，精度全部保留两位小时
 *
 * @author qsky
 */
public class DecimalUtil {

  /**
   * 提供精确乘法运算的mul方法
   *
   * @param value1 被乘数
   * @param value2 乘数
   * @return 两个参数的积
   */
  public static BigDecimal mul(BigDecimal value1, BigDecimal value2) {
    return value1.multiply(value2).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 提供精确乘法运算的mul方法
   *
   * @param value1 被乘数
   * @param value2 乘数
   * @return 两个参数的积
   */
  public static BigDecimal mul(BigDecimal value1, Long value2) {
    return mul(value1, BigDecimal.valueOf(value2));
  }

  /**
   * 提供精确加法计算的add方法
   *
   * @param value1 被加数
   * @param value2 加数
   * @return 两个参数的和
   */
  public static BigDecimal add(BigDecimal value1, BigDecimal value2) {
    return value1.add(value2).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 提供精确减法运算的sub方法
   *
   * @param value1 被减数
   * @param value2 减数
   * @return 两个参数的差
   */
  public static BigDecimal sub(BigDecimal value1, BigDecimal value2) {
    return value1.subtract(value2).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 提供精确减法运算的sub方法
   *
   * @param value1 被减数
   * @param value2 减数
   * @return 两个参数的差
   */
  public static BigDecimal sub(Integer value1, BigDecimal value2) {
    return sub(BigDecimal.valueOf(value1), value2);
  }

  /**
   * 提供（相对）精确的除法运算。
   *
   * @param value1 被除数
   * @param value2 除数
   * @return 两个参数的商
   */
  public static BigDecimal div(BigDecimal value1, BigDecimal value2) {
    return value1.divide(value2, 2, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 提供（相对）精确的除法运算。
   *
   * @param value1 被除数
   * @param value2 除数
   * @return 两个参数的商
   */
  public static BigDecimal div(BigDecimal value1, Integer value2) {
    return div(value1, BigDecimal.valueOf(value2));
  }

}
