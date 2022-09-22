package br.com.redesocial.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPostagem;

    @Column( nullable = false, name = "id_usuario")
    private int idUsuario;

    @Column( nullable = false)
    private String titulo;

    @Column( nullable = false)
    private String texto;
}
