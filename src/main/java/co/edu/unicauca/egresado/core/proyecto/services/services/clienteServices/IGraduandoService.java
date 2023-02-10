package co.edu.unicauca.egresado.core.proyecto.services.services.clienteServices;

import java.util.List;

import co.edu.unicauca.egresado.core.proyecto.models.GraduandoEntity;
import co.edu.unicauca.egresado.core.proyecto.services.DTO.GraduandoDTO;


public interface IGraduandoService {

    public List<GraduandoDTO> findAll();

	public GraduandoDTO findById(String id);

	public GraduandoEntity save(GraduandoEntity graduando);

	public GraduandoDTO update(String id, GraduandoDTO graduando);

	public boolean delete(String id);
	
}
