package br.com.forumhub.domain.usuario;

public record DadosAutor(String username) {
    public DadosAutor(Usuario usuario) {
        this(usuario != null ? usuario.getUsername() : null);
    }
}
