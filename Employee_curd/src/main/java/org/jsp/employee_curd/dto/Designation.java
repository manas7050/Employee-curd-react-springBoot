package org.jsp.employee_curd.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Designation {
	
	
	    @Id
	    private Long id;
	    
	    @Column(nullable = false, unique = true)
	    @NotBlank(message = "Designation name is mandatory")
	    private String name;
	    
	    

}
