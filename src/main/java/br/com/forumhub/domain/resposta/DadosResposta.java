package br.com.forumhub.domain.resposta;

import br.com.forumhub.domain.usuario.DadosAutor;

import java.time.LocalDateTime;

public record DadosResposta
        (

                String mensagem,
                DadosAutor autor,
                String solucao,
                LocalDateTime dataCriacao )


         {
             public DadosResposta(Resposta resposta) {
                 this(

                         resposta.getMensagem(),
                         resposta.getAutor() != null ? new DadosAutor(resposta.getAutor()) : null,
                         resposta.getSolucao(),
                         resposta.getDataCriacao()
                 );
             }

}


