package br.com.projetofiap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CancelaSolicitacaoDTO(@NotNull Integer codigoSolicitacao,
                                    @NotNull Integer codigoUsuarioResponsavel,
                                    @NotNull @NotBlank String resposta) {
}
