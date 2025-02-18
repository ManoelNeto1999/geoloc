package com.geoloc.geolocalizacao.model.repository;

import com.geoloc.geolocalizacao.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNomeCategoria(String nomeCategoria);
}
