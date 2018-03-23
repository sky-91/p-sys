package cn.qsky.policesys.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qsky
 */
public class StringUtil {

  private static final String SAVE_KEY = "save";
  private static final String UPDATE_KEY = "update";
  private static final String FAILED_KEY = "failed";

  /**
   * 拼接字符串StringBuilder实现
   *
   * @param str1 字符1
   * @param str2 字符2
   * @param strs 字符n
   * @return string
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

  public static <T> Map<String, List<T>> generateMap(List<T> saveList, List<T> updateList,
      List<T> failedList) {
    Map<String, List<T>> map = new HashMap<>(16);
    map.put(SAVE_KEY, saveList);
    map.put(UPDATE_KEY, updateList);
    map.put(FAILED_KEY, failedList);
    return map;
  }
}
