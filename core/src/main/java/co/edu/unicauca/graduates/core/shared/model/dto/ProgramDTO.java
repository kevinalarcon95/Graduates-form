package co.edu.unicauca.graduates.core.shared.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import co.edu.unicauca.graduates.core.shared.model.entities.DegreeEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.GraduatedEntity;
import co.edu.unicauca.graduates.core.shared.model.enums.ProgramType;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDTO {
	
	private String code;
	
	private String name;
	@JsonIgnore
	private ProgramType type;
	@JsonIgnore
	private LocalDate createAt;
	@JsonIgnore
	private LocalDate updateAt;


	@JsonIgnore
	@JsonIgnoreProperties(value="programs")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private DepartamentDTO department;



	@JsonIgnore
	@JsonIgnoreProperties(value="programs")
	@Setter(AccessLevel.NONE)
	private List<GraduatedDTO> graduates = new ArrayList<>();

	
}
