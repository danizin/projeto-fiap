package br.com.projetofiap.dto;

import java.time.LocalDate;

public class SolicitacaoTo {

    private Long solicitacaoId;
    private String modelo;
    private LocalDate dataSolicitacao;
    private String cpfUsuario;
    private String detalhesDoDefeito;


    public SolicitacaoTo(Long solicitacaoId,
                         String modelo,
                         LocalDate dataSolicitacao,
                         String cpfUsuario,
                         String detalhesDoDefeito) {
        this.solicitacaoId = solicitacaoId;
        this.modelo = modelo;
        this.dataSolicitacao = dataSolicitacao;
        this.cpfUsuario = cpfUsuario;
        this.detalhesDoDefeito = detalhesDoDefeito;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
}
