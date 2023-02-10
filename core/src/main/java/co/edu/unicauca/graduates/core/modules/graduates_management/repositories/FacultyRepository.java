package co.edu.unicauca.graduates.core.modules.graduates_management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.graduates.core.shared.model.dto.ProgramDTO;
import co.edu.unicauca.graduates.core.shared.model.entities.FacultyEntity;

public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer>{

}
