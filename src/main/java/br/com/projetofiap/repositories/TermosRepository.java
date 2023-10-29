package br.com.projetofiap.repositories;

import br.com.projetofiap.model.Termos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermosRepository extends JpaRepository<Termos, Integer> {
}
