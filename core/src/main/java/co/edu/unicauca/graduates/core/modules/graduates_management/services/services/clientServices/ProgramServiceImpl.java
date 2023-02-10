package co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.graduates.core.modules.graduates_management.repositories.ProgramRepository;
import co.edu.unicauca.graduates.core.shared.model.dto.ProgramDTO;
import co.edu.unicauca.graduates.core.shared.model.entities.ProgramEntity;
import org.modelmapper.TypeToken;

@Service
public class ProgramServiceImpl implements IProgramService{

    @Autowired
	private ProgramRepository accesServiceDataBase;
	

	@Autowired
	@Qualifier("mapperFacultad")
	private ModelMapper modelMapperFac;

    @Override
    public List findAll(int id_fac) {
        System.out.println("-------------------");
		System.out.println("");
		Iterable<ProgramEntity> ProgramEntity = this.accesServiceDataBase.findAll();
		System.out.println("antes de la consulta");
		List<ProgramDTO> facuDTO = this.modelMapperFac.map(ProgramEntity, new TypeToken<List<ProgramDTO>>() {
		}.getType());
        List full = new ArrayList<>();
        for (ProgramDTO prog : facuDTO) {
            if(prog.getDepartment().getFaculty().getId() == id_fac)
                full.add(prog);
        }
		return full;
    }


    


    
}
