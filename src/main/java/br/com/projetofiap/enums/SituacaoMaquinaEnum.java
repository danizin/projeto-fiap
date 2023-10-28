package br.com.projetofiap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SituacaoMaquinaEnum {

    ATIVA(1, "Ativa"),
    BAIXADA(2, "Baixada");

    private final Integer codigo;
    private final String descricao;

    public static SituacaoMaquinaEnum obterPorCodigo(Integer codigo) {
        return Arrays.stream(SituacaoMaquinaEnum.values()).filter(obj -> obj.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

}
