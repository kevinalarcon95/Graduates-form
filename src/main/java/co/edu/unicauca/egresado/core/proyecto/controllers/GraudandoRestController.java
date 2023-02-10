package co.edu.unicauca.egresado.core.proyecto.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.egresado.core.proyecto.services.services.clienteServices.IGraduandoService;
import co.edu.unicauca.egresado.core.proyecto.models.GraduandoEntity;
import co.edu.unicauca.egresado.core.proyecto.services.DTO.GraduandoDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GraudandoRestController {
    @Autowired
    private IGraduandoService graduandoService;
    
    @PostMapping("/graduando")
    public ResponseEntity<?> save(@RequestBody GraduandoEntity graduando){
        GraduandoEntity PersonaCreada = graduandoService.save(graduando);
		return ResponseEntity.status(HttpStatus.CREATED).body(PersonaCreada);
    }
    @GetMapping("/graduando")
	public List<GraduandoDTO> index() {
		return graduandoService.findAll();
	}
    
}
