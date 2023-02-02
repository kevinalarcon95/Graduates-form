package co.edu.unicauca.egresado.core.proyecto.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.egresado.core.proyecto.security.entity.Rol;
import co.edu.unicauca.egresado.core.proyecto.security.enums.RolNombre;
import co.edu.unicauca.egresado.core.proyecto.security.repository.RolRepository;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
