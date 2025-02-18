package com.geoloc.geolocalizacao.controller.dtos;

import java.time.LocalDateTime;

public record DadosCadastroRelato(
        Double latitude,
        Double longitude,
        String descricao,
        String titulo,
        String nomeCategoria
        ) {
}
