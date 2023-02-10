package co.edu.unicauca.graduates.core.shared.model.dto;

import java.util.ArrayList;
import java.util.List;

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
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PhoneDTO{
	
    private Integer id;
    
    private String type;
    
    private String number;
    
    
	@JsonIgnoreProperties(value="phone")
	private ReferededDTO refered; 
	
	@JsonIgnoreProperties(value="phone")
	private JobDTO job; 
}
