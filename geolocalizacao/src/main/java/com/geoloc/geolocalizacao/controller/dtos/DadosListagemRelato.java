package com.geoloc.geolocalizacao.controller.dtos;

import com.geoloc.geolocalizacao.model.entities.Relato;

import java.time.LocalDateTime;

public record DadosListagemRelato(Long idRelato,
                                  Double latitude,
                                  Double longitude,
                                  String descricao,
                                  String titulo,
                                  Integer idCategoria,
                                  LocalDateTime dataHourCreated,
                                  LocalDateTime dataHourChanged,
                                  LocalDateTime dataHourDeleted) {

    public DadosListagemRelato(Relato relato) {
        this(relato.getIdRelato(), relato.getLatitude(), relato.getLongitude(),
                relato.getDescricao(), relato.getTitulo(), relato.getIdCategoria(),
                relato.getDataHourCreated(), relato.getDataHourChanged(), relato.getDataHourDeleted());
    }

}
