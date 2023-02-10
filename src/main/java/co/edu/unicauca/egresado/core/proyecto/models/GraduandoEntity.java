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
	private String degreeDate;
    @Id
	private String idNumber;
    private String idType;
	private String expeditionPlace;
    private String placeBirth;
    private String birthDepartament;
    private String countryResidence;
	private String departamentResidence;
	private String cityResidence;	
	private Integer numberChildren;

    //TODO: Informacion del graduando
	private String personalMail;
    private String unicaucaFaculty;
    private String unicaucaProgram;

    //TODO: Facultad con el programa pero eso son quemados
    //REFERIDO
    private String refeName;
	private String cellRefe;
    private String emailRefe;
    
    //LABORAL
    private String hasWork;
    private String optionArea;
    private String bossPositionCompany;
    private String companyWork;	
	private String currentlyWorking;
    private String nameCompanyWork;
    private String workCity;
    private String phoneWork;
    private String positionCompany;	
    private String salaryRange;
    private String typeContract;
    private String workSector;	
	private String isWork;
    private String bossName;
	private String bossMail;	
	
    //TODO: Docente
	private String nameRefeDoc;	
	private String reasonInfluence;	
    private String whatReason;
	
	//Informacion Adicional 	
    private String commentOne;
	private String commentTwo;
}
