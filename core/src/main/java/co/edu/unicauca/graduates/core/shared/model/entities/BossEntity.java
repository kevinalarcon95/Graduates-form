package co.edu.unicauca.graduates.core.shared.model.entities;

import java.time.LocalDate;

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
@Table(name = "Bosses")
public class BossEntity{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "boss_id")
	private Integer id;
	@Column(name = "boss_name")
	private String name;
	@Column(name = "boss_email")
	private String email;
	@DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;
	
	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "boss")
	private JobEntity job;
}
