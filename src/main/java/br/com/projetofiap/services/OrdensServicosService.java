package br.com.projetofiap.services;

import br.com.projetofiap.dto.CriaOrdemServicoDTO;
import br.com.projetofiap.exception.NegocioException;
import br.com.projetofiap.model.OrdensServico;
import br.com.projetofiap.model.Solicitacoes;
import br.com.projetofiap.repositories.OrdensServicoRepository;
import br.com.projetofiap.repositories.SolicitacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static br.com.projetofiap.enums.StatusSolicitacaoEnum.EM_ANALISE;
import static br.com.projetofiap.enums.StatusSolicitacaoEnum.FINALIZADO;
import static br.com.projetofiap.enums.TipoSolicitacaoEnum.COMPRA;

@Service
@RequiredArgsConstructor
public class OrdensServicosService {

    private final OrdensServicoRepository repository;
    private final SolicitacoesRepository solicitacoesRepository;


    public void criarOrdemServico(CriaOrdemServicoDTO dto) {
        var solicitacao = this.obterSolicitacao(dto.codigoSolicitacao());

        validarSolicitacao(solicitacao);

        solicitacao.setStatus(FINALIZADO);

        var ordemServico = new OrdensServico();
        ordemServico.setDataOrdem(LocalDateTime.now());
        ordemServico.setDescricao(dto.descricao());
        ordemServico.setSolicitacao(this.solicitacoesRepository.save(solicitacao));

        this.repository.save(ordemServico);
    }

    private void validarSolicitacao(Solicitacoes solicitacao) {
        if (!solicitacao.getStatus().equals(EM_ANALISE)) {
            throw new NegocioException("A solicitação não foi atribuída a um técnico");
        }
        if (!solicitacao.getTipoSolicitacao().equals(COMPRA)) {
            throw new NegocioException("Alterar a solicitação para o tipo de compra");
        }
    }

    private Solicitacoes obterSolicitacao(Integer codigoSolicitacao) {
        return this.solicitacoesRepository.findById(codigoSolicitacao)
                .orElseThrow(() -> new NegocioException("Código da solicitação inválido"));
    }

}
