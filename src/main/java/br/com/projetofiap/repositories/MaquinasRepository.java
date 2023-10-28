package br.com.projetofiap.repositories;

import br.com.projetofiap.model.Maquinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinasRepository extends JpaRepository<Maquinas, Integer> {

    Maquinas findByPatrimonio(String patrimonio);

}
