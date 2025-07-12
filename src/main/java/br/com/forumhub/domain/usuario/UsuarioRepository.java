package br.com.forumhub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Retorna Optional para facilitar controle de null
    Optional<Usuario> findByEmail(String email);

}
