package com.harsh.test.milestone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.test.milestone.dto.ResponseDepEmp;
import com.harsh.test.milestone.entity.Department;
import com.harsh.test.milestone.entity.Employee;
import com.harsh.test.milestone.repositorys.DepartmentRepository;
import com.harsh.test.milestone.servicesed.ServiceEmpDep;





@RestController

@RequestMapping("/api/empdep")
public class ControllerEmpDep {
	
	@Autowired
	ServiceEmpDep edservice;

	@Autowired
	DepartmentRepository depat; 

	
	public ControllerEmpDep(ServiceEmpDep edservice, DepartmentRepository depat) {
		super();
		this.edservice = edservice;
		this.depat = depat;
		
	}


	@PostMapping("/saveemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(edservice.addEmployee(emp), HttpStatus.CREATED);
	}

	
	@PostMapping("/savedepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department dep){
		return new ResponseEntity<Department>(edservice.addDepartment(dep), HttpStatus.CREATED);
	}

	@GetMapping("/getallemployee")
	public List<Employee> getAllEmployee(){
		return edservice.getAllEmployee();
	}
	
	@GetMapping("/getalldepartment")
	public List<Department> getAllDepartment(){
		return edservice.getAllDepartment();
	}
	
//	//updation 
	@PutMapping("/savedepartment/{depid}/{totalemp}")
	public  ResponseEntity<Department> updateTotalEmployee(@PathVariable("depid") long depid, @PathVariable("totalemp") int totalemp) {
		return new ResponseEntity<Department>(edservice.updateTotalEmployee(depid, totalemp), HttpStatus.CREATED);
	}


	// Testing JPQL Queries 
	@GetMapping("/getemployeebydepartment")
	public List<ResponseDepEmp> getEmployeeByDepName(String depname) {
		return edservice.getEmployeeByDepName(depname);
	}
	
	
	
	
}
