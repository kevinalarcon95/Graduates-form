package co.edu.unicauca.graduates.core.shared.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormDTO {
	
	private Integer id;
	
	private String programComment;
	
	private String UniversityExpectative;
	
	private String mostImportantProfessor;
	
	private String mostImportantReassons;
	
	private String observations;
	
	/*@JsonIgnoreProperties(value="form")
	private GraduatedDTO graduated;	*/

	@JsonIgnore
	@JsonIgnoreProperties(value="form")
	private GratingDTO grating;	
	
}
