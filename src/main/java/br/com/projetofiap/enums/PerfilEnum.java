package br.com.projetofiap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PerfilEnum {

    TECNICO("Técnico"),
    USUARIO("Usuário");

    private final String descricao;

}
