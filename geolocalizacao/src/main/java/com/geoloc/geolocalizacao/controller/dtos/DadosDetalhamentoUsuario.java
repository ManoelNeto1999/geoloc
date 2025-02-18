package com.geoloc.geolocalizacao.controller.dtos;

import com.geoloc.geolocalizacao.model.entities.Usuario;

import java.time.LocalDateTime;

public record DadosDetalhamentoUsuario(
        Long idUsuario,
        String nomeUsuario,
        String emailUsuario,
        String senhaUsuario,
        LocalDateTime dataHourCreated,
        LocalDateTime dataHourChanged,
        LocalDateTime dataHourDeleted) {
        public DadosDetalhamentoUsuario(Usuario usuario) {
            this(usuario.getIdUsuario() , usuario.getNomeUsuario(), usuario.getEmailUsuario(), usuario.getSenhaUsuario(), usuario.getDataHourCreated()
                    , usuario.getDataHourChanged(), usuario.getDataHourDeleted());
        }
}
