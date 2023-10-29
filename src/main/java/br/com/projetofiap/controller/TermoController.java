package br.com.projetofiap.controller;

import br.com.projetofiap.dto.CriaTermoEmprestimoMaquinaDTO;
import br.com.projetofiap.dto.CriaTermoManutencaoMaquinaDTO;
import br.com.projetofiap.services.TermosServices;
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
@RequestMapping(PathUtil.API + "/termos")
@Tag(name = "4 - Termo", description = "Serviços disponíveis para criação de termos para liberação e aquisição de equipamentos")
public class TermoController {

    private final TermosServices termosServices;

    @PostMapping("/manutencao-maquina")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Termo de solicitação criado com sucesso")}
    )
    @Operation(summary = "Serviço responsável por criar o termo de solicitação de manutenção")
    public ResponseEntity<Void> criarTermoManutencao(@Valid @RequestBody CriaTermoManutencaoMaquinaDTO dto) {
        this.termosServices.criarTermoManutencao(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/emprestimo-maquina")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Termo de solicitação criado com sucesso")}
    )
    @Operation(summary = "Serviço responsável por criar o termo de solicitação de empréstimo de máquina")
    public ResponseEntity<Void> criarTermoManutencao(@Valid @RequestBody CriaTermoEmprestimoMaquinaDTO dto) {
        this.termosServices.criarTermoEmprestimoMaquina(dto);
        return ResponseEntity.ok().build();
    }

}
