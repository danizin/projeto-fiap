package br.com.projetofiap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TipoSolicitacaoEnum {

    COMPRA(1, "C", "Compra"),
    MANUTENTACAO(2,"M",  "Manutenção"),
    EMPRESTIMO_EQUIPAMENTO(3, "E", "Empréstimo de equipamento");

    private final Integer codigo;
    private final String sigla;
    private final String descricao;

    public static TipoSolicitacaoEnum obterPorSigla(String sigla) {
        return Arrays.stream(TipoSolicitacaoEnum.values())
                .filter(status -> status.getSigla().equalsIgnoreCase(sigla))
                .findFirst().orElse(null);
    }

}
