package baidu.giftshop.frk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {

	/**
	 * 将毫秒数转变为时间戳
	 * 
	 * @param str
	 *            待转换的字符串
	 * @return
	 */
	public static String longToString(String str) {
		long sd = Long.parseLong(str);
		Date dat = new Date(sd);
		Calendar gc = Calendar.getInstance();
		gc.setTime(dat);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String sb = format.format(gc.getTime());
		return sb;
	}

	/**
	 * 将时间戳转变为毫秒数
	 * 
	 * @param str
	 *            待转换的字符串
	 * @return
	 */
	public static String stringToLong(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(str);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return String.valueOf(cal.getTimeInMillis());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}

	/**
	 * 获取当前时间的时间戳
	 * 
	 * @return
	 */
	public static String getCurString() {
		long sd = System.currentTimeMillis();
		Date dat = new Date(sd);
		Calendar gc = Calendar.getInstance();
		gc.setTime(dat);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String sb = format.format(gc.getTime());
		return sb;
	}

	/**
	 * 获取当前时间的毫秒数
	 * 
	 * @return
	 */
	public static String getCurLong() {
		long sd = System.currentTimeMillis();
		return String.valueOf(sd);
	}

	/**
	 * 根据当前月月底时间戳
	 * 
	 * @return
	 */
	public static String getNextMonth() {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.MONTH, 1);
		ca.set(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(ca.getTime());
	}

	/**
	 * 获得指定月月底时间戳
	 * 
	 * @param str
	 *            指定时间的字符串
	 * @return
	 */
	public static String getNextMonth(String str) {
		long sd = Long.parseLong(stringToLong(str));
		Date dat = new Date(sd);
		Calendar gc = Calendar.getInstance();
		gc.setTime(dat);
		gc.add(Calendar.MONTH, 1);
		gc.set(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(gc.getTime());
	}

	/**
	 * 获得当前年年底时间戳
	 * 
	 * @return
	 */
	public static String getNextYear() {
		String str = getCurString();
		return str.substring(0, 4) + "-12-31";
	}

	/**
	 * 根据指定时间获得年底时间戳
	 * 
	 * @param str
	 *            指定时间的字符串
	 * @return
	 */
	public static String getNextYear(String str) {
		return str.substring(0, 4) + "-12-31";
	}

}
