package br.com.projetofiap.controller;

import br.com.projetofiap.dto.AbreSolicitacaoDTO;
import br.com.projetofiap.dto.AtribuiSolicitacaoDTO;
import br.com.projetofiap.dto.CancelaSolicitacaoDTO;
import br.com.projetofiap.dto.SolicitacoesDTO;
import br.com.projetofiap.services.SolicitacoesService;
import br.com.projetofiap.util.PathUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping(PathUtil.API + "/solicitacoes")
@Tag(name = "3 - Solicitações", description = "Serviços disponíveis para abertura, acompanhamento e fechamento de chamados")
public class SolicitacoesController {

    private final SolicitacoesService service;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso")}
    )
    @Operation(summary = "Serviço responsável por criar novo chamado")
    public ResponseEntity<Void> abrirChamado(@Valid @RequestBody AbreSolicitacaoDTO solicitacoesDTO) {
        var id = this.service.criarSolicitacao(solicitacoesDTO);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/cancelar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitação cancelada")}
    )
    @Operation(summary = "Serviço responsável por cancelar uma solicitação")
    public ResponseEntity<Void> cancelarChamado(@Valid @RequestBody CancelaSolicitacaoDTO dto) {
        this.service.cancelarSolicitacao(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/atribuir-solicitacao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitação cancelada")}
    )
    @Operation(summary = "Serviço responsável por atribuir solicitação ao técnico")
    public ResponseEntity<Void> atribuirSolicitacao(@Valid @RequestBody AtribuiSolicitacaoDTO dto) {
        this.service.atribuirSolicitacao(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacoesDTO> obterSolicitacao(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.obterSolicitacaoPorId(id), HttpStatus.OK);
    }



}
