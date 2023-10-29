package br.com.projetofiap.repositories;

import br.com.projetofiap.model.Solicitacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacoesRepository extends JpaRepository<Solicitacoes, Integer> {



}
