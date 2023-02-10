package co.edu.unicauca.graduates.core.shared.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DegreeDTO{
	private Integer id;
	
	private String name;
	
	private String mention;
	
	private String type;


	/*@JsonIgnoreProperties(value="degrees")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ProgramDTO program;


	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonIgnoreProperties(value="degrees")
	@Setter(AccessLevel.NONE)
	private List<GraduatedDTO> graduates  = new ArrayList<>(); */

}
