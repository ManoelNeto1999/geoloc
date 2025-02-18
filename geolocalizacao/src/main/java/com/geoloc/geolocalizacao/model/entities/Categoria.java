package com.geoloc.geolocalizacao.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "TbCategorias")
@Entity(name = "Categoria")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idCategoria")
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    private String nomeCategoria;
    private LocalDateTime dataHourCreated;
    private LocalDateTime dataHourChanged;
    private LocalDateTime dataHourDeleted;

//    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToOne(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    Relato relatos;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public LocalDateTime getDataHourCreated() {
        return dataHourCreated;
    }

    public void setDataHourCreated(LocalDateTime dataHourCreated) {
        this.dataHourCreated = dataHourCreated;
    }

    public LocalDateTime getDataHourChanged() {
        return dataHourChanged;
    }

    public void setDataHourChanged(LocalDateTime dataHourChanged) {
        this.dataHourChanged = dataHourChanged;
    }

    public LocalDateTime getDataHourDeleted() {
        return dataHourDeleted;
    }

    public void setDataHourDeleted(LocalDateTime dataHourDeleted) {
        this.dataHourDeleted = dataHourDeleted;
    }

//    public Relato getRelatos() {
//        return relatos;
//    }
//
//    public void setRelatos(Relato relatos) {
//        this.relatos = relatos;
//    }

    //    public List<Relato> getRelatos() {
//        return relatos;
//    }
//
//    public void setRelatos(List<Relato> relatos) {
//        relatos.forEach(r -> r.setCategoria(this));
//        this.relatos = relatos;
//    }
}
