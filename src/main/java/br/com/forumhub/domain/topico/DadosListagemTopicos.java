package br.com.forumhub.domain.topico;

import br.com.forumhub.domain.curso.Curso;
import br.com.forumhub.domain.resposta.Resposta;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,

        Curso curso,
        Resposta resposta
) {
    public DadosListagemTopicos(Topico topico){
        this(topico.getId(),topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),topico.getCurso(),topico.getResposta());
    }
}
