package br.com.forumhub.domain.topico;

import br.com.forumhub.domain.curso.Curso;
import br.com.forumhub.domain.resposta.DadosResposta;
import br.com.forumhub.domain.resposta.Resposta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.forumhub.domain.usuario.DadosAutor;


public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Curso curso,
        DadosAutor autor,       // autor agora é só o DTO
        List<DadosResposta> respostas

) {
    public DadosListagemTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getCurso(),
                topico.getAutor() != null ? new DadosAutor(topico.getAutor()) : new DadosAutor("não informado"),
                topico.getRespostas()
                        .stream()
                        .map(DadosResposta::new)  // Converte Resposta para DadosResposta
                        .collect(Collectors.toList())
        );
    }
}


