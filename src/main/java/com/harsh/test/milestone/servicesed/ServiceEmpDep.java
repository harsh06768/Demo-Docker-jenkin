package com.harsh.test.milestone.servicesed;

import java.util.List;

import com.harsh.test.milestone.dto.ResponseDepEmp;
import com.harsh.test.milestone.entity.Department;
import com.harsh.test.milestone.entity.Employee;


public interface ServiceEmpDep {
	
	
	// for employees 
	Employee addEmployee(Employee emp); 
	List<Employee> getAllEmployee();
	
	// for department
	Department addDepartment(Department dep); 
	List<Department> getAllDepartment();
	
	
	// for fetching employee by department name 
	List<ResponseDepEmp> getEmployeeByDepName(String depname);
	
	
	//for updating total employee in department 
	Department updateTotalEmployee(long depid, int totalemp);
		
	


}
