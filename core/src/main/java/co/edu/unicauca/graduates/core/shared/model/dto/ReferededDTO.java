package co.edu.unicauca.graduates.core.shared.model.dto;

import java.io.Serializable;

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
public class ReferededDTO{
	private Integer id;
	
	private String name;
	private String email;
	
	/*@JsonIgnoreProperties(value="refered")
	private GraduatedDTO graduated;*/

	@JsonIgnore
	@JsonIgnoreProperties(value="refered")
	private GratingDTO grating;
	
	@JsonIgnoreProperties(value="refered")
	private PhoneDTO phone;
}
