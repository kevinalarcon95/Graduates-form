package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import co.edu.unicauca.graduates.core.shared.model.enums.AgreementState;
import co.edu.unicauca.graduates.core.shared.model.enums.UniversitySector;

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
@Table(name = "Universities")
public class UniversityEntity {
    @Id
    @Column(name = "uni_nit")
	private String nit;
    @Column(name = "uni_name")
	private String name;
    @Column(name = "uni_email")
	private String email;
    @Column(name = "uni_sector")
    @Enumerated(EnumType.STRING)
	private UniversitySector sector;
    @Column(name = "uni_webpage")
	private String webPage;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;
		
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "university")
	private List<AgreementEntity> agreements = new ArrayList<>();

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "university")
	private List<HeadquarterEntity> headquarters = new ArrayList<>();
}
