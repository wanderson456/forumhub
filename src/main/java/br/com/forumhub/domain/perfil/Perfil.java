package br.com.forumhub.domain.perfil;

import jakarta.persistence.*;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean ativo = true;

    public Perfil() {}

    public Perfil(DadosCadastroPerfil dados) {
        this.nome = dados.nome();
        this.ativo = true; // opcional aqui, pois já está no campo, mas pode manter por clareza
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }


    public void excluir() {
        this.ativo = false;
    }
}
