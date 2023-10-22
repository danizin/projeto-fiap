package br.com.projetofiap.form;

import java.time.LocalDate;

public class SolicitacaoFormulario {
    private Long pessoaId;
    private String modeloMaquina;
    private LocalDate dataSolicitacao;
    private boolean aluguelParaSala;
    private Integer periodoDeDias;

    private boolean substituicaoDeMaquina;

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

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean isAluguelParaSala() {
        return aluguelParaSala;
    }

    public void setAluguelParaSala(boolean aluguelParaSala) {
        this.aluguelParaSala = aluguelParaSala;
    }

    public Integer getPeriodoDeDias() {
        return periodoDeDias;
    }

    public void setPeriodoDeDias(Integer periodoDeDias) {
        this.periodoDeDias = periodoDeDias;
    }

    public boolean isSubstituicaoDeMaquina() {
        return substituicaoDeMaquina;
    }

    public void setSubstituicaoDeMaquina(boolean substituicaoDeMaquina) {
        this.substituicaoDeMaquina = substituicaoDeMaquina;
    }
}
