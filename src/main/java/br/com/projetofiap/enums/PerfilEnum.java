package br.com.projetofiap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PerfilEnum {

    ADMIN(1, "Admin"),
    TECNICO(2, "Técnico"),
    USUARIO(3, "Usuário");

    private final Integer codigo;
    private final String descricao;

    public static PerfilEnum obterPerfilPorCodigo(Integer codigo) {
        return Arrays.stream(PerfilEnum.values()).filter(perfil -> perfil.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

}
