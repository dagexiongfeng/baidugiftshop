package baidu.giftshop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {

	/**
	 * ��������ת��Ϊʱ���
	 * 
	 * @param str
	 *            ��ת�����ַ���
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
	 * ��ʱ���ת��Ϊ������
	 * 
	 * @param str
	 *            ��ת�����ַ���
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
	 * ��ȡ��ǰʱ���ʱ���
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
	 * ��ȡ��ǰʱ��ĺ�����
	 * 
	 * @return
	 */
	public static String getCurLong() {
		long sd = System.currentTimeMillis();
		return String.valueOf(sd);
	}

	/**
	 * ���ݵ�ǰ���µ�ʱ���
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
	 * ���ָ�����µ�ʱ���
	 * 
	 * @param str
	 *            ָ��ʱ����ַ���
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
	 * ��õ�ǰ�����ʱ���
	 * 
	 * @return
	 */
	public static String getNextYear() {
		String str = getCurString();
		return str.substring(0, 4) + "-12-31";
	}

	/**
	 * ����ָ��ʱ�������ʱ���
	 * 
	 * @param str
	 *            ָ��ʱ����ַ���
	 * @return
	 */
	public static String getNextYear(String str) {
		return str.substring(0, 4) + "-12-31";
	}

}
