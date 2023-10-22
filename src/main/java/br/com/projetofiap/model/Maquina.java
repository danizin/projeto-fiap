package br.com.projetofiap.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maquinaId;

    private String modelo;
    private String numeroSerial;
    @ManyToMany
    @JoinTable(
            name = "usuario_maquina",
            joinColumns = @JoinColumn(name = "maquina_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id")
    )
    private List<Pessoa> pessoasSolicitantes = new ArrayList<>();
    @ManyToOne
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
