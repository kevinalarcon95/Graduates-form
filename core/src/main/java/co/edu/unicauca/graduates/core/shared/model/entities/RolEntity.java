package co.edu.unicauca.graduates.core.shared.model.entities;

import co.edu.unicauca.graduates.core.shared.model.enums.RolType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Roles")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Integer id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_type")
    private RolType rolType;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "User_Rol", joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> users  = new ArrayList<>();
}
