package test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.junit.jupiter.api.Test;



import entity.Employee;

import tools.DateSupport;
import tools.FormatDateMangement;

class TestCase {
  DateSupport ds =new DateSupport();
	@Test
	void testCreateEmp() {
		String nameString="罗纳尔多";
		Date birth=new Date();
		Employee emp=ds.createEmp(nameString, birth);
		System.out.println(emp.getBirth().getYear()+1900+"年"+emp.getBirth().getMonth()+1+"-"+emp.getBirth().getDate());
	}
	
	
	@Test
void testEqEmpBirth() {
		Employee e0=new Employee("令狐冲",new Date(new Date().getTime()-100000));
		Employee e2=new Employee("任盈盈",new Date(new Date().getTime()-100));
		System.out.println(ds.eqEmpBirth(e0, e2));
		
	}
	
	
	@Test
	void testChangeDateStaus() {
		
		Date d0=new Date(12345678);
		int tag=2;
		long num=1000;
		Date d2= ds.changeDateStatus(d0, num, tag);
		d2.setTime(num);
		System.out.println(d2.getTime());
	}
	
	
	@Test
	void testToStringForDate() {
	Date d0=new Date(31231232141L);
		
	System.out.println(d0.toString());
	
	}
	
	
	/***
	 * 利用DateFormat实现Date对象的格式化输出
	 * 
	 */
	@Test
	void useDateFormat() {
		Date d0=new Date(12345678228L);
		DateFormat df=DateFormat.getDateInstance();
		//以默认形式实现对给定的Date对象格式化
		System.out.println(df.format(d0));
		
		//使用给定的格式化构建DateFormat
		
		DateFormat df0=DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat df1=DateFormat.getDateInstance(DateFormat.FULL);
		
		
		System.out.println(df0.format(d0));
		System.out.println(df1.format(d0));
	}
	@Test
	public void testUseSimpleDateFormat() {
		Date d0=new Date(3131212L);
		SimpleDateFormat sdf0=new SimpleDateFormat(); 
		System.out.println("SimpleDateFormat默认格式化日期对象"+sdf0.format(d0));
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyy-MM-dd a",Locale.ENGLISH); 
		System.out.println("SimpleDateFormat默认格式化日期对象"+sdf2.format(d0));
	}
	
	@Test
	public void testFormatDateBypatternMethod() {
		Date d0=new Date(31231231L);
		String res=	FormatDateMangement.formatDateBypattern(d0, FormatDateMangement.FULL_DATE_TIME_CHINA);
		
		System.out.println("格式化结果"+res);
		
		
	}
	@Test
    public void testfromStringToDateByPatternMethod() {
	String datestr="2017-12-24";
	Date  resDate=FormatDateMangement.fromStringToDateByPattern(datestr,FormatDateMangement.SHOR_DATE );
	System.out.println(resDate.toLocaleString());
	
	
	}
	
	
	@Test
	public void testCreateCalendar() {
		
		Calendar cal=Calendar.getInstance();
		//获取与当前系统平台相关的默认日历对象
		System.out.println("当前是"+cal.get(Calendar.YEAR)+"年"+cal.get(Calendar.MONTH)+"月"+
		cal.get(Calendar.DATE)+"日");
		
	Calendar cal2=Calendar.getInstance(Locale.ENGLISH);
	
	Date engDate=cal2.getTime();
	System.out.println(new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss",Locale.ENGLISH).format(engDate));
	
	}
	
	@Test
	public void testformatDateByTags() {
		
		Scanner in =new Scanner(System.in);
		System.out.println("输入生日年");
		int y=in.nextInt();
		System.out.println("输入生日月");
		int m=in.nextInt();
		System.out.println("输入生日天");
		int d=in.nextInt();
		Object	obj= DateSupport.formatDateByTags(y, m, d, 0);
		if(obj !=null && obj instanceof java.util.Date) {
			System.out.println(((Date)obj).toLocaleString());
		}
		
	}
	
	@Test
	public void testModifyBirth() {
		Date birth=new Date(312312132L);
		Employee employee=new Employee("萨马兰奇",birth);
		System.out.println("未修改前生日"+new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirth()));
		DateSupport.modifyBirth(employee, 3, 1, 1);
		System.out.println("修改后前生日"+new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirth()));
	}
	
	
	@Test
	public void testCompDate() {
		Date birth=new Date(1231212312L);
		Date birth2=new Date(313123122L);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(birth));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(birth2));
		System.out.println("最后比较的天数差是"+DateSupport.compDate(birth, birth2));
		
		
	}

}
