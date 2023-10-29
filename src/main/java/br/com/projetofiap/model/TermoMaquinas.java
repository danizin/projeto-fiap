package br.com.projetofiap.model;

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

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "TB_TERMOS_MAQUINAS")
public class TermoMaquinas {

    @Id
    @Column(name = "COD_TERMO_MAQUINA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TERMO", nullable = false)
    private Termos termo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_MAQUINA", nullable = false)
    private Maquinas maquina;

    @Column(name = "FL_BLOQUEADA")
    private Boolean bloqueada;
}
