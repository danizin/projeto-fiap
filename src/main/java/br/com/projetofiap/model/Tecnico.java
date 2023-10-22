package br.com.projetofiap.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Tecnico extends Pessoa {

    public Tecnico(Long id, String nome, Date dataNascimento) {
        super(id, nome, dataNascimento);
    }

    public Tecnico() {

    }
}
