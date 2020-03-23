package com.fire.back.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by dragon on 2017/4/10.
 */
public class TimeTools {
	private static Date date;

	// 时间格式数组
	private static String[] formatArray = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm",
			"yyyy-MM-dd HH:mm:ss", "yy-MM-dd HH:mm", "yyyyMMdd HH:mm",
			"yyyy-MM-dd HH" };

	// 检测一个时间格式是否为合法格式
	public static boolean isRightFormat(String formatStr) {
		boolean isRight = false;
		int j = formatArray.length;
		for (int i = 0; i < j; i++) {
			if (formatArray[i].equalsIgnoreCase(formatStr)) {
				isRight = true;
				break;
			}
		}
		return isRight;
	}

	/*
	 * 时间戳转换为TimeStamp格式,获取13位时间戳
	 */
	public static long getTimeStamp(String timeStr) {
		try {
			if (timeStr.split(":").length == 3) {
				SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				date = simpleDateFormat5.parse(timeStr);
			} else if (timeStr.split(":").length == 2) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm");
				date = simpleDateFormat.parse(timeStr);// 对传入的字符串进行解析 得到date
			} else if (timeStr.split("-").length == 3 && !timeStr.contains(":")) {
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
						"yyyy-MM-dd");
				date = simpleDateFormat2.parse(timeStr);
			} else if (timeStr.split("-").length == 2 && !timeStr.contains(":")) {
				SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(
						"yyyy-MM");
				date = simpleDateFormat3.parse(timeStr);
			} else if (!timeStr.contains("-")) {
				SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(
						"yyyy");
				date = simpleDateFormat4.parse(timeStr + "-01-01");
			}
		} catch (ParseException e) {
		}
		long timeStamp = date.getTime();// 再获得date的时间戳 此时是13位
										// 所以要存到我们的数据库在外面还要/1000
		return timeStamp;
	}

	public static long getCircleStamp(String timeStr) {
		// 传进来的可能是年 月 或者日 或者小时 或者分钟 得到到下一周期的时间戳 比如传入2016年 得到2017年
		try {
			if (timeStr.split(":").length == 2) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm");
				date = simpleDateFormat.parse(timeStr);
			}
			if (timeStr.split("-").length == 3 && !timeStr.contains(":")) {
				String[] times = timeStr.split("-");
				if (times[2].length() > 2) {
					SimpleDateFormat simpleDateFormat7 = new SimpleDateFormat(
							"yyyy-MM-dd HH");
					date = simpleDateFormat7.parse(timeStr);
				} else {
					SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
							"yyyy-MM-dd");
					date = simpleDateFormat2.parse(timeStr);
				}
			}
			if (timeStr.split("-").length == 2 && !timeStr.contains(":")) {
				SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(
						"yyyy-MM");
				String[] timeStrs = timeStr.split("-");
				if (timeStrs[1].equals("12")) {
					date = simpleDateFormat3.parse((Integer
							.parseInt(timeStrs[0]) + 1) + "-01");
				} else {
					date = simpleDateFormat3.parse(timeStrs[0] + "-"
							+ (Integer.parseInt(timeStrs[1]) + 1));
				}
			}
			if (!timeStr.contains("-")) {
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
						"yyyy-MM-dd");
				date = simpleDateFormat2.parse((Integer.parseInt(timeStr) + 1)
						+ "-01-01");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timeStamp = date.getTime();// 再获得date的时间戳 此时是13位
										// 所以要存到我们的数据库在外面还要/1000
		if (timeStr.split("-").length == 3 && !timeStr.contains(":")) {
			String[] times = timeStr.split("-");
			if (times[2].length() > 2) {
				timeStamp += 3600000;
			} else {
				timeStamp += 86400000;
			}
		}
		if (timeStr.split(":").length == 2) {
			timeStamp += 60000;
		}
		return timeStamp;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 格式化后的时间字符串 yyyy-MM-dd HH:mm:ss
	 */
	public static String timeStamp2Second(long timeStamp) {
		SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String res;
		long lt = new Long(timeStamp);
		Date date = new Date(lt);
		res = simpleDateFormat5.format(date);
		return res;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 格式化后的时间字符串yyyy-MM-dd HH时
	 */
	public static String timeStamp2Hour(long timeStamp) {
		SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat(
				"yyyy-MM-dd HH时");
		String res;
		long lt = new Long(timeStamp);
		Date date = new Date(lt);
		res = simpleDateFormat6.format(date);
		return res;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 格式化后的时间字符串yyyy-MM-dd HH
	 */
	public static String timeStamp2Hour2(long timeStamp) {
		SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat(
				"yyyy-MM-dd HH");
		String res;
		long lt = new Long(timeStamp);
		Date date = new Date(lt);
		res = simpleDateFormat6.format(date);
		return res;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 格式化后的时间字符串yyyy-MM-dd
	 */
	public static String timeStamp2Day(long timeStamp) {
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String res;
		long lt = new Long(timeStamp);
		Date date = new Date(lt);
		res = simpleDateFormat2.format(date);
		return res;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 格式化后的时间字符串yyyy-MM
	 */
	public static String timeStamp2Month(long timeStamp) {
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM");
		String res;
		long lt = new Long(timeStamp);
		Date date = new Date(lt);
		res = simpleDateFormat3.format(date);
		return res;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 格式化后的时间字符串yyyy
	 */
	public static String timeStamp2Year(long timeStamp) {
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy");
		String res;
		long lt = new Long(timeStamp);
		Date date = new Date(lt);
		res = simpleDateFormat4.format(date);
		return res;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 格式化后的时间字符串yyyy-MM-dd HH:mm
	 */
	public static String timeStamp2Minute(long timeStamp) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		String res;
		long lt = new Long(timeStamp);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * @param timeStamp
	 *            毫秒数
	 * @return 返回数组长度为4的数组，前两位是long类型，后两位是字符串， [1519574400000, 1520179199999, 2018-02-26, 2018-03-04]
	 */
	public static Object[] getThisWeekStartAndEnd(long timeStamp) {
		Object[] l = new Object[4];
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(timeStamp));
		int w = cal.get(7);
		String start = "";
		if (w > 2) {
			start = timeStamp2Day(timeStamp - ((w - 2) * 86400000L));
		} else if (w == 2) {
			start = timeStamp2Day(timeStamp);
		} else if (w < 2) {
			start = timeStamp2Day(timeStamp - (6 * 86400000L));
		}
		l[2] = start;
		Long startL = getTimeStamp(start);
		l[0] = startL;
		l[1] = startL + (7 * 86400000L) - 1;
		l[3] = timeStamp2Day(startL + (7 * 86400000L) - 1);
		return l;
	}

	/**
	 * 根据指定格式format将日期时间字符串strDate转换为毫秒数
	 * @param strDate 要转换的日期时间
	 * @param format 按照哪种格式转换
	 * @return 转换后的毫秒数
	 */
	public static Long StrDate2MS(String strDate, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		long millSeconds = new GregorianCalendar().getTimeInMillis();
		try {
			millSeconds = sdf.parse(strDate).getTime();
		} catch (Exception e) {
			// logger.error("---------get seconds error:"+e.getMessage());
		}
		return new Long(millSeconds);
	}

	/**
	 * @todo 将数值时间格式化为字符串
	 * @param milliSeconds
	 * @param formatStr
	 * @return
	 */
	public static String secondsToDateStr(Long milliSeconds, String formatStr) {

		if (milliSeconds == null)
			return "";
		if (isRightFormat(formatStr) == false) {
			formatStr = "yyyy-MM-dd HH:mm:ss";
		}
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);

			if (milliSeconds.longValue() > 1) {
				GregorianCalendar gCalendar = new GregorianCalendar();
				gCalendar.setTimeInMillis(milliSeconds.longValue());
				return dateFormat.format(gCalendar.getTime());
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 获取上月第一天零点毫秒数，13位
	 * 
	 * @return 举例：当前时间2018-02-22 00:00:00 返回值1514736000000
	 */
	public static long getLastMonthStartSeconds() {
		Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		rightNow.setTimeInMillis(getMonthStartSeconds());
		rightNow.set(Calendar.MONTH, rightNow.get(Calendar.MONTH) - 1);
		return rightNow.getTimeInMillis();
	}

	/**
	 * 获取本月第一天零点毫秒数，13位
	 * 
	 * @return 举例：当前时间2018-02-22 00:00:00 返回值1517414400000
	 */
	public static long getMonthStartSeconds() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = null;
		cale = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		String first = format.format(cale.getTime());
		return getTimeStamp(first);
	}

	/**
	 * 获取本周第一天零点毫秒数，13位
	 * 
	 * @return 举例：当前时间2018-02-22 16:00:00 返回值1518969600000
	 */
	public static long getWeekStartSeconds() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = null;
		cale = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		cale.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		String first = format.format(cale.getTime());
		return getTimeStamp(first);
	}

}
