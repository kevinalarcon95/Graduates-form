package co.edu.unicauca.egresado.core.proyecto.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.egresado.core.proyecto.security.entity.Rol;
import co.edu.unicauca.egresado.core.proyecto.security.enums.RolNombre;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
