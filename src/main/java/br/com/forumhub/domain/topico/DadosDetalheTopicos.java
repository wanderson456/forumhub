package br.com.forumhub.domain.topico;

import br.com.forumhub.domain.curso.Curso;
import br.com.forumhub.domain.resposta.DadosResposta;


import java.time.LocalDateTime;
import java.util.List;

import br.com.forumhub.domain.usuario.DadosAutor;

public record DadosDetalheTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        DadosAutor autor,
        Curso curso,
        List<DadosResposta> respostas
) {
    public DadosDetalheTopicos(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getAutor() != null ? new DadosAutor(topico.getAutor()) : null,
                topico.getCurso(),
                topico.getRespostas().stream().map(DadosResposta::new).toList()
        );
    }
}
