package br.com.projetofiap.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CriaTermoEmprestimoMaquinaDTO(@NotNull Integer codigoSolicitacao,
                                            @NotNull List<Integer> codMaquinas,
                                            String observacao) {
}
