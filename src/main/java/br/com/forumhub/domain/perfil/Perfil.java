package br.com.forumhub.domain.perfil;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean ativo = true;

    public Perfil() {}

    public Perfil(DadosCadastroPerfil dados) {
        this.nome = dados.nome();
        this.ativo = true;
    }

    public Perfil(Long id, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
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

    // Método necessário para Spring Security
    @Override
    public String getAuthority() {
        return nome;
    }
}
