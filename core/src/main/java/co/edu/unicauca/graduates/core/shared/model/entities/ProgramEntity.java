package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import co.edu.unicauca.graduates.core.shared.model.enums.ProgramType;

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
@Table(name = "Programs")
public class ProgramEntity {
    @Id
	@Column(name = "prog_cod")
	private String code;
	@Column(name = "prog_name")
	private String name;
    @Column(name = "prog_type")
    @Enumerated(EnumType.STRING)
	private ProgramType type;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;


	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "dep_id", nullable = false)
	private DepartmentEntity department;

	@ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name = "Grating_Program", joinColumns = @JoinColumn(name = "prog_cod"), inverseJoinColumns = @JoinColumn(name = "grat_id"))
	private List<GratingEntity> graduates = new ArrayList<>();

}
