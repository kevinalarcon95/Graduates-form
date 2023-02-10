package co.edu.unicauca.graduates.core.shared.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RequestDTO{
   
    private Integer id;
    private Date fecha;
    private String archivo;
    private String comentarios;
}
