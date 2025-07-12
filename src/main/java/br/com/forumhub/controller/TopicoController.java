package br.com.forumhub.controller;

import br.com.forumhub.domain.curso.CursoRepository;
import br.com.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.SecurityMarker;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")

public class TopicoController {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        var curso = cursoRepository.findById(dados.idCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        var topico = new Topico(dados, curso,null);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalheTopicos(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(@PageableDefault(size = 10,sort = "id")Pageable paginacao){
        var page = repository.findByAtivoTrue(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public  ResponseEntity atualizar( @RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformaçoes(dados);
        return ResponseEntity.ok(new DadosDetalheTopicos(topico));
    }
@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir( @PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();

}
@GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id ){
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalheTopicos(topico));
}


}
