package co.edu.unicauca.graduates.core.shared.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class JobDTO {

	private Integer id;
	
	private boolean hadJobBefore;
	
	private boolean hasBeenInProfession;
	
	private String position;
	
	private String enterprise;
	
	private boolean working;
	
	private String actualEnterprise;
	
	private String jobCity;
	
	private String actualPosition;
	
	private String salarialRange;
	
	private String contractType;
	
	private String Sector;
	
	private boolean isInProfession;
	
	private Date createAt;
	
	@JsonIgnoreProperties(value="boss")
	private BossDTO boss; 
	
	/*@JsonIgnoreProperties(value="jobs")
	private List<GraduatedDTO> graduates  = new ArrayList<>();*/
	
	@JsonIgnoreProperties(value="job")
	private PhoneDTO phone;

	@JsonIgnore
	@JsonIgnoreProperties(value="jobs")
	private List<GratingDTO> gratings  = new ArrayList<>();
	
	
}
