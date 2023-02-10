package co.edu.unicauca.egresado.core.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.egresado.core.proyecto.models.ProgramaEntity;

public interface ProgramaRepository extends JpaRepository<ProgramaEntity, Integer>{
    
}
