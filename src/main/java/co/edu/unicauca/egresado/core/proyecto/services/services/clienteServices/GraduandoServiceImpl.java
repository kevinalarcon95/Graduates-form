package co.edu.unicauca.egresado.core.proyecto.services.services.clienteServices;

import java.util.List;

import javax.transaction.Transactional;

import co.edu.unicauca.egresado.core.proyecto.models.GraduandoEntity;


import co.edu.unicauca.egresado.core.proyecto.repositories.GraduandoRepository;


import co.edu.unicauca.egresado.core.proyecto.services.DTO.GraduandoDTO;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class GraduandoServiceImpl implements IGraduandoService{

    @Autowired
	private GraduandoRepository servicioAccesoBaseDatos;




    @Autowired
	@Qualifier("mapperEgresado")
	private ModelMapper modelMapper;



	@Override
	public List<GraduandoDTO> findAll() {
		Iterable<GraduandoEntity> graduadosEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta");
		List<GraduandoDTO> graduandoDTO = this.modelMapper.map(graduadosEntity, new TypeToken<List<GraduandoDTO>>() {
		}.getType());
		return graduandoDTO;
	}



	@Override
	public GraduandoDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public GraduandoEntity save(GraduandoEntity graduando) {
		graduando.setBossMail(graduando.getBossMail());
		return this.servicioAccesoBaseDatos.save(graduando);
	}


	@Override
	public GraduandoDTO update(String id, GraduandoDTO graduando) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

    /*@Override
    @Transactional(readOnly = true)
    public List<GraduandoDTO> findAll() {
        // TODO Auto-generated method stub
        System.out.println("-------------------");
		System.out.println("");
		Iterable<GraduandoEntity> graduadosEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta");
		List<GraduandoDTO> graduandoDTO = this.modelMapper.map(graduadosEntity, new TypeToken<List<GraduandoDTO>>() {
		}.getType());
		return graduandoDTO;
    }*/

    

   /* @Override
    public GraduandoDTO save(GraduandoDTO graduando) {
        // TODO Auto-generated method stub
        if (graduando.getId()!=null && this.servicioAccesoBaseDatos.existsById(graduando.getId())) {
			EntidadYaExisteException objExcepcion = new EntidadYaExisteException("Graduando con id: "
					+ graduando.getId()+" existe en la Base De Datos.");
			throw objExcepcion;
		}

		GraduandoEntity objGraduandoEntity = this.modelMapper.map(graduando, GraduandoEntity.class);
		
		validarFormulario(objGraduandoEntity.getObjFormulario());
		validarProgama(objGraduandoEntity.getProgramas());
		objGraduandoEntity.getObjFormulario().setObjGraduando(objGraduandoEntity);

		
		objGraduandoEntity.getObjReferido().setObjGraduando(objGraduandoEntity);
		objGraduandoEntity.getObjReferido().getObjTelefono().setObjReferido(objGraduandoEntity.getObjReferido());
		List<GraduandoEntity> graduandos = new ArrayList<>();
		graduandos.add(objGraduandoEntity);
		objGraduandoEntity = this.servicioAccesoBaseDatos.save(objGraduandoEntity);
		
		
		GraduandoDTO objGraduandoRespuesta = this.modelMapper.map(objGraduandoEntity, GraduandoDTO.class);
		
		return objGraduandoRespuesta;
    }




	@Override
    public GraduandoDTO update(String id, GraduandoDTO egresado) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }
*/

}
