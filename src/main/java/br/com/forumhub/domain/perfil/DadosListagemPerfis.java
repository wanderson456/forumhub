package br.com.forumhub.domain.perfil;

public record DadosListagemPerfis(
        Long id,
        String nome,
        boolean ativo
) {
    public DadosListagemPerfis(Perfil perfil) {
        this(perfil.getId(), perfil.getNome(), perfil.isAtivo());
    }
}
