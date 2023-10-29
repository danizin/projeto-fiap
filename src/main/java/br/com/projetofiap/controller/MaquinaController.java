package br.com.projetofiap.controller;

import br.com.projetofiap.dto.MaquinasDTO;
import br.com.projetofiap.dto.UsuariosDTO;
import br.com.projetofiap.services.MaquinasService;
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
@RequiredArgsConstructor
@RequestMapping(PathUtil.API + "/maquinas")
@Tag(name = "2 - Máquinas", description = "Serviços disponíveis para máquinas")
public class MaquinaController {

    private final MaquinasService service;

    @GetMapping("/{id}")
    @Operation(summary = "Serviço responsável por obter uma máquina por ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuariosDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Máquina não localizada")})
    public ResponseEntity<MaquinasDTO> obterPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(service.obterMaquinaPorId(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Máquina já cadastrada")
        }
    )
    @Operation(summary = "Serviço responsável por cadastrar uma nova máquina")
    public ResponseEntity<Void> gravar(@Valid @RequestBody MaquinasDTO maquinasDTO) {
        var maquina = this.service.gravar(maquinasDTO);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(maquina.id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso")}
    )
    @Operation(summary = "Serviço responsável por atualizar uma máquina")
    public ResponseEntity<MaquinasDTO> atualizar(@Valid @RequestBody MaquinasDTO maquinasDTO, @PathVariable Integer id) {
        return new ResponseEntity<>(service.atualizar(maquinasDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Serviço responsável por deletar uma máquina")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Máquina deletada"),
            @ApiResponse(responseCode = "404", description = "Máquina não localizada")})
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
