package br.com.projetofiap.mapper;

import br.com.projetofiap.dto.UsuariosDTO;
import br.com.projetofiap.model.Usuarios;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    UsuariosDTO mapToUsuariosDTO(Usuarios usuario);

    Usuarios mapToUsuario(UsuariosDTO usuarioDTO);
}
