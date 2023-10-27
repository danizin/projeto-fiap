package br.com.projetofiap.db;

import br.com.projetofiap.model.Solicitacao;
import br.com.projetofiap.model.StatusManutencao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SolicitacaoDao {

    private static List<Solicitacao> solicitacoes = new ArrayList<>();

    public static void salvar(Solicitacao solicitacao) {
        long novoId = (solicitacoes.size() + 1);
        solicitacao.setSolicitacaoId(novoId);
        solicitacoes.add(solicitacao);
    }

    public static Optional<Solicitacao> buscarPorId(Long id) {
        return solicitacoes.stream().filter(s -> s.getSolicitacaoId().equals(id)).findFirst();
    }

    public static List<Solicitacao> todasSolicitacoes() {
        return solicitacoes;
    }

    public static List<Solicitacao> todasSolicitacoesAbertas() {
        return solicitacoes.stream().filter(s -> s.getStatusManutencao() == StatusManutencao.ABERTA).toList();
    }

    static {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setSolicitacaoId(1L);
        solicitacao.setModeloMaquina("Modelo KFK");
        solicitacao.setNumeroSerial("A23DD4");
        solicitacao.setCpfUsuario("000.000.000-00");
        solicitacao.setDetalhesDoDefeito("Ta com a tecla quebrada");
        solicitacao.setDataSolicitacao(LocalDate.now());
        solicitacao.setStatusManutencao(StatusManutencao.ABERTA);

        solicitacoes.add(solicitacao);
    }

}
