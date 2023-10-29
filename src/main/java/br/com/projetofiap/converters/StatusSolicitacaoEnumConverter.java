package br.com.projetofiap.converters;

import br.com.projetofiap.enums.StatusSolicitacaoEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class StatusSolicitacaoEnumConverter implements AttributeConverter<StatusSolicitacaoEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusSolicitacaoEnum objEnum) {
        if (Objects.isNull(objEnum)) {
            return null;
        }
        return objEnum.getSigla();
    }

    @Override
    public StatusSolicitacaoEnum convertToEntityAttribute(String sigla) {
        return StatusSolicitacaoEnum.obterPorSigla(sigla);
    }
}


