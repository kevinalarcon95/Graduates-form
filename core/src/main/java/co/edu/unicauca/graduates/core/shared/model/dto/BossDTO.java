package co.edu.unicauca.graduates.core.shared.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
public class BossDTO {

	@NotEmpty(message = "")
	private Integer id;
	@NotEmpty(message = "")
	private String name;
	@NotEmpty(message = "")
	@Email
	private String email;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonIgnoreProperties(value="boss")
	private JobDTO job;
}
