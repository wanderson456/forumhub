package br.com.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(

        @NotBlank
        String nome, // ok

        @NotNull
        Categoria categoria // ok

) {
}
