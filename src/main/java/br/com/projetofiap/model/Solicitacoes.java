package br.com.projetofiap.model;

import br.com.projetofiap.enums.StatusSolicitacaoEnum;
import br.com.projetofiap.enums.TipoSolicitacaoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TB_SOLICITACOES")
public class Solicitacoes {

    @Id
    @Column(name = "COD_SOLICITACAO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_USUARIO_SOLICITANTE", nullable = false)
    private Usuarios usuarioSolicitante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_USUARIO_RESPONSAVEL")
    private Usuarios usuarioResponsavel;

    @Column(name = "TX_DESCRICAO", length = 4000, nullable = false)
    private String descricao;

    @Column(name = "DT_SOLICITACAO")
    private LocalDateTime dataSolicitacao;

    @Column(name = "SG_STATUS")
    private StatusSolicitacaoEnum status;

    @Column(name = "TX_RESPOSTA", length = 4000)
    private String resposta;

    @Column(name = "DT_RESPOSTA")
    private LocalDateTime dataResposta;

    @Column(name = "SG_TIPO_SOLICITACAO")
    private TipoSolicitacaoEnum tipoSolicitacao;

}
