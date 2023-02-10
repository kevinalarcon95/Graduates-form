package co.edu.unicauca.graduates.core.modules.administrative_management.services;

import co.edu.unicauca.graduates.core.modules.administrative_management.repository.RolRepository;
import co.edu.unicauca.graduates.core.modules.administrative_management.repository.UserRepository;
import co.edu.unicauca.graduates.core.shared.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.graduates.core.shared.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.graduates.core.shared.exceptionControllers.exceptions.ReglaNegocioExcepcion;
import co.edu.unicauca.graduates.core.shared.model.dto.RolDTO;
import co.edu.unicauca.graduates.core.shared.model.dto.UserDTO;
import co.edu.unicauca.graduates.core.shared.model.entities.RolEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.UserEntity;
import co.edu.unicauca.graduates.core.shared.model.enums.RolType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository servicioAccesoBaseDatos;

	@Autowired
	private RolRepository repositoryRol;

	@Autowired
	@Qualifier("mapperUser")
	private ModelMapper modelMapper;



	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<UserEntity> usersEntity = this.servicioAccesoBaseDatos.findAll();
		List<UserDTO> usersDTO = this.modelMapper.map(usersEntity, new TypeToken<List<UserDTO>>() {}.getType());
		for (int i=0;i<usersDTO.size();i++){
			this.obtenerListRoles(usersDTO.get(i));
		}
		return usersDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		this.validarExistaIdUser(id);
		UserDTO userDTO = this.modelMapper.map(this.servicioAccesoBaseDatos.findById(id).get(), UserDTO.class);
		this.obtenerListRoles(userDTO);
		return userDTO;
	}

	private void validarExistaIdUser(Long id){
		if (!this.servicioAccesoBaseDatos.existsById(id)){
			EntidadNoExisteException objException = new EntidadNoExisteException("User con id " + id + ", No existe en la BD...");
			throw objException;
		}
	}

	@Override
	public UserDTO save(UserDTO objUser) {
		this.validarNoExistaIdUser(objUser.getId());
		UserEntity objUserEntity = this.modelMapper.map(objUser,UserEntity.class);
		this.obtenerRolesEntity(objUser.getListRoles(),objUserEntity);
		objUserEntity.setCreateAt(LocalDate.now());
		objUserEntity.setUpdateAt(LocalDate.now());
		UserEntity objUserResponse = this.servicioAccesoBaseDatos.save(objUserEntity);

		UserDTO userDTO = this.modelMapper.map(objUserResponse,UserDTO.class);
		this.obtenerListRoles(userDTO);
		return userDTO;
	}

	private void obtenerRolesEntity(List<RolType> roles,UserEntity objUser){
		for(RolType rol:roles){
			RolEntity objRol = this.repositoryRol.findByrolType(rol);
			objUser.getRoles().add(objRol);
		}
	}

	private void obtenerListRoles(UserDTO objUser){
		for(RolDTO objRol:objUser.getRoles()){
			objUser.getListRoles().add(objRol.getRolType());
		}
		objUser.setRoles(null);
	}

	private void validarNoExistaIdUser(Long id){
		if (this.servicioAccesoBaseDatos.existsById(id)){
			EntidadYaExisteException objException = new EntidadYaExisteException("User con id "+ id +", ya se encuentra registrado...");
			throw objException;
		}
	}
	@Override
	public UserDTO update(Long id, UserDTO objUser) {
		this.validarExistaIdUser(id);
		UserDTO objUserResponseDTO = null;
		if(id.compareTo(objUser.getId())==0){
			objUser.setId(id);
			objUser.setUpdateAt(LocalDate.now());
			objUserResponseDTO = this.update(objUser);
		}else{
			ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion("User con id "+id+", No coincide con el user a actualizar...");
			throw objException;
		}
		return objUserResponseDTO;
	}

	private UserDTO update(UserDTO objUser) {
		UserEntity objUserEntity = this.modelMapper.map(objUser,UserEntity.class);
		this.obtenerRolesEntity(objUser.getListRoles(),objUserEntity);
		objUserEntity.setCreateAt(LocalDate.now());
		UserEntity objUserResponse = this.servicioAccesoBaseDatos.save(objUserEntity);

		UserDTO userDTO = this.modelMapper.map(objUserResponse,UserDTO.class);
		this.obtenerListRoles(userDTO);
		return userDTO;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		boolean bandera = false;
		UserEntity usuario = this.servicioAccesoBaseDatos.findById(id).orElse(null);
		if (usuario == null) {
			EntidadNoExisteException objException = new EntidadNoExisteException(
					"Usuario con id " + id + " no existe en la BD");
			throw objException;
		} else {
			this.servicioAccesoBaseDatos.deleteById(usuario.getId());
			bandera = true;
		}
		return bandera;
	}
}
