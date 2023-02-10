package co.edu.unicauca.graduates.core.shared.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.unicauca.graduates.core.shared.model.enums.IDType;
import lombok.*;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraduatedDTO{

	private String id;
	private IDType IDType;
	private String IDExpeditionLocation;
	private String IDExpeditionCountry;
	private String institutionalEmail;
	private Integer childsQuantity;
	private LocalDate createAt;
	private LocalDate updateAt;
	



	@JsonIgnoreProperties(value="graduates")
	//@Setter(AccessLevel.NONE)
	private List<ProgramDTO> programs  = new ArrayList<>();


	
	@JsonIgnoreProperties(value="graduates")
	private List<JobDTO> jobs  = new ArrayList<>();

	@JsonIgnoreProperties(value="graduated")
	private LocationDTO location; 
	
	@JsonIgnoreProperties(value="graduated")
	private ReferededDTO refered; 
	
	@JsonIgnoreProperties(value="graduated")
	private FormDTO form;


}
