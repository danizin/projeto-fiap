package br.com.projetofiap.repositories;

import br.com.projetofiap.model.OrdensServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdensServicoRepository extends JpaRepository<OrdensServico, Integer> {
}
