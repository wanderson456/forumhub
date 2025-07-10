package br.com.forumhub.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPerfil(
        @NotBlank String nome
) {
}
