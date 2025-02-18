package com.geoloc.geolocalizacao.controller;

import com.geoloc.geolocalizacao.controller.dtos.DadosAtualizacaoRelato;
import com.geoloc.geolocalizacao.controller.dtos.DadosCadastroRelato;
import com.geoloc.geolocalizacao.controller.dtos.DadosListagemRelato;
import com.geoloc.geolocalizacao.model.service.RelatoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("relatos")
@SecurityRequirement(name = "bearer-key")
public class RelatoController {

    @Autowired
    private RelatoService relatoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroRelato dados, UriComponentsBuilder uriBuilder) {
        var dto = relatoService.cadastrar(dados);
        var uri = uriBuilder.path("/relatos/{id}").buildAndExpand(dto.idRelato()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var dto = relatoService.detalhar(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRelato>> listar() {
        var dto = relatoService.listar();

        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoRelato dados) {
        var dto = relatoService.atualizar(dados);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var dto = relatoService.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dto);
    }

}
