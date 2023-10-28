package br.com.projetofiap.dto;

import br.com.projetofiap.enums.SituacaoMaquinaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MaquinasDTO(Integer id,
                          @NotNull @NotBlank @Size(min = 2, max = 255) String modelo,
                          @NotNull @NotBlank @Size(min = 2, max = 255) String marca,
                          @NotNull @NotBlank @Size(min = 10, max = 10) String patrimonio,
                          SituacaoMaquinaEnum situacao) {
}
