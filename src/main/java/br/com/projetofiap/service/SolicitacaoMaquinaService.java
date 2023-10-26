package br.com.projetofiap.service;


import br.com.projetofiap.db.SolicitacaoDao;
import br.com.projetofiap.exception.SolicitacaoInvalidaException;
import br.com.projetofiap.form.SolicitacaoDeManutencaoForm;
import br.com.projetofiap.form.SolicitacaoFormulario;
import br.com.projetofiap.model.Solicitacao;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoMaquinaService {

    public String solicitarMaquina(SolicitacaoFormulario solcitacaoForm) {
        //TODO
        return "";
    }

    public void solicitarManutencao(SolicitacaoDeManutencaoForm solcitacaoForm) {
        try {
            validarCamposObrigatorios(solcitacaoForm);

            Solicitacao solicitacao = new Solicitacao(
                    solcitacaoForm.getModeloMaquina(),
                    solcitacaoForm.getNumeroSerial(),
                    solcitacaoForm.getDataSolicitacao(),
                    solcitacaoForm.getCpf(),
                    solcitacaoForm.getDetalhesDoDefeito()
            );

            SolicitacaoDao.salvar(solicitacao);
        } catch (Exception e) {
            throw new SolicitacaoInvalidaException("Erro ao solicitar manutenção: " + e.getMessage());
        }
    }

    private void validarCamposObrigatorios(SolicitacaoDeManutencaoForm solcitacaoForm) {
        if (solcitacaoForm.getModeloMaquina() == null || solcitacaoForm.getModeloMaquina().trim().isEmpty()) {
            throw new SolicitacaoInvalidaException("Modelo da máquina é obrigatório.");
        }
        if (solcitacaoForm.getNumeroSerial() == null || solcitacaoForm.getNumeroSerial().trim().isEmpty()) {
            throw new SolicitacaoInvalidaException("Número serial é obrigatório.");
        }
        if (solcitacaoForm.getDataSolicitacao() == null) {
            throw new SolicitacaoInvalidaException("Data de solicitação é obrigatória.");
        }
        if (solcitacaoForm.getCpf() == null || solcitacaoForm.getCpf().trim().isEmpty()) {
            throw new SolicitacaoInvalidaException("CPF é obrigatório.");
        }
        if (solcitacaoForm.getDetalhesDoDefeito() == null || solcitacaoForm.getDetalhesDoDefeito().trim().isEmpty()) {
            throw new SolicitacaoInvalidaException("Detalhes do defeito são obrigatórios.");
        }
    }
}
