package co.edu.unicauca.graduates.core.modules.graduates_management.services.services.clientServices;

import java.util.List;

import co.edu.unicauca.graduates.core.shared.model.dto.GratingDTO;

public interface IGratingService {

	public List<GratingDTO> findAll();

	public GratingDTO findById(String id);

	public GratingDTO save(GratingDTO egresado);

	public GratingDTO update(String id, GratingDTO egresado);

	public boolean delete(String id);
}
