package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;

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
@Table(name = "Forms")
public class FormEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "form_id")
	private Integer id;
	@Column(name = "form_programComment")
	private String programComment;
	@Column(name = "form_universityExpectative")
	private String UniversityExpectative;
	@Column(name = "form_mostImportantProfessor")
	private String mostImportantProfessor;
	@Column(name = "form_mostImportantReassons")
	private String mostImportantReassons;
	@Column(name = "form_observations")
	private String observations;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;


	/*@OneToOne(cascade = { CascadeType.PERSIST },fetch = FetchType.EAGER, mappedBy = "form")
	private GraduatedEntity graduated;*/

	@OneToOne(cascade = { CascadeType.ALL },fetch = FetchType.EAGER, mappedBy = "form")
	private GratingEntity grating;
}