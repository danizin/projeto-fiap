package br.com.projetofiap.service;


import br.com.projetofiap.db.SolicitacaoDao;
import br.com.projetofiap.dto.SolicitacaoTo;
import br.com.projetofiap.model.Solicitacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {

    public List<SolicitacaoTo> obterSolicitacoes() {
        return SolicitacaoDao.todasSolicitacoes().stream().map(this::converterTO).toList();
    }

    public List<Solicitacao> obterSolicitacoesAbertas() {
        return SolicitacaoDao.todasSolicitacoesAbertas();
    }

    private SolicitacaoTo converterTO(Solicitacao solicitacao) {
        String modeloEserial = solicitacao.getModeloMaquina() + " - " + solicitacao.getNumeroSerial();
        return new SolicitacaoTo(
                solicitacao.getSolicitacaoId(),
                modeloEserial,
                solicitacao.getDataSolicitacao(),
                solicitacao.getCpfUsuario(),
                solicitacao.getDetalhesDoDefeito()
        );
    }
}
