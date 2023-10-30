package br.com.projetofiap.model;

import br.com.projetofiap.enums.PerfilEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "TB_USUARIOS")
public class Usuarios {

    @Id
    @Column(name = "COD_USUARIO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_CPF")
    private String cpf;

    @Column(name = "TX_EMAIL", length = 50)
    private String email;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "COD_PERFIL")
    private PerfilEnum perfil;

}
