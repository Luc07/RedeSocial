package br.com.redesocial.controller;

import br.com.redesocial.entity.Postagem;
import br.com.redesocial.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
    @Autowired
    PostagemRepository postagemRepository;

    @GetMapping
    public ResponseEntity<List<Postagem>> getPostagens(){
        return new ResponseEntity(postagemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getPostagem(@PathVariable int id){
        Optional<Postagem> optional = postagemRepository.findById(id);

        if(optional.isPresent()) {
            return new ResponseEntity(postagemRepository.findById(id), HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity addPostagem(@RequestBody Postagem postagem) {
        try{
            return new ResponseEntity(postagemRepository.save(postagem), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity("Não foi possivel cadastrar o usuário", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePostagem(@PathVariable int id){
        try{
            postagemRepository.deleteById(id);
            return new ResponseEntity("Usuario Removido com sucesso!",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity("Não existe usuário com o id: " + id,HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public ResponseEntity putPostagem(@RequestBody Postagem postagem){
        Optional<Postagem> optionalPostagem = postagemRepository.findById(postagem.getIdPostagem());
        if(optionalPostagem.isPresent()){
            return new ResponseEntity(postagemRepository.save(postagem), HttpStatus.OK);
        }
        return new ResponseEntity("Não foi possivel encontrar o usuário para modificar", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("verMinhasPostagens/{idUsuario}")
    public ResponseEntity<List<Postagem>> vizualizarPostagensDoUsuario(@PathVariable int idUsuario){
        return new ResponseEntity(postagemRepository.findAllByIdUsuario(idUsuario), HttpStatus.OK);
    }
}
