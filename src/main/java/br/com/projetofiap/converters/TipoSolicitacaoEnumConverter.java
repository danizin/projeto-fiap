package br.com.projetofiap.converters;

import br.com.projetofiap.enums.TipoSolicitacaoEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class TipoSolicitacaoEnumConverter implements AttributeConverter<TipoSolicitacaoEnum, String> {

    @Override
    public String convertToDatabaseColumn(TipoSolicitacaoEnum objEnum) {
        if (Objects.isNull(objEnum)) {
            return null;
        }
        return objEnum.getSigla();
    }

    @Override
    public TipoSolicitacaoEnum convertToEntityAttribute(String sigla) {
        return TipoSolicitacaoEnum.obterPorSigla(sigla);
    }
}


