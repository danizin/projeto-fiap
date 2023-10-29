package br.com.projetofiap.controller;

import br.com.projetofiap.dto.UsuariosDTO;
import br.com.projetofiap.services.UsuariosService;
import br.com.projetofiap.util.PathUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@RestController
@RequestMapping(PathUtil.API + "/usuarios")
@RequiredArgsConstructor
@Tag(name = "1 - Usuários", description = "Serviços disponíveis ao usuário")
public class UsuariosController {

    private final UsuariosService service;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso")}
    )
    @Operation(summary = "Serviço responsável por cadastrar um novo usuário")
    public ResponseEntity<Void> gravar(@Valid @RequestBody UsuariosDTO usuarioDTO) {
        var usuario = this.service.gravar(usuarioDTO);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Serviço responsável por atualizar os dados do usuário")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Usuário atualizado", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UsuariosDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    public ResponseEntity<UsuariosDTO> atualizar(@Valid @RequestBody UsuariosDTO usuarioDTO, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.service.atualizar(usuarioDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Serviço responsável por deletar um novo usuário")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Usuário excluído"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        this.service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Serviço responsável por obter usuário por ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuariosDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    public ResponseEntity<UsuariosDTO> obterPorId(@PathVariable("id") Integer id) {
        var usuario = this.service.obterUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
