package org.jsp.employee_curd.service;

import java.util.List;
import java.util.Optional;

import org.jsp.employee_curd.dto.Designation;
import org.jsp.employee_curd.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class DesignationService {
	
	@Autowired
	private DesignationRepository designationRepository;

	public List<Designation> getAllDesignations() {
		return designationRepository.findAll();
	}

	public Optional<Designation> getDesignationById(Long id) {
		return designationRepository.findById(id);
	}

	public Designation createDesignation(@Valid Designation designation) {
		return designationRepository.save(designation);
	}

	public Designation updateDesignation(Long id, @Valid Designation designationDetails) {
		Designation designation=designationRepository.findById(id).orElseThrow(()-> new RuntimeException("Designation nOt founnd"));
		designation.setName(designationDetails.getName());
		return designationRepository.save(designation);
	}

	public void deleteDesignation(Long id) {
		 designationRepository.deleteById(id);
	}

	 
}
