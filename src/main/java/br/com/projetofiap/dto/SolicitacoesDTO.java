package br.com.projetofiap.dto;

import br.com.projetofiap.enums.StatusSolicitacaoEnum;
import br.com.projetofiap.enums.TipoSolicitacaoEnum;

import java.time.LocalDateTime;

public record SolicitacoesDTO(Integer id,
                              UsuariosDTO usuarioSolicitante,
                              UsuariosDTO usuarioResponsavel,
                              String descricao,
                              LocalDateTime dataSolicitacao,
                              StatusSolicitacaoEnum status,
                              String resposta,
                              LocalDateTime dataResposta,
                              TipoSolicitacaoEnum tipoSolicitacao) {
}
