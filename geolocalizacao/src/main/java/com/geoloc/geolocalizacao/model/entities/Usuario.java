package com.geoloc.geolocalizacao.model.entities;

import com.geoloc.geolocalizacao.controller.dtos.DadosCadastroUsuario;
import com.geoloc.geolocalizacao.infra.security.CriptografarSenha;
import com.geoloc.geolocalizacao.infra.security.SecurityConfigurations;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "TbUsuarios")
@Entity(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
@Getter
@Setter
public class Usuario implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private LocalDateTime dataHourCreated;
    private LocalDateTime dataHourChanged;
    private LocalDateTime dataHourDeleted;

    public Usuario(DadosCadastroUsuario dados) {
        this.nomeUsuario = dados.nomeUsuario();
        this.emailUsuario = dados.emailUsuario();
        this.senhaUsuario = CriptografarSenha.obterSenhaCriptoGrafada(dados.senhaUsuario());
        this.dataHourCreated = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senhaUsuario;
    }

    @Override
    public String getUsername() {
        return emailUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void excluir() {
        this.dataHourDeleted = LocalDateTime.now();
    }
}
