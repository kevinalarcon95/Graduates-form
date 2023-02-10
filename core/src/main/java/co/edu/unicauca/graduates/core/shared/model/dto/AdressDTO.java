package co.edu.unicauca.graduates.core.shared.model.dto;

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
public class AdressDTO {
	
	private Integer id;
	private String calle;
	private String ciudad;
	private String pais;	
}
