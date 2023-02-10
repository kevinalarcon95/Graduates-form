
package co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions.ExitEntityException;
import co.edu.unicauca.graduates.core.modules.graduates_management.exceptionControllers.exceptions.BusinessRuleExcepcion;
import co.edu.unicauca.graduates.core.modules.graduates_management.repositories.GratingRepository;
import co.edu.unicauca.graduates.core.modules.graduates_management.repositories.FormRepository;
import co.edu.unicauca.graduates.core.shared.model.dto.AdressDTO;

import co.edu.unicauca.graduates.core.shared.model.dto.GratingDTO;
import co.edu.unicauca.graduates.core.shared.model.entities.FormEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.GratingEntity;
import lombok.Data;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GratingServiceImpl implements IGratingService{

	@Autowired
	private GratingRepository accesServiceDataBase;
	
	@Autowired
	private FormRepository accesServiceDataBaseForm;

	@Autowired
	@Qualifier("mapperGraduando")
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public List<GratingDTO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("-------------------");
		System.out.println("");
		Iterable<GratingEntity> GratingEntity = this.accesServiceDataBase.findAll();
		System.out.println("antes de la consulta");
		List<GratingDTO> egresadosDTO = this.modelMapper.map(GratingEntity, new TypeToken<List<GratingDTO>>() {
		}.getType());
		return egresadosDTO;
	}

	@Override
	public GratingDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GratingDTO save(GratingDTO graduated) {

		if (graduated.getId()!=null && this.accesServiceDataBase.existsById(graduated.getId())) {
			ExitEntityException objExcepcion = new ExitEntityException("EGRESADO con id: "
					+ graduated.getId()+" existe en la Base De Datos.");
			throw objExcepcion;
		}

		GratingEntity objGratingEntity = this.modelMapper.map(graduated, GratingEntity.class);
		validateForm(objGratingEntity.getForm());
		objGratingEntity.getForm().setGrating(objGratingEntity);
		objGratingEntity.getLocation().setGrating(objGratingEntity);
		objGratingEntity.getRefered().setGrating(objGratingEntity);
		objGratingEntity.getRefered().getPhone().setRefered(objGratingEntity.getRefered());
		List<GratingEntity> egresados = new ArrayList<>();
		egresados.add(objGratingEntity);
		objGratingEntity.getJobs().forEach(objJob->{
			objJob.setGratings(egresados);
			objJob.getBoss().setJob(objJob);

		});
		objGratingEntity = this.accesServiceDataBase.save(objGratingEntity);

		GratingDTO objAnswerGraduated = this.modelMapper.map(objGratingEntity, GratingDTO.class);
		
		return objAnswerGraduated;
	}
	
	private void validateForm(FormEntity objForm) {
		if (objForm==null) {
			throw new BusinessRuleExcepcion("FORMULARIO no puede ser nulo");
			
		}
		
		if(objForm.getId()!=null && this.accesServiceDataBaseForm.existsById(objForm.getId())) {
			throw new ExitEntityException("FORMULARIO con id: "
					+ objForm.getId()+" existe en la Base De Datos.");
		}
		
	}

	
	@Override
	public GratingDTO update(String id, GratingDTO egresado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}
