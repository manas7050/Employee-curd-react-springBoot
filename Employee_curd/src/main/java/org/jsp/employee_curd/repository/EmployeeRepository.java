package org.jsp.employee_curd.repository;

import org.jsp.employee_curd.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
