package org.jsp.employee_curd.service;

import java.util.List;
import java.util.Optional;

import org.jsp.employee_curd.dto.Employee;
import org.jsp.employee_curd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;


	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public Employee createEmployee(@Valid Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, @Valid Employee employeeDetails) {
		 Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		 employee.setEmpId(employeeDetails.getEmpId());
		 employee.setName(employeeDetails.getName());
//	        employee.setDesignation(employeeDetails.getDesignation());
	        employee.setDob(employeeDetails.getDob());
//	        employee.setSalary(employeeDetails.getSalary());
	        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
	        employee.setEmail(employeeDetails.getEmail());
	        employee.setGender(employeeDetails.getGender());
	        employee.setDesignation2(employeeDetails.getDesignation2());
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		 employeeRepository.deleteById(id);
	}
	
 
}
