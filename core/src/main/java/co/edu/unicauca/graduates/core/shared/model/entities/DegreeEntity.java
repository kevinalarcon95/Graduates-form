package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import co.edu.unicauca.graduates.core.shared.model.enums.DegreeType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Degrees")
public class DegreeEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deg_id")
	private Integer id;
	@Column(name = "deg_name")
	private String name;
	@Column(name = "deg_mention")
	private String mention;
	@Column(name = "deg_type")
    @Enumerated(EnumType.STRING)
	private DegreeType type;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;


}
