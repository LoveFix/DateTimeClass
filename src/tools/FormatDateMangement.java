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
	public static final String FULL_DATE_TIME_CHINA="yyyy��MM��dd��HHʱmm��ss��SSSS����";

	
	/***
	 * desc ���ո�������ʽpattern��ʽ��������source Date����
	 * @param source ������ʽ��Date����
	 * @param pattern ��ʽ����׼��ȡ�Ե�ǰFormatDateMangement�еĳ���
	 * SHORT_TIME  LONG_TIME SHOR_DATE LONG_DATE FULL_DATE_TIME_CHINA
	 * @return String����ʽ�����Date String��ʾ��ʽ
	 */
	
	public static String formatDateBypattern(Date source,String pattern) {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(source);
	}
	
	
  /**
   * �������������ϱ�׼������ʱ���ַ�����ʽת��ΪDate����	
   * @param dateStr �ַ������ڱ�ʾ��ʽ
   * @param pattern ��ʽ������
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
