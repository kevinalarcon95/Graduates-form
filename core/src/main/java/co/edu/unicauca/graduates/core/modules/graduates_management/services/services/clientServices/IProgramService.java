package co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices;

import java.util.List;

import co.edu.unicauca.graduates.core.shared.model.dto.ProgramDTO;

public interface IProgramService {
    public List<ProgramDTO> findAll(int id_fac);

}
