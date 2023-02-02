package co.edu.unicauca.egresado.core.proyecto.services.mapper.clienteMappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Mapper {
	@Bean(name = "mapperEgresado")
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        //TypeMap<ClienteEntity, ClienteDTO> mapa = objMapper.emptyTypeMap(ClienteEntity.class, ClienteDTO.class);
        // mapa.addMappings(n ->
        // n.skip(ClienteDTO::setObjDireccion)).implicitMappings();
        //mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
        // mapa.addMappings(m -> m.skip(ClienteDTO::setCreateAt)).implicitMappings();
        return objMapper;
    }
}
