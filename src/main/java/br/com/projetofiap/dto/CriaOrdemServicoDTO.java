package br.com.projetofiap.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriaOrdemServicoDTO(@NotNull Integer codigoSolicitacao,
                                  @NotNull @Size(max = 4000) String descricao) {
}
