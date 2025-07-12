package br.com.forumhub.domain.resposta;

public record DadosCadastroResposta(
        String mensagem,
        Long topicoId,
        String autor,
        String solucao
) {
}
