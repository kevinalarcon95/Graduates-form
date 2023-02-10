package co.edu.unicauca.graduates.core.shared.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.unicauca.graduates.core.shared.model.entities.DepartmentEntity;
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
public class FacultyDTO {
	
	private Integer id;
	
	private String name;
	@JsonIgnore
	private String address;

	@JsonIgnore
	@JsonIgnoreProperties(value="faculties")
    private HeadquarterDTO headquarter;

	@JsonIgnore
    @JsonIgnoreProperties(value="faculty")
	private List<DepartamentDTO> departaments = new ArrayList<>();
}
