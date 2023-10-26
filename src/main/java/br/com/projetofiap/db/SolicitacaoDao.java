package br.com.projetofiap.db;

import br.com.projetofiap.model.Solicitacao;

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

}
