package co.edu.unicauca.graduates.core.shared.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
	private Integer id;
	@NotEmpty(message = "{user.name.empty}")
	@Size(min = 5, max = 45, message = "la cantidad de caracteres del nombre debe estar entre 5 y 45")
	private String nombre;
	@NotEmpty(message = "{user.lastname.empty}")
	@Size(min = 5, max = 45, message = "{user.lastname.length}")
	private String apellido;
	@NotEmpty(message = "{user.email.emply}")
	@Email(message = "{user.email.mask}")
	private String email;
	@PastOrPresent(message = "{user.date.past}")
	private Date createAt;
	@Pattern(message = "{user.telephone.pattern}", regexp = "[6][0-9]{8}")
	private String telefono;
	@PositiveOrZero(message = "{user.salary.positive}")
	private float salario;

	private AdressDTO objDireccion;

	private List<RequestDTO> solicitudes = new ArrayList<>();
}
