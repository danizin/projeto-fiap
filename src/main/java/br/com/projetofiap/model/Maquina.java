package br.com.projetofiap.model;

import java.util.ArrayList;
import java.util.List;

public class Maquina {

    private Long maquinaId;
    private String modelo;
    private String numeroSerial;
    private List<Pessoa> pessoasSolicitantes = new ArrayList<>();

    private Tecnico tecnicoResponsavel;

    public Long getMaquinaId() {
        return maquinaId;
    }

    public void setMaquinaId(Long maquinaId) {
        this.maquinaId = maquinaId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public List<Pessoa> getPessoasSolicitantes() {
        return pessoasSolicitantes;
    }

    public void setPessoasSolicitantes(List<Pessoa> pessoasSolicitantes) {
        this.pessoasSolicitantes = pessoasSolicitantes;
    }

    public Tecnico getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(Tecnico tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }
}
