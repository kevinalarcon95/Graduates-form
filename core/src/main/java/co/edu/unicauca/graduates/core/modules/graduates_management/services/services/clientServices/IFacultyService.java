package co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import co.edu.unicauca.graduates.core.shared.model.dto.FacultyDTO;
import co.edu.unicauca.graduates.core.shared.model.dto.ProgramDTO;

public interface IFacultyService {
    
    public List<FacultyDTO> findAll();
    
}
