package com.harsh.test.milestone.dto;

public class ResponseDepEmp {

	private long depid;
	private String depname;
	private long empid;
	private String empname;
	private long salary; 
	private String gender;
	private int age;
	
	
	public ResponseDepEmp() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public ResponseDepEmp(long depid, String depname, long empid, String empname, long salary, String gender, int age) {
		super();
		this.depid = depid;
		this.depname = depname;
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.gender = gender;
		this.age = age;
	}





	public long getEmpid() {
		return empid;
	}


	public void setEmpid(long empid) {
		this.empid = empid;
	}


	public String getEmpname() {
		return empname;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public long getDepid() {
		return depid;
	}


	public void setDepid(long depid) {
		this.depid = depid;
	}


	public String getDepname() {
		return depname;
	}


	public void setDepname(String depname) {
		this.depname = depname;
	} 
	
	
	
	
}
