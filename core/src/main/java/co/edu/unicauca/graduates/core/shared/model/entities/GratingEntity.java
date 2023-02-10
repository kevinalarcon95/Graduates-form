package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import co.edu.unicauca.graduates.core.shared.model.enums.AgreementState;
import co.edu.unicauca.graduates.core.shared.model.enums.IDType;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Gratings")
public class GratingEntity{
    @Id
	@Column(name = "grat_id")
	private String id;
	@Column(name = "grat_idType")
    @Enumerated(EnumType.STRING)
	private IDType idType;
    @Column(name = "grat_idExpeditionLoc")
	private String IDExpeditionLocation;
    @Column(name = "grat_idExpeditionCountry")
	private String IDExpeditionCountry;
    @Column(name = "grat_institutionalEmail")
    private String institutionalEmail;
    @Column(name = "grat_childsQuantity")
	private Integer childsQuantity;
	
	@Column(name = "grat_degreeDate")
    private String degreeDate;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;
	
	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "Grating_Program", joinColumns = @JoinColumn(name = "grat_id"), inverseJoinColumns = @JoinColumn(name = "prog_cod"))
	private List<ProgramEntity> programs = new ArrayList<>();

	
	@OneToOne(optional = false,cascade = {CascadeType.ALL})
	@JoinColumn(name = "location_id", nullable = false)
	private LocationEntity location; 
	
	@OneToOne(optional = false,cascade = {CascadeType.ALL})
	@JoinColumn(name = "refered_id", nullable = false)
	private ReferedEntity refered;
	
	@OneToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "form_id", nullable = false)
	private FormEntity form; 

	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinTable(name = "Job_Grating", joinColumns = @JoinColumn(name = "grat_id"), inverseJoinColumns = @JoinColumn(name = "job_id"))
	private List<JobEntity> jobs = new ArrayList<>();


}
