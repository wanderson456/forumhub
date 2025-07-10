package br.com.forumhub.domain.curso;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
    BACK, FRONT, MOBILE, TESTES;

    @JsonCreator
    public static Categoria from(String value) {
        return Categoria.valueOf(value.toUpperCase());
    }
}

