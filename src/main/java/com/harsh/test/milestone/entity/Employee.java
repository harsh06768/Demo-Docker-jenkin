package com.harsh.test.milestone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "tbl_employee")
public class Employee {

	@Id
	@Column(name = "emp_id", nullable = false)
	private long empid;
	@Column(name = "emp_name")
	private String empname; 
	@Column(name = "emp_salary")
	private long salary; 
	@Column(name = "emp_gender")
	private String gender;
	@Column(name = "emp_age")
	private int age;
	
	
	@ManyToOne(cascade = CascadeType.ALL )
	@JsonBackReference
	private Department dep ;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(long empid, String empname, long salary, String gender, int age, Department dep) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.gender = gender;
		this.age = age;
		this.dep = dep;
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


	public Department getDep() {
		return dep;
	}


	public void setDep(Department dep) {
		this.dep = dep;
	}
	
	
	
}
