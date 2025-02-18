package com.geoloc.geolocalizacao.controller.dtos;

import java.time.LocalDateTime;

public record DadosAtualizacaoRelato(Long idRelato,
                                     Double latitude,
                                     Double longitude,
                                     String descricao,
                                     String titulo,
                                     Integer idCategoria) {
}
