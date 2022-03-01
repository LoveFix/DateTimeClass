package tools;

import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;





public class FormatDateMangement {

	public static final String SHORT_TIME="h:m:s";
	public static final String LONG_TIME="HH:mm:ss:SSSS";
	public static final String SHOR_DATE="YY-M-d";
	public static final String LONG_DATE="yyyy/MM/dd";
	public static final String FULL_DATE_TIME_CHINA="yyyy年MM月dd日HH时mm分ss秒SSSS毫秒";

	
	/***
	 * desc 按照给定的样式pattern格式化给定的source Date对象
	 * @param source 欲被格式的Date对象
	 * @param pattern 格式化标准，取自当前FormatDateMangement中的常量
	 * SHORT_TIME  LONG_TIME SHOR_DATE LONG_DATE FULL_DATE_TIME_CHINA
	 * @return String被格式化后的Date String表示形式
	 */
	
	public static String formatDateBypattern(Date source,String pattern) {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(source);
	}
	
	
  /**
   * 将给定给定符合标准的日期时间字符串形式转换为Date对象	
   * @param dateStr 字符串日期表示形式
   * @param pattern 格式化参数
   * @return Date
   */
	
	public static Date fromStringToDateByPattern(String dateStr,String pattern) {
		
		Date target=null;
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		try {
			target =sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target;
	
	}
	
	
	
}
