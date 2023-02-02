package co.edu.unicauca.egresado.core.proyecto.models;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Graduando")
public class GraduandoEntity {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha;
    @Id
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
