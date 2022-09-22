package br.com.redesocial.repository;

import br.com.redesocial.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
    List<Postagem> findAllByIdUsuario(int idUsuario);
}
