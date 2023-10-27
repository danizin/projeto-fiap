package br.com.projetofiap.repositories;

import br.com.projetofiap.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByCpf(String cpf);


    @Query(""" 
            SELECT usuario FROM Usuarios usuario
            WHERE usuario.cpf = :cpf and usuario.id = :id
            """)
    Optional<Usuarios> verificarUsuarioJahCadastrado(@Param("cpf") String cpf, @Param("id") Integer id);
}
