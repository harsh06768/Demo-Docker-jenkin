package com.harsh.test.milestone.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.harsh.test.milestone.dto.ResponseDepEmp;
import com.harsh.test.milestone.entity.Department;







@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	
	@Query("select new com.harsh.test.milestone.dto.ResponseDepEmp(c.depid, c.depname , p.empid, p.empname, p.salary, p.gender, p.age) from Department c join c.employee p where c.depname = :depname ORDER BY c.depname")
	public List<ResponseDepEmp> getEmployeeByDepName(@Param ("depname") String depname);
	
	
	
	//@Query(nativeQuery=true, value="SELECT * FROM Question q where q.id < 5")
    //public Collection<Question> findQuestion();
//	@Query(nativeQuery = true , value = "SELECT count(emp_id) from tbl_employee  where dep_dep_id = 101;")
//	public long getCountofCurrentEmployeesInDepartmentHr();
	
	
}
