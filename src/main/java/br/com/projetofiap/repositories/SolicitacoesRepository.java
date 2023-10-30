package br.com.projetofiap.repositories;

import br.com.projetofiap.model.Solicitacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacoesRepository extends JpaRepository<Solicitacoes, Integer> {

    @Query(""" 
           SELECT s FROM Solicitacoes s
           where s.usuarioResponsavel.id = :codigoUsuario or s.usuarioSolicitante.id = :codigoUsuario
           """)
    List<Solicitacoes> obterSolicitacoesUsuario(@Param("codigoUsuario") Integer codigoUsuario);

}
