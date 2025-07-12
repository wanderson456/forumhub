package br.com.forumhub.controller;

import br.com.forumhub.domain.usuario.DadosAutenticacao;
import br.com.forumhub.domain.usuario.Usuario;
import br.com.forumhub.infra.security.DadosTokenJWT;
import br.com.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoControler {
    private final AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    public AutenticacaoControler(AuthenticationManager manager){
        this.manager=manager;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationtoken = new UsernamePasswordAuthenticationToken(dados.email(),dados.senha());
        var authentication = manager.authenticate(authenticationtoken);
        var tokekJWT = tokenService.gerarToken((Usuario)authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokekJWT));
    }

}
