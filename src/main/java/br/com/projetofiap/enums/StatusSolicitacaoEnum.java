package br.com.projetofiap.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StatusSolicitacaoEnum {

    AGUARDANDO(1, "AG", "Aguardando"),
    EM_ANALISE(2,"EA",  "Em análise"),
    EM_MANUTENCAO(3, "EM", "Em Manutenção"),
    CANCELADO(4, "CA", "Cancelado"),
    FINALIZADO(5, "FI", "Finalizado");

    private final Integer codigo;
    private final String sigla;
    private final String descricao;

    public static StatusSolicitacaoEnum obterPorSigla(String sigla) {
        return Arrays.stream(StatusSolicitacaoEnum.values())
                .filter(status -> status.getSigla().equalsIgnoreCase(sigla))
                .findFirst().orElse(null);
    }

}
