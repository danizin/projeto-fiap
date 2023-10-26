package br.com.projetofiap.service;

import br.com.projetofiap.dto.UsuariosDTO;
import br.com.projetofiap.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuariosService {

    private final UsuarioMapper mapper;

    public UsuariosDTO gravar(UsuariosDTO usuariosDTO) {
        var usuario = this.mapper.mapToUsuario(usuariosDTO);

//        TODO: Implementar método save

        return this.mapper.mapToUsuariosDTO(usuario);
    }

    public UsuariosDTO atualizar(UsuariosDTO usuariosDTO, Integer id) {
        var usuario = this.mapper.mapToUsuario(usuariosDTO);

//        TODO: pesquisar usuário com {id}

        return this.mapper.mapToUsuariosDTO(usuario);
    }

}
