package br.com.projetofiap.model;

import java.time.LocalDate;

public class Solicitacao {

    private Long solicitacaoId;
    private String modeloMaquina;
    private String numeroSerial;
    private LocalDate dataSolicitacao;
    private String cpf;
    private String detalhesDoDefeito;

    public Solicitacao() {
    }

    public Solicitacao(String modeloMaquina, String numeroSerial, LocalDate dataSolicitacao, String cpf, String detalhesDoDefeito) {
        this.modeloMaquina = modeloMaquina;
        this.numeroSerial = numeroSerial;
        this.dataSolicitacao = dataSolicitacao;
        this.cpf = cpf;
        this.detalhesDoDefeito = detalhesDoDefeito;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
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
