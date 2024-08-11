package org.jsp.employee_curd.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\d{4}", message = "ID should be a four-digit number")
    @Column(unique = true)
    private String empId;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only alphabets")
    @NotBlank(message = "Name is mandatory")
    private String name;

//    @NotBlank(message = "Designation is mandatory")
//    private String designation;

    @Past(message = "Date of Birth must be a past date")
    private LocalDate dob;

    @NotNull(message = "Salary is mandatory")
    private Double salary;

    @Pattern(regexp = "\\d{10}", message = "Phone number should be a 10-digit number")
    private String phoneNumber;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "^(M|F)$", message = "Gender should be 'M' or 'F'")
    @NotBlank(message = "Gender is mandatory")
    private String gender;
	
    @ManyToOne
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation2;
}
