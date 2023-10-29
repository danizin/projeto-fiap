package br.com.projetofiap.dto;

import jakarta.validation.constraints.NotNull;

public record AtribuiSolicitacaoDTO(@NotNull Integer codigoSolicitacao,
                                    @NotNull Integer codigoResponsavel) {
}
