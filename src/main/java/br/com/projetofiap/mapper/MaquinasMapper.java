package br.com.projetofiap.mapper;

import br.com.projetofiap.dto.MaquinasDTO;
import br.com.projetofiap.model.Maquinas;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaquinasMapper {


    MaquinasDTO mapToMaquinasDTO(Maquinas maquina);

    Maquinas mapToMaquina(MaquinasDTO dto);
}
