package br.com.forumhub.controller;

import br.com.forumhub.domain.curso.Curso;
import br.com.forumhub.domain.curso.CursoRepository;
import br.com.forumhub.domain.curso.DadosCadastroCurso;
import br.com.forumhub.domain.curso.DadosDetalhamentoCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCurso dados, UriComponentsBuilder uriBuilder) {
        var curso = new Curso(dados.nome(), dados.categoria());
        cursoRepository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }
}

