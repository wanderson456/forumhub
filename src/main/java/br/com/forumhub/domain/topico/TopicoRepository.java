package br.com.forumhub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    @Query("SELECT t FROM topico t WHERE t.ativo = true")

    Page<Topico> findByAtivoTrue(Pageable paginacao);
}
