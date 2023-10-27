package br.com.projetofiap.model;

import java.time.LocalDate;

public class Solicitacao {

    private Long solicitacaoId;
    private String modeloMaquina;
    private String numeroSerial;
    private LocalDate dataSolicitacao;
    private String cpfUsuario;
    private String detalhesDoDefeito;

    private StatusManutencao statusManutencao;

    public Solicitacao() {
    }

    public Solicitacao(String modeloMaquina,
                       String numeroSerial,
                       LocalDate dataSolicitacao,
                       String cpfUsuario,
                       String detalhesDoDefeito,
                       StatusManutencao statusManutencao) {
        this.modeloMaquina = modeloMaquina;
        this.numeroSerial = numeroSerial;
        this.dataSolicitacao = dataSolicitacao;
        this.cpfUsuario = cpfUsuario;
        this.detalhesDoDefeito = detalhesDoDefeito;
        this.statusManutencao = statusManutencao;
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

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getDetalhesDoDefeito() {
        return detalhesDoDefeito;
    }

    public void setDetalhesDoDefeito(String detalhesDoDefeito) {
        this.detalhesDoDefeito = detalhesDoDefeito;
    }

    public StatusManutencao getStatusManutencao() {
        return statusManutencao;
    }

    public void setStatusManutencao(StatusManutencao statusManutencao) {
        this.statusManutencao = statusManutencao;
    }
}
