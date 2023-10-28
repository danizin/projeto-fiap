package br.com.projetofiap.dto;

import br.com.projetofiap.enums.PerfilEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UsuariosDTO(Integer id,
                          @NotBlank @Size(min = 3, max = 50, message = "O nome do usuário precisa ter entre 3 e 50 caracteres") String nome,
                          @CPF(message = "CPF inválido") @NotNull String cpf,
                          @NotNull @PastOrPresent(message = "Informar a data de nascimento igual ou menor que a data de hoje") LocalDate dataNascimento,
                          @NotNull(message = "Perfil obrigatório") PerfilEnum perfil) {
}
