package co.edu.unicauca.graduates.core.modules.administrative_management.repository;

import co.edu.unicauca.graduates.core.shared.model.entities.RolEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.UserEntity;
import co.edu.unicauca.graduates.core.shared.model.enums.RolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<RolEntity,Integer> {
    @Query(value = "SELECT * FROM roles WHERE rol_type =: type",nativeQuery = true)
    Optional<RolEntity> findRolByTypeRol(@Param("type") String type);

    //@Query(value = "SELECT est_estado FROM estudiante e WHERE e.esc_email =:email", nativeQuery = true)
    //public boolean estadoByEmail(@Param("email") String email);

    RolEntity findByrolType(RolType type);
}
