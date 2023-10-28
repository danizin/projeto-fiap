package br.com.projetofiap.model;

import br.com.projetofiap.enums.SituacaoMaquinaEnum;
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

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "TB_MAQUINAS")
public class Maquinas {

    @Id
    @Column(name = "COD_MAQUINA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "TX_MODELO")
    private String modelo;

    @Column(name = "TX_MARCA")
    private String marca;

    @Column(name = "TX_PATRIMONIO")
    private String patrimonio;

    @Column(name = "SG_SITUACAO")
    private SituacaoMaquinaEnum situacao;

}
