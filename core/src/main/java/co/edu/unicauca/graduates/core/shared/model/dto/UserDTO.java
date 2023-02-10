package co.edu.unicauca.graduates.core.shared.model.dto;

import co.edu.unicauca.graduates.core.shared.model.enums.RolType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotEmpty(message = "{user.name.empty}")
    @Size(min = 3, max = 50, message = "{user.lastname.length}")
    private String name;
    @NotEmpty(message = "{user.lastname.empty}")
    @Size(min = 3, max = 50, message = "{user.lastname.length}")
    private String lastName;
    @NotEmpty(message = "{user.email.empty}")
    @Email(message = "{user.email.mask}")
    private String email;
    @NotEmpty(message = "{user.password.empty}")
    private String password;
    @NotNull(message = "{user.status.null}")
    private Boolean status;
    private LocalDate createAt;
    private LocalDate updateAt;

    @NotEmpty(message = "{user.listRoles.empty}")
    private List<RolType> listRoles = new ArrayList<>();

    @Valid
    @JsonIgnoreProperties(value="users")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RolDTO> roles  = new ArrayList<>();

}
