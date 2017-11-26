package cn.qsky.policesys.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

/**
 * @author qsky on 17/11/22
 */
public class Md5Util {

  /**
   * 利用MD5进行加密
   *
   * @param str 待加密的字符串
   * @return 加密后的字符串
   */
  public static String encoderByMd5(String str) {
    try {
      //确定计算方法
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      BASE64Encoder base64en = new BASE64Encoder();
      //加密后的字符串
      return base64en.encode(md5.digest(str.getBytes("utf-8")));
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return StringUtils.EMPTY;
  }

  /**
   * 判断用户密码是否正确
   *
   * @param newPassword 用户输入的密码
   * @param oldPassword 数据库中存储的密码－－用户密码的摘要
   */
  public static boolean checkPassword(String newPassword, String oldPassword) {
    if (encoderByMd5(newPassword).equals(oldPassword)) {
      return true;
    } else {
      return false;
    }
  }
}
