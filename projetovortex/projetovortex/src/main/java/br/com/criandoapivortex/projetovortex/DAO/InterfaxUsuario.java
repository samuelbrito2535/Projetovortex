package br.com.criandoapivortex.projetovortex.DAO;

import br.com.criandoapivortex.projetovortex.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InterfaxUsuario extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByLinkIndicacao(String linkIndicacao);
}
