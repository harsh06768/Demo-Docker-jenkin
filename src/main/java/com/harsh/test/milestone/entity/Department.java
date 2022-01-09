package com.harsh.test.milestone.entity;

import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_department")
public class Department {

	@Id
	@Column(name = "dep_id", nullable = false)
	private long depid;
	@Column(name = "dep_name")
	private String depname; 
	@Column(name = "total_emp")
	private int totalemp; 
	
	@OneToMany(mappedBy= "dep" ,cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Employee> employee;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Department(long depid, String depname, int totalemp, List<Employee> employee) {
		super();
		this.depid = depid;
		this.depname = depname;
		this.totalemp = totalemp;
		this.employee = employee;
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
	
	
	

	public int getTotalemp() {
		return totalemp;
	}


	public void setTotalemp(int totalemp) {
		this.totalemp = totalemp;
	}


	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}


	
}
