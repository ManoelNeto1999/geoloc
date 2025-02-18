package com.geoloc.geolocalizacao.model.repository;

import com.geoloc.geolocalizacao.model.entities.Relato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RelatoRepository extends JpaRepository<Relato, Long> {

    List<Relato> findAllByDataHourDeletedNull();

}
