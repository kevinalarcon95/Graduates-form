package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Refereds")
public class ReferedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_id")
	private Integer id;
	@Column(name = "ref_name")
	private String name;
    @Column(name = "ref_email")
	private String email;


	/*@OneToOne(cascade = { CascadeType.PERSIST },fetch = FetchType.EAGER, mappedBy = "refered")
	private GraduatedEntity graduated;*/

	@OneToOne(cascade = { CascadeType.ALL },fetch = FetchType.EAGER, mappedBy = "refered")
	private GratingEntity grating;
	
	@OneToOne(optional = false,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "ph_id", nullable = false)
	private PhoneEntity phone;    
}
