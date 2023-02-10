package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Locations")
public class LocationEntity{
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
	private Integer id;
	@Column(name = "loc_residence_country")
	private String residenceCountry;
	@Column(name = "loc_residence_department")
	private String residenceDepartment;
	@Column(name = "loc_residence_city")
	private String residenceCity;
	@Column(name = "loc_natal_dept")
	private String natalDepartment;
	@Column(name = "loc_natal_town")
	private String natalTown;


	/*@OneToOne(cascade = { CascadeType.PERSIST },fetch = FetchType.EAGER, mappedBy = "location")
	private GraduatedEntity graduated;*/

	@OneToOne(cascade = { CascadeType.ALL },fetch = FetchType.EAGER, mappedBy = "location")
	private GratingEntity grating;
}
