package br.com.forumhub.domain.topico;

import br.com.forumhub.domain.curso.Curso;
import br.com.forumhub.domain.resposta.DadosResposta;
import br.com.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalheTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        Curso curso,
        List<DadosResposta> respostas
) {
    public DadosDetalheTopicos(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getAutor() != null ? topico.getAutor().getNome() : "Autor não informado",
                topico.getCurso(),
                topico.getRespostas().stream().map(DadosResposta::new).toList()
        );
    }

}
