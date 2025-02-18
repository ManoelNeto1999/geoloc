package com.geoloc.geolocalizacao.model.service;

import com.geoloc.geolocalizacao.controller.dtos.DadosAtualizacaoRelato;
import com.geoloc.geolocalizacao.controller.dtos.DadosCadastroRelato;
import com.geoloc.geolocalizacao.controller.dtos.DadosDetalhamentoRelato;
import com.geoloc.geolocalizacao.controller.dtos.DadosListagemRelato;
import com.geoloc.geolocalizacao.model.entities.Relato;
import com.geoloc.geolocalizacao.model.repository.CategoriaRepository;
import com.geoloc.geolocalizacao.model.repository.RelatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatoService {

    private CategoriaRepository categoriaRepository;
    private RelatoRepository relatoRepository;

    @Autowired
    public RelatoService(CategoriaRepository categoriaRepository, RelatoRepository relatoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.relatoRepository = relatoRepository;
    }

    public DadosDetalhamentoRelato cadastrar(DadosCadastroRelato dados) {
        var categoria = categoriaRepository.findByNomeCategoria(dados.nomeCategoria());
        var categoriaEncontrada = categoria.get();
        Relato relato = new Relato(dados, categoriaEncontrada);
        relatoRepository.save(relato);

        return new DadosDetalhamentoRelato(relato);
    }

    public DadosDetalhamentoRelato detalhar(Long id) {
        var relato = relatoRepository.getReferenceById(id);

        return new DadosDetalhamentoRelato(relato);
    }

    public List<DadosListagemRelato> listar() {
        List<DadosListagemRelato> dados = relatoRepository.findAllByDataHourDeletedNull().stream()
                .map(r -> new DadosListagemRelato(r)).collect(Collectors.toList());

        return dados;
    }

    public DadosDetalhamentoRelato atualizar(DadosAtualizacaoRelato dados) {
        var relato = relatoRepository.getReferenceById(dados.idRelato());
        relato.atualizarInformacoes(dados);

        return new DadosDetalhamentoRelato(relato);
    }

    public DadosDetalhamentoRelato excluir(Long id) {
        var relato = relatoRepository.getReferenceById(id);
        relato.excluir();

        return new DadosDetalhamentoRelato(relato);
    }

}
