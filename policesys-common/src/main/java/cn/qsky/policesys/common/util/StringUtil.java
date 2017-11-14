package cn.qsky.policesys.common.util;

/**
 * @author qsky
 */
public class StringUtil {

  /**
   * 拼接字符串StringBuilder实现
   *
   * @param str1 字符1
   * @param str2 字符2
   * @param strs 字符n
   * @return
   */
  public static String concat(String str1, String str2, String... strs) {
    StringBuilder sb = new StringBuilder();
    sb.append(str1);
    sb.append(str2);

    for (String str : strs) {
      sb.append(str);
    }

    return sb.toString();
  }

}
