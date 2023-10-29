package br.com.projetofiap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SituacaoMaquinaEnum {

    ATIVA(1, "A", "Ativa"),
    BAIXADA(2, "B", "Baixada");

    private final Integer codigo;
    private final String sigla;
    private final String descricao;

    public static SituacaoMaquinaEnum obterPorSigla(String sigla) {
        return Arrays.stream(SituacaoMaquinaEnum.values())
                .filter(obj -> obj.getSigla().equalsIgnoreCase(sigla))
                .findFirst().orElse(null);
    }

}
