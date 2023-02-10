package co.edu.unicauca.graduates.core.modules.graduates_management.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices.IFacultyService;

import co.edu.unicauca.graduates.core.shared.model.dto.FacultyDTO;
import co.edu.unicauca.graduates.core.shared.model.dto.ProgramDTO;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyRestController {

    @Autowired
    private IFacultyService facultadServicio;

    @GetMapping("/facultad")
    public ResponseEntity<?> index() {

        List<FacultyDTO> lista = facultadServicio.findAll();
        
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }




}
