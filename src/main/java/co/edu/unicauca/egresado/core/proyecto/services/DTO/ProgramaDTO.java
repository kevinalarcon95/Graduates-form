package co.edu.unicauca.egresado.core.proyecto.services.DTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaDTO {
    
	private Integer id;
    private String nombre;     
    private String direccion;
    private String sede;
    private String nit;
    

}
