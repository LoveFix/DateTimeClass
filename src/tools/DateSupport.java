package tools;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;



import entity.Employee;


/***
 * 
 * @author 七凉
 *
 */

public class DateSupport {
 public Employee createEmp(String name,Date birth) {
	 return new Employee(name,birth);

}
 

 public String eqEmpBirth(Employee e0,Employee e2) {
	 return e0.getBirth().after(e2.getBirth())?e0.getName()+"比"+e2.getName()+"出生更早"
			 :"2人的生日可能相同或者"+e2.getName()+"出生日期比"+e0.getName()+"更晚";

}
 
 
 /**
  * 对给定的date对象实现时间的运算，如果tag大于0
  * 则date增加num毫秒，如果tag小于0 则date减少num毫秒
  * @param date
  * @param num
  * @param tag
  * @return Date
  */
 
 public Date changeDateStatus(Date date,long num,int tag) {
	 	
	 if(tag>0) {//对date实现增加num毫秒
		 
		 date.setTime(date.getTime()+num);
	 }
	 
	 else {//对date实现减少num毫秒
		date.setTime(date.getTime()-num); 
	 }
	 return new Date();	 
 }
 
 /**
  * 根据给定的tags标准对给定的y年，m月，d日组合为String或Date对象返回
  * @param y 年份
  * @param m 月份
  * @param d 天
  * @param tags 取值为0或1 0代表转换为Date 1转换为String
  * @return 返回符合tags所标志的Object对象(String OR Date)
  */
 
 public static Object formatDateByTags(int y,int m,int d,int tags) {
	
	 Calendar cal =Calendar.getInstance();
	 cal.set(Calendar.YEAR, y);
	 cal.set(Calendar.MONTH, m-1);
	 cal.set(Calendar.DATE, d);
	 if(tags==0)
		 return cal.getTime();
	 	 //	返回Date对象
	 return new SimpleDateFormat("yyyy年MM月dd日").format(cal.getTime());
 }
 
 
 /**
  * 对给定的员工生日进行操作，对年，或月，或日进行增减
  * @param emp 员工对象
  * @param num 增减的数（正数为增加，负数为减少）
  * @param dateTag 表示对那部分日期进行修改（1=年；2=月；3=日期）
  * @param addOrSub （1=增加；-1=减少）
  */
 public static void modifyBirth(Employee emp,int num,int dateTag,int addOrSub) {
	Date birth=emp.getBirth();
	
	Calendar calendar=Calendar.getInstance();
	
	calendar.setTimeInMillis(birth.getTime());
    //此时的日期和生日都是一样的
	
	if(addOrSub >0) {//对日期部分进行增
		if(dateTag ==1)//对年份进行增加
			calendar.add(calendar.YEAR, num);
		if(dateTag ==0)//对月份进行增加
			calendar.add(calendar.MONTH, num);
		if(dateTag ==-1)//对天份进行增加
			calendar.add(calendar.DATE, num);
	}
	else {
		if(dateTag ==1)//对年份进行减少
			calendar.add(calendar.YEAR, num);
		if(dateTag ==0)//对月份进行减少
			calendar.add(calendar.MONTH, num);
		if(dateTag ==-1)//对天份进行减少
			calendar.add(calendar.DATE, num);
	}
	
	emp.setBirth(calendar.getTime());
}
 
 /**
  * 比较两个日期的天数差 并以正数的方式返回
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
