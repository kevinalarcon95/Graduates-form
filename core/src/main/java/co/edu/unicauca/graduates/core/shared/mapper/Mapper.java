package co.edu.unicauca.graduates.core.shared.mapper;

import co.edu.unicauca.graduates.core.shared.model.dto.*;
import co.edu.unicauca.graduates.core.shared.model.entities.BossEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.DepartmentEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.FacultyEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.ProgramEntity;
import co.edu.unicauca.graduates.core.shared.model.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean(name = "mapperEgresado")
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();

        TypeMap<ProgramEntity, ProgramDTO> mapa = objMapper.emptyTypeMap(ProgramEntity.class, ProgramDTO.class);
        mapa.addMappings(n -> n.skip(ProgramDTO::setDepartment)).implicitMappings();



        //Hide boss
        TypeMap<BossEntity, BossDTO> mapa2 = objMapper.emptyTypeMap(BossEntity.class, BossDTO.class);
        mapa2.addMappings(n -> n.skip(BossDTO::setJob)).implicitMappings();

        return objMapper;
    }

    @Bean(name = "mapperGraduando")
    public ModelMapper modelMapperGrad() {
        ModelMapper objMapper = new ModelMapper();

        TypeMap<ProgramEntity, ProgramDTO> mapa = objMapper.emptyTypeMap(ProgramEntity.class, ProgramDTO.class);
        mapa.addMappings(n -> n.skip(ProgramDTO::setDepartment)).implicitMappings();



        //Hide boss
        TypeMap<BossEntity, BossDTO> mapa2 = objMapper.emptyTypeMap(BossEntity.class, BossDTO.class);
        mapa2.addMappings(n -> n.skip(BossDTO::setJob)).implicitMappings();

        return objMapper;
    }

    @Bean(name = "mapperFacultad")
    public ModelMapper modelMapperFac(){
    ModelMapper objMapper = new ModelMapper();

    /*TypeMap<ProgramEntity, ProgramDTO> mapa = objMapper.emptyTypeMap(ProgramEntity.class, ProgramDTO.class);
        mapa.addMappings(n -> n.skip(ProgramDTO::setDepartment)).implicitMappings();*/

    return objMapper;
    }

    @Bean(name = "mapperPrograma")
    public ModelMapper modelMapperPr(){
    ModelMapper objMapper = new ModelMapper();

    

    return objMapper;
    }


    @Bean(name = "mapperUser")
    public ModelMapper modelMapperUser() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<UserEntity, UserDTO> mapa = objMapper.emptyTypeMap(UserEntity.class, UserDTO.class);
        //mapa.addMappings(n -> n.skip(UserDTO::setPassword)).implicitMappings();
        mapa.addMappings(n -> n.skip(UserDTO::setListRoles)).implicitMappings();
        //mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
        // mapa.addMappings(m -> m.skip(ClienteDTO::setCreateAt)).implicitMappings();
        return objMapper;
    }
}
