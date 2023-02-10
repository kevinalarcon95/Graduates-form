package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "Faculties")
public class FacultyEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fac_id")
	private Integer id;
	@Column(name = "fac_name")
	private String name;
	@Column(name = "fac_address")
	private String address;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;

	@ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "headquarter_id", nullable = false)
    private HeadquarterEntity headquarter;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "faculty")
	private List<DepartmentEntity> departaments = new ArrayList<>();
}
