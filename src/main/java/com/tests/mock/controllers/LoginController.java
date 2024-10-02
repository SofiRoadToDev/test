package com.tests.mock.controllers;

import com.tests.mock.entities.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
@AllArgsConstructor
public class LoginController {

    private Environment environment;

    @PostMapping()
    public ResponseEntity<?>login(@RequestBody Usuario usuario){
        String systemUser = environment.getProperty("spring.security.user.name");
        String systemUserPassword = environment.getProperty("spring.security.user.password");

        if(!systemUser.equals(usuario.getUsername()) || !systemUserPassword.equals(usuario.getPassword())){
            return ResponseEntity.status(404).body("Credenciales incorrectas");
        }

        return ResponseEntity.ok("Bienvenido");
    }
}
