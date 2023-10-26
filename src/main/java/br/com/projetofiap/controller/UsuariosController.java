package br.com.projetofiap.controller;

import br.com.projetofiap.dto.UsuariosDTO;
import br.com.projetofiap.service.UsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuariosController {

    private final UsuariosService service;

    @PostMapping
    public ResponseEntity<UsuariosDTO> gravar(@RequestBody UsuariosDTO usuarioDTO) {
        UsuariosDTO usuario = this.service.gravar(usuarioDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDTO> atualizar(@RequestBody UsuariosDTO usuarioDTO, @PathVariable("id") Integer id) {
        UsuariosDTO usuario = this.service.atualizar(usuarioDTO, id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
