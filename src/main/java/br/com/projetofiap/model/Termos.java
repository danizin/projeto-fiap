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
@Table(name = "TB_TERMOS")
public class Termos {

    @Id
    @Column(name = "COD_TERMO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_SOLICITACAO", nullable = false)
    private Solicitacoes solicitacao;

    @Column(name = "DT_TERMO")
    private LocalDateTime dataTermo;

    @Column(name = "DT_PRAZO")
    private LocalDateTime dataPrazo;

    @Column(name = "TX_OBSERVACAO", length = 4000)
    private String observacao;
}
