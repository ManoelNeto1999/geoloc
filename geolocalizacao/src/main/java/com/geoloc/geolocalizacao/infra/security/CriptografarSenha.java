package com.geoloc.geolocalizacao.infra.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriptografarSenha {
    public static String obterSenhaCriptoGrafada(String senha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encodedPassword = passwordEncoder.encode(senha);

        return encodedPassword;
    }
}
