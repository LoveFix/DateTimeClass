package tools;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;



import entity.Employee;


/***
 * 
 * @author ����
 *
 */

public class DateSupport {
 public Employee createEmp(String name,Date birth) {
	 return new Employee(name,birth);

}
 

 public String eqEmpBirth(Employee e0,Employee e2) {
	 return e0.getBirth().after(e2.getBirth())?e0.getName()+"��"+e2.getName()+"��������"
			 :"2�˵����տ�����ͬ����"+e2.getName()+"�������ڱ�"+e0.getName()+"����";

}
 
 
 /**
  * �Ը�����date����ʵ��ʱ������㣬���tag����0
  * ��date����num���룬���tagС��0 ��date����num����
  * @param date
  * @param num
  * @param tag
  * @return Date
  */
 
 public Date changeDateStatus(Date date,long num,int tag) {
	 	
	 if(tag>0) {//��dateʵ������num����
		 
		 date.setTime(date.getTime()+num);
	 }
	 
	 else {//��dateʵ�ּ���num����
		date.setTime(date.getTime()-num); 
	 }
	 return new Date();	 
 }
 
 /**
  * ���ݸ�����tags��׼�Ը�����y�꣬m�£�d�����ΪString��Date���󷵻�
  * @param y ���
  * @param m �·�
  * @param d ��
  * @param tags ȡֵΪ0��1 0����ת��ΪDate 1ת��ΪString
  * @return ���ط���tags����־��Object����(String OR Date)
  */
 
 public static Object formatDateByTags(int y,int m,int d,int tags) {
	
	 Calendar cal =Calendar.getInstance();
	 cal.set(Calendar.YEAR, y);
	 cal.set(Calendar.MONTH, m-1);
	 cal.set(Calendar.DATE, d);
	 if(tags==0)
		 return cal.getTime();
	 	 //	����Date����
	 return new SimpleDateFormat("yyyy��MM��dd��").format(cal.getTime());
 }
 
 
 /**
  * �Ը�����Ա�����ս��в��������꣬���£����ս�������
  * @param emp Ա������
  * @param num ��������������Ϊ���ӣ�����Ϊ���٣�
  * @param dateTag ��ʾ���ǲ������ڽ����޸ģ�1=�ꣻ2=�£�3=���ڣ�
  * @param addOrSub ��1=���ӣ�-1=���٣�
  */
 public static void modifyBirth(Employee emp,int num,int dateTag,int addOrSub) {
	Date birth=emp.getBirth();
	
	Calendar calendar=Calendar.getInstance();
	
	calendar.setTimeInMillis(birth.getTime());
    //��ʱ�����ں����ն���һ����
	
	if(addOrSub >0) {//�����ڲ��ֽ�����
		if(dateTag ==1)//����ݽ�������
			calendar.add(calendar.YEAR, num);
		if(dateTag ==0)//���·ݽ�������
			calendar.add(calendar.MONTH, num);
		if(dateTag ==-1)//����ݽ�������
			calendar.add(calendar.DATE, num);
	}
	else {
		if(dateTag ==1)//����ݽ��м���
			calendar.add(calendar.YEAR, num);
		if(dateTag ==0)//���·ݽ��м���
			calendar.add(calendar.MONTH, num);
		if(dateTag ==-1)//����ݽ��м���
			calendar.add(calendar.DATE, num);
	}
	
	emp.setBirth(calendar.getTime());
}
 
 /**
  * �Ƚ��������ڵ������� ���������ķ�ʽ����
  * @param date0
  * @param date2
  * @return
  */
 public static long compDate(Date date0,Date date2) {
	 long res=0;
	 long date0Long=date0.getTime();
	 long date2Long=date2.getTime();
	 long sub=Math.abs(date0Long-date2Long);
	 
	 
	 return sub/1000/60/60/24;
 }
}
