package br.com.projetofiap.repositories;

import br.com.projetofiap.model.TermoMaquinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermoMaquinasRepository extends JpaRepository<TermoMaquinas, Integer> {

    @Query(""" 
            SELECT tm FROM TermoMaquinas tm
            INNER JOIN Maquinas m on tm.maquina.id = m.id
            where m.id in (:id)
            """)
    List<TermoMaquinas> obterTermoMaquinaPorCodigoMaquina(@Param("id") List<Integer> codMaquinas);
}
