package br.com.projetofiap.model;

import java.util.Date;

public class Professor extends Pessoa {
    public Professor(Long id, String nome, Date dataNascimento) {
        super(id, nome, dataNascimento);
    }

    public String solicitar(Maquina maquina) {
        return "Estou solicitando a máquina" +" Professor: " + getNome() + " ID: " + getPessoaId() + " Data de nascimento " + getDataNascimento();
    }


}
