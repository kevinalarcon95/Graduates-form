package co.edu.unicauca.egresado.core.proyecto.services.DTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraduandoDTO {
    @JsonFormat(pattern = "ddMMyyyy")
    private Date fecha;

	private String id;
    private String tipoId;
	private String lugarExpedicionId;

//	private String paisExpedicionId;
    private String ciudadNacimiento;
    private String departamentoNacimiento;
    private String paisResidencia;
	private String departamentoResidencia;
	private String ciudadResidencia;	
	private Integer numeroHijos;

    //TODO: Informacion del graduando
	private String correoPersonal;
    private String facultad;
    private String programa;

    //TODO: Facultad con el programa pero eso son quemados
    //REFERIDO
    private String nombreReferido;
	private String telefonoReferido;
    private String correoReferido;
    
    //LABORAL
    private boolean haTrabajadoAntes;
    private boolean areaFormaAnte;
    private String cargo;
    private String empresa;	
	private boolean trabajando;
    private String empresaActual;
    private String ciudadTrabajo;
    private String telefonoEmpresa;
    private String cargoActual;	
    private String rangoSalarial;
    private String tipoContrato;
    private String sector;	
	private boolean trabAreaForm;
    private String nombreJefe;
	private String correoJefe;	
	
    //TODO: Docente
	private String docenteInfluyente;	
	private String razonInfluyente;	
    private String otroInfluyente;
	
	//Informacion Adicional 	
    private String comentarioPrograma;
	private String expectativaUniversidad;
    

}
