package br.com.forumhub.domain.topico;

import br.com.forumhub.domain.curso.Curso;
import br.com.forumhub.domain.resposta.Resposta;

import java.time.LocalDateTime;

public record DadosDetalheTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,

        String autor,
        Curso curso,
        Resposta resposta

) {
    public DadosDetalheTopicos(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getResposta() != null ? topico.getResposta().getAutor() : null,  // autor dentro da resposta
                topico.getCurso(),
                topico.getResposta()
        );
    }

}
