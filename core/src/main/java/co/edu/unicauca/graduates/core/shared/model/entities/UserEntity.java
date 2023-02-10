package co.edu.unicauca.graduates.core.shared.model.entities;

import co.edu.unicauca.graduates.core.shared.model.enums.IDType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class UserEntity {
    @Id
    @Column(name = "user_id")
	private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_lastName")
    private String lastName;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_status")
    private Boolean status;

    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate createAt;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDate updateAt;

    @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinTable(name = "User_Rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<RolEntity> roles  = new ArrayList<>();
}
