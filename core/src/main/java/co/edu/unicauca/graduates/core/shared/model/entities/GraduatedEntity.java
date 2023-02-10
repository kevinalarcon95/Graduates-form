package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import co.edu.unicauca.graduates.core.shared.model.enums.IDType;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Graduates")
public class GraduatedEntity {
    @Id
	@Column(name = "grad_id")
	private String id;
	@Column(name = "grad_idType")
    @Enumerated(EnumType.STRING)
	private IDType idType;
    @Column(name = "grad_idExpeditionLoc")
	private String IDExpeditionLocation;
    @Column(name = "grad_idExpeditionCountry")
	private String IDExpeditionCountry;
    @Column(name = "grad_institutionalEmail")
    private String institutionalEmail;
    @Column(name = "grad_childsQuantity")
	private Integer childsQuantity;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;
	
	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "Graduated_Program", joinColumns = @JoinColumn(name = "grad_id"), inverseJoinColumns = @JoinColumn(name = "prog_cod"))
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
	@JoinTable(name = "Job_Graduated", joinColumns = @JoinColumn(name = "grad_id"), inverseJoinColumns = @JoinColumn(name = "job_id"))
	private List<JobEntity> jobs = new ArrayList<>();


}
