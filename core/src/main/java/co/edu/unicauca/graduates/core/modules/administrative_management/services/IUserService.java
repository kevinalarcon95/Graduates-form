package co.edu.unicauca.graduates.core.modules.administrative_management.services;

import co.edu.unicauca.graduates.core.shared.model.dto.UserDTO;

import java.util.List;

public interface IUserService {
	public List<UserDTO> findAll();
	public UserDTO findById(Long id);
	public UserDTO save(UserDTO objUser);
	public UserDTO update(Long id,UserDTO objUser);
	public boolean delete(Long id);
}
