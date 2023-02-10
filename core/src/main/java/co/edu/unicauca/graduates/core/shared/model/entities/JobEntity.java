package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "Jobs")
public class JobEntity{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;

    /*@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "Job_Graduated", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "grad_id"))
	private List<GraduatedEntity> graduates = new ArrayList<>();*/

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "boss_id", nullable = false)
	private BossEntity boss;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ph_id", nullable = false)
	private PhoneEntity phone;
	
	@ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name = "job_grating", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "grat_id"))
	private List<GratingEntity> gratings = new ArrayList<>();
}
