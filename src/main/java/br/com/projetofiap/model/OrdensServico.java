package br.com.projetofiap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "TB_ORDEM_SERVICO")
public class OrdensServico {

    @Id
    @Column(name = "COD_ORDEM_SERVICO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_SOLICITACAO", nullable = false)
    private Solicitacoes solicitacao;

    @Column(name = "TX_DESCRICAO", length = 4000, nullable = false)
    private String descricao;

    @Column(name = "DT_ORDEM", nullable = false)
    private LocalDateTime dataOrdem;

}
