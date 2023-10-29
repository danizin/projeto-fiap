package br.com.projetofiap.mapper;

import br.com.projetofiap.dto.SolicitacoesDTO;
import br.com.projetofiap.model.Solicitacoes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitacoesMapper {

    Solicitacoes mapToSolicitacoes(SolicitacoesDTO dto);

    SolicitacoesDTO mapToSolicitacaoDTO(Solicitacoes solicitacoes);

}
