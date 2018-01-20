package cn.qsky.policesys.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

/**
 * @author qsky
 */
public class DateUtil {

  /**
   * Number of milliseconds in a standard second.
   */
  public static final long MILLIS_PER_SECOND = 1000;

  /**
   * Number of milliseconds in a standard minute.
   */
  public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;

  /**
   * Number of milliseconds in a standard hour.
   */
  public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

  /**
   * Number of milliseconds in a standard day.
   */
  public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

  /**
   * ISO8601 formatter for date without time zone. The format used is
   * <tt>yyyy-MM-dd</tt>.
   */
  public static final FastDateFormat DATE_FORMAT = FastDateFormat
      .getInstance("yyyy-MM-dd");

  /**
   * ISO8601 formatter for date-time without time zone. The format used is
   * <tt>yyyy-MM-dd HH:mm:ss</tt>.
   */
  public static final FastDateFormat DATETIME_FORMAT = FastDateFormat
      .getInstance("yyyy-MM-dd HH:mm:ss");

  /**
   * Compact ISO8601 date format yyyyMMdd
   */
  public static final String COMPACT_DATE_FORMAT_PATTERN = "yyyyMMdd";

  /**
   * ISO8601 date format: yyyy-MM-dd
   */
  public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

  /**
   * ISO8601 date-time format: yyyy-MM-dd HH:mm:ss
   */
  public static final String DATETIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

  /**
   * 获取当前日期
   */
  public static Date getCurrentDate() {
    return new Date();
  }

  /**
   * 获取当前年份
   */
  public static int getCurrentYear() {
    return Calendar.getInstance().get(Calendar.YEAR);
  }

  /**
   * 将日期字符串转换为标准日期格式yyyy-MM-dd
   *
   * @param str 日期字符串
   */
  public static Date parse(String str) {
    return parse(str, DATE_FORMAT_PATTERN);
  }

