package co.edu.unicauca.graduates.core.shared.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
public class HeadquarterDTO {
	@NotEmpty(message = "")
	@Min(value = 0, message = "")
	private Integer id;
	
	@NotEmpty(message = "")
	@Size(min = 3, max = 150, message = "")
	private String name;
	
	@JsonIgnore
	@JsonIgnoreProperties(value="headquarters")
    private UniversityDTO university;
	
    @JsonIgnoreProperties(value="headquarter")
	private List<FacultyDTO> faculties = new ArrayList<>();
}
