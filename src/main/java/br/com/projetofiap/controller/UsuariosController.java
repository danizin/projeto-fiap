package br.com.projetofiap.controller;

import br.com.projetofiap.dto.UsuariosDTO;
import br.com.projetofiap.service.UsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
        var usuario = this.service.gravar(usuarioDTO);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDTO> atualizar(@RequestBody UsuariosDTO usuarioDTO, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.service.atualizar(usuarioDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        this.service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDTO> obterPorId(@PathVariable("id") Integer id) {
        var usuario = this.service.obterUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
