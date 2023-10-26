package br.com.projetofiap.dto;

import br.com.projetofiap.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class UsuariosDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private PerfilEnum perfil;

}