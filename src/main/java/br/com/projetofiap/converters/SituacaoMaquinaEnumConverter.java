package br.com.projetofiap.converters;

import br.com.projetofiap.enums.SituacaoMaquinaEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class SituacaoMaquinaEnumConverter implements AttributeConverter<SituacaoMaquinaEnum, Integer> {


    @Override
    public Integer convertToDatabaseColumn(SituacaoMaquinaEnum objEnum) {
        if (Objects.isNull(objEnum)) {
            return null;
        }
        return objEnum.getCodigo();
    }

    @Override
    public SituacaoMaquinaEnum convertToEntityAttribute(Integer codigo) {
        return SituacaoMaquinaEnum.obterPorCodigo(codigo);
    }
}


