package org.jsp.employee_curd.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.employee_curd.dto.Designation;
import org.jsp.employee_curd.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/designations")
public class DesignationController {

    @Autowired
    private DesignationService designationService;
    
    @PostMapping("/save")
    public Designation createDesignation(@Valid @RequestBody Designation designation) {
        return designationService.createDesignation(designation);
    }
    @GetMapping
    public List<Designation> getAllDesignations() {
        return designationService.getAllDesignations();
    }
    @GetMapping("/{id}")
    public Optional<Designation> getDesignationById(@PathVariable Long id)
    {
    	return designationService.getDesignationById(id);
    }

   

    @PutMapping("update/{id}")
    public ResponseEntity<Designation> updateDesignation(@PathVariable Long id, @Valid @RequestBody Designation designationDetails) {
        return ResponseEntity.ok(designationService.updateDesignation(id, designationDetails));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Long id) {
        designationService.deleteDesignation(id);
        return ResponseEntity.noContent().build();
    }

 
}