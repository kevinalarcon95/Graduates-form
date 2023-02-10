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

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Departments")
public class DepartmentEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
	private Integer id;
	@Column(name = "dep_name")
	private String name;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;
	
	@ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "faculty_id", nullable = false)
    private FacultyEntity faculty;


	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "department")
	private List<ProgramEntity> programs = new ArrayList<>();
}
