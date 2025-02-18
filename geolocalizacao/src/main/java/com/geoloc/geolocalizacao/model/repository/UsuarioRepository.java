package com.geoloc.geolocalizacao.model.repository;

import com.geoloc.geolocalizacao.model.entities.Relato;
import com.geoloc.geolocalizacao.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmailUsuario(String login);

    List<Usuario> findAllByDataHourDeletedNull();
}