  /**
   * 将日期字符串转换为指定的日期格式
   *
   * @param str 日期字符串
   * @param pattern 日期格式
   */
  public static Date parse(String str, String pattern) {
    if (StringUtils.isBlank(str)) {
      return null;
    }
    DateFormat parser = new SimpleDateFormat(pattern);
    try {
      return parser.parse(str);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Can't parse " + str + " using "
          + pattern);
    }
  }

  /**
   * 将日期转换为指定的字符串格式
   *
   * @param date 日期
   * @param pattern 字符串格式
   */
  public static String format(Date date, String pattern) {
    if (date == null) {
      return null;
    }
    FastDateFormat df = FastDateFormat.getInstance(pattern);
    return df.format(date);
  }

  /**
   * 将日期转换为标准的字符串格式yyyy-MM-dd
   *
   * @param date 日期
   */
  public static String format(Date date) {
    return date == null ? null : DATE_FORMAT.format(date);
  }

  /**
   * 将当前日期转换为标准的字符串格式yyyy-MM-dd
   */
  public static String getCurrentDateAsString() {
    return DATE_FORMAT.format(new Date());
  }

  /**
   * 将当前日期转换为指定的字符串格式
   *
   * @param pattern 字符串格式
   */
  public static String getCurrentDateAsString(String pattern) {
    FastDateFormat formatter = FastDateFormat.getInstance(pattern);
    return formatter.format(new Date());
  }

  /**
   * 将当前日期转换为标准的字符串格式yyyy-MM-dd HH:mm:ss
   */
  public static String getCurrentDateTimeAsString() {
    return DATETIME_FORMAT.format(new Date());
  }

  /**
   * 获得当月的最早一天，精确到秒
   */
  public static Date getStartDateTimeOfCurrentMonth() {
    return getStartDateTimeOfMonth(new Date());
  }

  /**
   * 给定日期，获得给定日期当月的最早一天，精确到秒
   *
   * @param date 给定日期
   */
  public static Date getStartDateTimeOfMonth(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    return cal.getTime();
  }

  /**
   * 获得当月的最晚一天，精确到秒
   */
  public static Date getEndDateTimeOfCurrentMonth() {
    return getEndDateTimeOfMonth(new Date());
  }

  /**
   * 给定日期，获得给定日期当月的最晚一天，精确到秒
   *
   * @param date 给定日期
   */
  public static Date getEndDateTimeOfMonth(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH,
        cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    return cal.getTime();
  }

  /**
   * 获得当天的最早时间，精确到秒
   */
  public static Date getStartTimeOfCurrentDate() {
    return getStartTimeOfDate(new Date());
  }

  /**
   * 给定日期，获得给定日期当天的最早时间，精确到秒
   *
   * @param date 给定日期
   */
  public static Date getStartTimeOfDate(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    return cal.getTime();
  }

  /**
   * 获得当天的最晚时间，精确到秒
   */
  public static Date getEndTimeOfCurrentDate() {
    return getEndTimeOfDate(new Date());
  }

  /**
   * 给定日期，获得给定日期当天的最晚时间，精确到秒
   *
   * @param date 给定日期
   */
  public static Date getEndTimeOfDate(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    return cal.getTime();
  }

  /**
   * 给日期，添加小时
   *
   * @param date 日期
   * @param hours 添加小时数
   */
  public static Date addHours(Date date, int hours) {
    return add(date, Calendar.HOUR_OF_DAY, hours);
  }

  /**
   * 给日期，添加分钟
   *
   * @param date 日期
   * @param minutes 添加的分钟数
   */
  public static Date addMinutes(Date date, int minutes) {
    return add(date, Calendar.MINUTE, minutes);
  }

  /**
   * 给日期，添加天数
   *
   * @param date 日期
   * @param days 添加的天数
   */
  public static Date addDays(Date date, int days) {
    return add(date, Calendar.DATE, days);
  }

  /**
   * 给日期，添加月份
   *
   * @param date 日期
   * @param months 添加的月份数
   */
  public static Date addMonths(Date date, int months) {
    return add(date, Calendar.MONTH, months);
  }

  /**
   * 给日期，添加年数
   *
   * @param date 日期
   * @param years 添加的年数
   */
  public static Date addYears(Date date, int years) {
    return add(date, Calendar.YEAR, years);
  }

  /**
   * 给日期，添加时间
   *
   * @param date 日期
   * @param field 添加的时间单位(分钟,日,月,年)
   * @param amount 添加的数量
   */
  private static Date add(Date date, int field, int amount) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(field, amount);
    return cal.getTime();
  }

  /**
   * 两段时间相差的天数
   *
   * @param early 较早的一段时间
   * @param late 较晚的一段时间
   */
  public static final int daysBetween(Date early, Date late) {
    Calendar ecal = Calendar.getInstance();
    Calendar lcal = Calendar.getInstance();
    ecal.setTime(early);
    lcal.setTime(late);

    long etime = ecal.getTimeInMillis();
    long ltime = lcal.getTimeInMillis();

    return (int) ((ltime - etime) / MILLIS_PER_DAY);
  }

  /**
   * 两段时间相差的天数
   *
   * @param early 较早的一段时间(yyyyMMdd)
   * @param late 较晚的一段时间(yyyyMMdd)
   */
  public static final int daysBetween(String early, String late) {
    Calendar ecal = Calendar.getInstance();
    Calendar lcal = Calendar.getInstance();
    Date earlyDate = parse(early, COMPACT_DATE_FORMAT_PATTERN);
    Date lateDate = parse(late, COMPACT_DATE_FORMAT_PATTERN);
    ecal.setTime(earlyDate);
    lcal.setTime(lateDate);

    long etime = ecal.getTimeInMillis();
    long ltime = lcal.getTimeInMillis();

    return (int) ((ltime - etime) / MILLIS_PER_DAY);
  }

  /**
   * 指定日期是否在两个日期段之间
   *
   * @param startDate 开始时间
   * @param endDate 截止时间
   * @param startTrainDate 指定日期
   */
  public static final boolean isLimitDate(String startDate, String endDate,
      String startTrainDate) {
    if (startTrainDate.compareTo(startDate) >= 0
        && startTrainDate.compareTo(endDate) <= 0) {
      return true;
    }
    return false;
  }

  /**
   * 根据指定的年月日生成日期
   * @param year 年
   * @param month 月
   * @param day 日
   * @return 日期
   */
  public static final Date setPointDate(int year, int month, int day) {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month, day);
    return cal.getTime();
  }
}
