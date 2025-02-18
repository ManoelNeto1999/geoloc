package com.geoloc.geolocalizacao.controller;

import com.geoloc.geolocalizacao.controller.dtos.DadosCadastroUsuario;
import com.geoloc.geolocalizacao.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        var dto = usuarioService.cadastrar(dados);

        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(dto.idUsuario()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity listar() {
        var dto = usuarioService.listar();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var dto = usuarioService.detalhar(id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var dto = usuarioService.excluir(id);

        return ResponseEntity.ok(dto);
    }
}
