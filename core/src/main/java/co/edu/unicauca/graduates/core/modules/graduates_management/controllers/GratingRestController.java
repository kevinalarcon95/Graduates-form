
package co.edu.unicauca.graduates.core.modules.graduates_management.controllers;

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

import co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices.IGratingService;
import co.edu.unicauca.graduates.core.shared.model.dto.GratingDTO;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Validated
public class GratingRestController {

    @Autowired
    private IGratingService graduandoServicio;

    @GetMapping("/graduando")
    public ResponseEntity<?> index() {

        List<GratingDTO> lista = graduandoServicio.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/graduandos")
    public ResponseEntity<?> create(@Valid @RequestBody GratingDTO Grating) {
        System.out.println("**** ");
        GratingDTO objClient = graduandoServicio.save(Grating);
        ResponseEntity<GratingDTO> objAnswer = new ResponseEntity<GratingDTO>(objClient, HttpStatus.CREATED);

        // return new ResponseEntity<>(Grating, HttpStatus.ACCEPTED);
        return objAnswer;
    }

}
