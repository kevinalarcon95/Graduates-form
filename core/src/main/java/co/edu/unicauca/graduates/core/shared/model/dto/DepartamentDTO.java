package co.edu.unicauca.graduates.core.shared.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.unicauca.graduates.core.shared.model.entities.FacultyEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.ProgramEntity;
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
public class DepartamentDTO {
	private Integer id;
	
	private String name;
	
	private LocalDate createAt;
	
	private LocalDate updateAt;
	
	@JsonIgnoreProperties(value="departaments")
	private FacultyDTO faculty;

	@JsonIgnoreProperties(value="departament")
	private List<ProgramDTO> programs = new ArrayList<>();
}
