package br.com.redesocial.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "usuario")
@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String username;
}