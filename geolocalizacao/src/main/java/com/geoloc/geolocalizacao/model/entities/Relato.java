package com.geoloc.geolocalizacao.model.entities;

import com.geoloc.geolocalizacao.controller.dtos.DadosAtualizacaoRelato;
import com.geoloc.geolocalizacao.controller.dtos.DadosCadastroRelato;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "TbRelatos")
@Entity(name = "Relato")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idRelato")
@Getter
@Setter
public class Relato {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelato;
    private Double latitude;
    private Double longitude;
    private String descricao;
    private String titulo;
    private Integer idCategoria;
    private LocalDateTime dataHourCreated;
    private LocalDateTime dataHourChanged;
    private LocalDateTime dataHourDeleted;

//    @ManyToOne
//    private Categoria categoria;

    public Relato(DadosCadastroRelato dados, Categoria categoriaEncontrada) {
        this.latitude = dados.latitude();
        this.longitude = dados.longitude();
        this.descricao = dados.descricao();
        this.titulo = dados.titulo();
        this.idCategoria = Math.toIntExact(categoriaEncontrada.getIdCategoria());
        this.dataHourCreated = LocalDateTime.now();
        this.dataHourChanged = null;
        this.dataHourDeleted = null;
    }

    public void atualizarInformacoes(DadosAtualizacaoRelato dados) {
        if (dados.latitude() != null) {
            this.latitude = dados.latitude();
        }
        if (dados.longitude() != null) {
            this.longitude = dados.longitude();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.idCategoria() != null) {
            this.idCategoria = dados.idCategoria();
        }

        this.dataHourChanged = LocalDateTime.now();

    }

    public void excluir() {
        this.dataHourDeleted = LocalDateTime.now();
    }
}
