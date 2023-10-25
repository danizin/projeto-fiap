package br.com.projetofiap.model;

import java.util.Date;

public abstract class Pessoa {

    private Long pessoaId;
    private String nome;
    private Date dataNascimento;

    public Pessoa(Long pessoaId, String nome, Date dataNascimento) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {

    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
