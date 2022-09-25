package br.com.redesocial.controller;

import br.com.redesocial.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.redesocial.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getUsuario(@PathVariable int id){
        Optional<Usuario> optional = usuarioRepository.findById(id);

        if(optional.isPresent()) {
            return new ResponseEntity(usuarioRepository.findById(id), HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity addUsuario(@RequestBody Usuario usuario) {
        try{
            return new ResponseEntity(usuarioRepository.save(usuario), HttpStatus.CREATED);
        }catch(Exception e){
           return new ResponseEntity("Não foi possivel cadastrar o usuário", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUsuario(@PathVariable int id){
        try{
            usuarioRepository.deleteById(id);
            return new ResponseEntity("Usuario Removido com sucesso!",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity("Não existe usuário com o id: " + id,HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public ResponseEntity putUsuario(@RequestBody Usuario usuario){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getId());
        if(optionalUsuario.isPresent()){
            return new ResponseEntity(usuarioRepository.save(usuario), HttpStatus.OK);
        }
        return new ResponseEntity("Não foi possivel encontrar o usuário para modificar", HttpStatus.BAD_REQUEST);
    }
}
