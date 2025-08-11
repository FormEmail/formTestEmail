package com.form.formTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ContactoController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/contacto")
    public ResponseEntity<String> recibirFormulario(@RequestBody Map<String, String> datos) {
        String name = datos.get("nombre");
        String email = datos.get("email");
        String text = datos.get("mensaje");

        System.out.println("Nombre: " + name);
        System.out.println("Email: " + email);
        System.out.println("Mensaje: " + text);

        emailService.sendForm(name, email, text);

        return ResponseEntity.ok("Datos recibidos");
    }
}

