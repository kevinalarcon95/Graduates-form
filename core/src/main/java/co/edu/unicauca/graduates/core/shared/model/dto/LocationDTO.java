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
public class LocationDTO {

	private Integer id;
	
	private String residenceCountry;
	
	private String residenceDepartment;
	
	private String residenceCity;
	
	private String natalDepartment;
	
	private String natalTown;
	
	/*@JsonIgnoreProperties(value="location")
	private GraduatedDTO graduated;*/
	
	@JsonIgnore
	@JsonIgnoreProperties(value="location")
	private GratingDTO grating;

}
