package com.geoloc.geolocalizacao.controller.dtos;

import com.geoloc.geolocalizacao.model.entities.Usuario;

import java.time.LocalDateTime;

public record DadosCadastroUsuario(
        String nomeUsuario,
        String emailUsuario,
        String senhaUsuario,
        String senhaConfirmacao) {

}
