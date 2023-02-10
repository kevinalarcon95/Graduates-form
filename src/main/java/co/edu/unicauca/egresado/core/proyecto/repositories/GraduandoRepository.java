package co.edu.unicauca.egresado.core.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import co.edu.unicauca.egresado.core.proyecto.models.GraduandoEntity;

public interface GraduandoRepository extends JpaRepository<GraduandoEntity, Integer>{
   
}
