package br.com.forumhub.domain.resposta;

import java.time.LocalDateTime;

public record DadosResposta(String mensagem, String autor, LocalDateTime dataCriacao) {
    public DadosResposta(Resposta resposta) {
        this(resposta.getMensagem(), resposta.getAutor(), resposta.getDataCriacao());
    }
}
