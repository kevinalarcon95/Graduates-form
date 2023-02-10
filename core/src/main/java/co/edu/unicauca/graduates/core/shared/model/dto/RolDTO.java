package co.edu.unicauca.graduates.core.shared.model.dto;

import co.edu.unicauca.graduates.core.shared.model.entities.UserEntity;
import co.edu.unicauca.graduates.core.shared.model.enums.RolType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolDTO {
    private int id;
    private RolType rolType;
    @JsonIgnoreProperties(value="roles")
    private List<UserDTO> users  = new ArrayList<>();
}
