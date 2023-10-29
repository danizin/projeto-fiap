package br.com.projetofiap.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record CriaTermoManutencaoMaquinaDTO(@NotNull Integer codigoSolicitacao,
                                            @NotNull LocalDateTime dataPrazo,
                                            @NotNull List<Integer> codMaquinas,
                                            String observacao) {
}
