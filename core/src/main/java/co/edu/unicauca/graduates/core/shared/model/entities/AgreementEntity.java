package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import co.edu.unicauca.graduates.core.shared.model.enums.AgreementState;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

//@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Agreements")
public class AgreementEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agr_id")
	private Integer id;
    @Column(name = "agr_name")
	private String name;
    @Column(name = "agr_state")
    @Enumerated(EnumType.STRING)
	private AgreementState state;
    @Column(name = "agr_description")
	private String descrpition;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;
	
	@ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "university_nit", nullable = false)
    private UniversityEntity university;
}
