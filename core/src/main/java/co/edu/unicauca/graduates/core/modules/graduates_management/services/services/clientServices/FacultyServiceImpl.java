package co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions.ExitEntityException;
import co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions.BusinessRuleExcepcion;
import co.edu.unicauca.graduates.core.modules.graduates_management.repositories.FacultyRepository;

import co.edu.unicauca.graduates.core.shared.model.dto.FacultyDTO;
import co.edu.unicauca.graduates.core.shared.model.dto.ProgramDTO;
import co.edu.unicauca.graduates.core.shared.model.entities.FacultyEntity;
import lombok.Data;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements IFacultyService{
    @Autowired
	private FacultyRepository accesServiceDataBase;
	

	@Autowired
	@Qualifier("mapperFacultad")
	private ModelMapper modelMapperFac;


    @Override
	public List<FacultyDTO> findAll() {
		System.out.println("-------------------");
		System.out.println("");
		Iterable<FacultyEntity> FacultyEntity = this.accesServiceDataBase.findAll();
		System.out.println("antes de la consulta");
		List<FacultyDTO> facuDTO = this.modelMapperFac.map(FacultyEntity, new TypeToken<List<FacultyDTO>>() {
		}.getType());
		return facuDTO;
	}



    
    
}
