package br.com.projetofiap.converters;

import br.com.projetofiap.enums.PerfilEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class PerfilEnumConverter implements AttributeConverter<PerfilEnum, Integer> {


    @Override
    public Integer convertToDatabaseColumn(PerfilEnum perfil) {
        if (Objects.isNull(perfil)) {
            return null;
        }
        return perfil.getCodigo();
    }

    @Override
    public PerfilEnum convertToEntityAttribute(Integer codigo) {
        return PerfilEnum.obterPerfilPorCodigo(codigo);
    }
}


