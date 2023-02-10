package co.edu.unicauca.graduates.core.modules.administrative_management.controllers;

import co.edu.unicauca.graduates.core.modules.administrative_management.services.IUserService;
import co.edu.unicauca.graduates.core.shared.model.dto.BossDTO;
import co.edu.unicauca.graduates.core.shared.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.Set;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Validated
public class UserRestController {
	@Autowired
	private IUserService userService;
	@GetMapping("/users")
	public ResponseEntity<?> index() {
		return new ResponseEntity<>(  userService.findAll(),HttpStatus.OK);
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users/{id}")
	public ResponseEntity<?> show(@Valid @Positive @PathVariable Long id) {
		return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@Valid @Positive @PathVariable Long id) {
		return new ResponseEntity<>(userService.delete(id),HttpStatus.OK);
	}
	@PostMapping("/users")
	public ResponseEntity<?> create(@Valid @RequestBody UserDTO objUser) {
		return new ResponseEntity<>(userService.save(objUser), HttpStatus.CREATED);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody UserDTO objUser,@Positive @PathVariable Long id) {
		return new ResponseEntity<>(this.userService.update(id,objUser),HttpStatus.OK);
	}
}
