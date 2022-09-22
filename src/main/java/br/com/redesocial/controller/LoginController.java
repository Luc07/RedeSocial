package br.com.redesocial.controller;

import br.com.redesocial.entity.Login;
import br.com.redesocial.entity.Usuario;
import br.com.redesocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @PostMapping
    public ResponseEntity fazerLogin(@RequestBody Login login){
        Optional<Usuario> optional = usuarioRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());

        if(optional.isPresent()){
            return new ResponseEntity("Usuário: " + optional.get().getUsername() + " logado com sucesso!", HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }
}
