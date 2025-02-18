package com.geoloc.geolocalizacao.model.service;

import com.geoloc.geolocalizacao.controller.dtos.DadosCadastroUsuario;
import com.geoloc.geolocalizacao.controller.dtos.DadosDetalhamentoUsuario;
import com.geoloc.geolocalizacao.infra.exceptions.ValidacaoException;
import com.geoloc.geolocalizacao.model.entities.Usuario;
import com.geoloc.geolocalizacao.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public DadosDetalhamentoUsuario cadastrar(DadosCadastroUsuario dados) {

        var usuario = repository.findByEmailUsuario(dados.emailUsuario());

        if(!dados.senhaUsuario().equals(dados.senhaConfirmacao())) {
            throw new ValidacaoException("Senhas digitas não são correpondentes!");
        }
        if(usuario != null) {
            throw new ValidacaoException("Email já está em uso!");
        }

        var usuarioNovo = new Usuario(dados);

        repository.save(usuarioNovo);


        return new DadosDetalhamentoUsuario(usuarioNovo);
    }

    public List<DadosDetalhamentoUsuario> listar() {
        List<DadosDetalhamentoUsuario> listaUsuarios = repository.findAllByDataHourDeletedNull().stream()
                .map(u -> new DadosDetalhamentoUsuario(u)).collect(Collectors.toList());

        return listaUsuarios;
    }

    public DadosDetalhamentoUsuario detalhar(Long id) {
        var usuario = repository.getReferenceById(id);

        return new DadosDetalhamentoUsuario(usuario);
    }

    public DadosDetalhamentoUsuario excluir(Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.excluir();

        return new DadosDetalhamentoUsuario(usuario);
    }
}
