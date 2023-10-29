package br.com.projetofiap.converters;

import br.com.projetofiap.enums.SituacaoMaquinaEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class SituacaoMaquinaEnumConverter implements AttributeConverter<SituacaoMaquinaEnum, String> {

    @Override
    public String convertToDatabaseColumn(SituacaoMaquinaEnum objEnum) {
        if (Objects.isNull(objEnum)) {
            return null;
        }
        return objEnum.getSigla();
    }

    @Override
    public SituacaoMaquinaEnum convertToEntityAttribute(String sigla) {
        return SituacaoMaquinaEnum.obterPorSigla(sigla);
    }
}


