package co.edu.unicauca.graduates.core.modules.graduates_management.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.graduates.core.shared.model.entities.DepartmentEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.ProgramEntity;

public interface ProgramRepository extends CrudRepository<ProgramEntity, String>{
    
}
