package br.com.projetofiap.dto;

import br.com.projetofiap.enums.TipoSolicitacaoEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AbreSolicitacaoDTO(Integer id,
                                 @NotNull Integer codUsuarioSolicitante,
                                 @NotNull @Size(max = 4000) String descricao,
                                 @NotNull TipoSolicitacaoEnum tipoSolicitacao) {
}
