package br.com.projetofiap.controller;

import br.com.projetofiap.dto.CriaOrdemServicoDTO;
import br.com.projetofiap.services.OrdensServicosService;
import br.com.projetofiap.util.PathUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(PathUtil.API + "/ordens-servico")
@Tag(name = "5 - Ordens de Serviço", description = "Serviços disponíveis para criar Ordens de Serviço")
public class OrdensServicoController {

    private final OrdensServicosService service;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ordem de solicitação criada com sucesso")}
    )
    @Operation(summary = "Serviço responsável por criar o termo de solicitação de manutenção")
    public ResponseEntity<Void> criarTermoManutencao(@Valid @RequestBody CriaOrdemServicoDTO dto) {
        this.service.criarOrdemServico(dto);
        return ResponseEntity.ok().build();
    }

}
