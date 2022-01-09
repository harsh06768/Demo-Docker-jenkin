package com.harsh.test.milestone.servicesed.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import com.harsh.test.milestone.dto.ResponseDepEmp;
import com.harsh.test.milestone.entity.Department;
import com.harsh.test.milestone.entity.Employee;
import com.harsh.test.milestone.exceptions.DepartmentNotFoundException;
import com.harsh.test.milestone.exceptions.ResourceNotFoundException;
import com.harsh.test.milestone.repositorys.DepartmentRepository;
import com.harsh.test.milestone.repositorys.EmployeeRepository;
import com.harsh.test.milestone.servicesed.ServiceEmpDep;


@Service
public class ServiceImpl implements ServiceEmpDep{

	@Autowired
	EmployeeRepository employeerepo; 
	
	@Autowired
	DepartmentRepository departmentrepo; 
	
	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	//EntityManagerFactory emfactory;
   // EntityManager entitymanager = emfactory.createEntityManager();
	
	Department deps;
	static int count = 0;  
	
	public ServiceImpl(EmployeeRepository employeerepo, DepartmentRepository departmentrepo, JdbcTemplate jdbcTemplate) {
		super();
		this.employeerepo = employeerepo;
		this.departmentrepo = departmentrepo;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		return employeerepo.save(emp);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeerepo.findAll();
	}

	@Override
	public Department addDepartment(Department dep) {
		
		 long depids = dep.getDepid();
		 long fetchtotalemployee = dep.getTotalemp();
		//Query query1 = entitymanager.createQuery("Select COUNT(e.fetchtotalemployee) from Department e");
		
		 //Query query1 = entityManager.createQuery("Select new com.harsh.test.milestone.dto.ResponseCountEmployee(COUNT(e.empid)) from Employee e join e.dep p where p.depid = :depid");  
		// long result = (Long) query1.getSingleResult();
		 
		 //String q = "Select count(emp_id) from tbl_employee  where dep_id = " + depids +";"; 
		 
		 //jdbcTemplate.query(q, ResponseCountEmployee.class);
		 
		 
		 
		 //Double result = (Double) query1.getSingleResult();
		 //@Query("select new com.harsh.test.milestone.dto.ResponseDepEmp(c.depid, c.depname , p.empid, p.empname, p.salary, p.gender, p.age) from Department c join c.employee p where c.depname = :depname")
		//@Query(nativeQuery = true , value = "SELECT count(emp_id) from tbl_employee  where dep_dep_id = 101;")
			//public long getCountofCurrentEmployeesInDepartmentHr();
		
//		if(result==dep.getTotalemp()) {
//			throw new ResourceNotFoundException("Department", "For this department exceeds the limit of number of employees", dep);
//		}
		
		return departmentrepo.save(dep);
	}

	@Override
	public List<Department> getAllDepartment() {
		
		List<Department> sor=new ArrayList<>(); 
		sor = departmentrepo.findAll();
		
		  Comparator<Department> cm1=Comparator.comparing(Department::getDepname);  
		  Collections.sort(sor,cm1);  
		  
		  return sor; 
		
	}

	@Override
	public List<ResponseDepEmp> getEmployeeByDepName(String depname) {
		// TODO Auto-generated method stub
		return departmentrepo.getEmployeeByDepName(depname);
	}

	// updating the total employee in department 
	@Override
	public Department updateTotalEmployee(long depid, int totalemp) {
		    try {
		    	Optional<Department> departmentData = departmentrepo.findById(depid);   
		    	Department depss = departmentData.get(); 
		    	depss.setTotalemp(totalemp);
		    	return departmentrepo.save(depss);
		    }
		    catch(java.util.NoSuchElementException e) {
		    	throw new DepartmentNotFoundException("Given Department does not exist");
		    }
		    catch(Exception e) {
		    	throw new DepartmentNotFoundException("Exception occur while updating the total employee", e);
		    }
	}


}
