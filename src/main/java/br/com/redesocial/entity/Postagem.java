package br.com.redesocial.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Postagem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_postagem;

    @Column( nullable = false)
    private int id_usuario;

    @Column( nullable = false)
    private String titulo;

    @Column( nullable = false)
    private String texto;
}
