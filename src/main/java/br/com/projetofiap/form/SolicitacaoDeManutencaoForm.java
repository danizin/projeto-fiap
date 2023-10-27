package br.com.projetofiap.form;

import java.time.LocalDate;

public class SolicitacaoDeManutencaoForm {
    private Long pessoaId;
    private String modeloMaquina;
    private String numeroSerial;
    private LocalDate dataSolicitacao;
    private String cpf;
    private String detalhesDoDefeito;

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getModeloMaquina() {
        return modeloMaquina;
    }

    public void setModeloMaquina(String modeloMaquina) {
        this.modeloMaquina = modeloMaquina;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDetalhesDoDefeito() {
        return detalhesDoDefeito;
    }

    public void setDetalhesDoDefeito(String detalhesDoDefeito) {
        this.detalhesDoDefeito = detalhesDoDefeito;
    }
}
