package org.jsp.employee_curd.controller;
import java.util.List;

import org.jsp.employee_curd.dto.Employee;
import org.jsp.employee_curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

 
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id,ModelMap map) {
		return employeeService.getEmployeeById(id).orElse(null);
	}
	@PostMapping("save")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
	@PutMapping("update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
	    return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDetails));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
    
}
