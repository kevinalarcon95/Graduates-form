package co.edu.unicauca.graduates.core.modules.graduates_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices.IProgramService;
import co.edu.unicauca.graduates.core.shared.model.dto.ProgramDTO;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentRestController {
    @Autowired
    private IProgramService facultadServicio;

    @GetMapping("/programas/{id}")
    public ResponseEntity<?> index(@PathVariable Integer id) {

        List<ProgramDTO> lista = facultadServicio.findAll(id);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
