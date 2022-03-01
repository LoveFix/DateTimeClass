package entity;

import java.util.Date;

public class Employee {

	private String name;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public Employee() {
		super();
	}
	public Employee(String name, Date birth) {
		super();
		this.name = name;
		this.birth = birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
