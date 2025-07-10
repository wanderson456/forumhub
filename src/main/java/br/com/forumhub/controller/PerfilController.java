package br.com.forumhub.controller;

import br.com.forumhub.domain.perfil.*;
import br.com.forumhub.domain.topico.DadosListagemTopicos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPerfil dados, UriComponentsBuilder uriBuilder) {
        var perfil = new Perfil(dados);
        repository.save(perfil);

        var uri = uriBuilder.path("/perfis/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPerfil(perfil));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPerfis>> listar(@PageableDefault(size = 10,sort = "id") Pageable paginacao){
        var page = repository.findByAtivoTrue(paginacao).map(DadosListagemPerfis::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var perfil = repository.getReferenceById(id);
        perfil.excluir();
        return ResponseEntity.noContent().build();
    }
}
