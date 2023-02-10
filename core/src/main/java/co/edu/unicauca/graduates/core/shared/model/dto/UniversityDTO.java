package co.edu.unicauca.graduates.core.shared.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.unicauca.graduates.core.shared.model.enums.UniversitySector;
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
public class UniversityDTO {
	@NotEmpty(message = "")
	@Size(min = 3, max = 50, message = "")
	private String nit;
	
	@NotEmpty(message = "")
	@Size(min = 3, max = 150, message = "")
	private String name;
	
	@Email
	@NotEmpty(message = "")
	@Size(min = 3, max = 50, message = "")
	private String email;
	
	@NotEmpty(message = "")
	private UniversitySector sector;
	
	@NotEmpty(message = "")
	@Size(min = 3, max = 50, message = "")
	private String webPage;
	
	@JsonIgnoreProperties(value="university")
	private List<HeadquarterDTO> headquarters = new ArrayList<>();
	
	@JsonIgnoreProperties(value="university")
	private List<AgreementDTO> agreements = new ArrayList<>();
}
