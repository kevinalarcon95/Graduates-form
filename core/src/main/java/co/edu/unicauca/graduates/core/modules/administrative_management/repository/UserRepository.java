package co.edu.unicauca.graduates.core.modules.administrative_management.repository;

import co.edu.unicauca.graduates.core.shared.model.dto.RolDTO;
import co.edu.unicauca.graduates.core.shared.model.entities.RolEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByName(String name);
    boolean existsByName(String name);
    boolean existsByEmail(String email);

    @Query(value = "SELECT rol_id, rol_type FROM Users natural join user_rol natural join roles WHERE rol_type =:type",nativeQuery = true)
    RolEntity findRolByTypeRol(@Param("type") String type);

    //@Query(value = "SELECT est_estado FROM estudiante e WHERE e.esc_email =:email", nativeQuery = true)
    //public boolean estadoByEmail(@Param("email") String email);
}
