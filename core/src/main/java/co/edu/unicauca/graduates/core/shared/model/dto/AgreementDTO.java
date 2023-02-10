package co.edu.unicauca.graduates.core.shared.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.unicauca.graduates.core.shared.model.enums.AgreementState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgreementDTO{
    @NotEmpty(message = "")
    @Min(value = 0, message = "")
    private Integer id;
    
    @NotEmpty(message = "")
    @Size(min = 3, max = 150, message = "")
	private String name;
    
    @NotEmpty(message = "")
	private AgreementState state;
    
    @NotEmpty(message = "")
    @Size(min = 3, max = 150, message = "")
	private String descrpition;
    
    @JsonIgnoreProperties(value="agreements")
    private UniversityDTO university;
}
