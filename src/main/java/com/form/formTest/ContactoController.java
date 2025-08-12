package com.form.formTest;

import io.micrometer.common.util.StringUtils;
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
        String name = datos.get("name");
        String phone = "No ha añadido el teléfono de contacto";
        if (!StringUtils.isEmpty(datos.get("phone"))) {
            phone = datos.get("phone");
        }

        String email = "No ha añadido el email de contacto";
        if (!StringUtils.isEmpty(datos.get("email"))) {
            email = datos.get("email");
        }

        String proyectNumber = "No tiene numero de proyecto";
        if (!StringUtils.isEmpty(datos.get("proyectNumber"))) {
            proyectNumber = datos.get("proyectNumber");
        }
        String reason = datos.get("reason");
        String message = datos.get("message");

        System.out.println("Nombre: " + name);
        System.out.println("phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("proyectNumber: " + proyectNumber);
        System.out.println("reason: " + reason);
        System.out.println("Mensaje: " + message);
        System.out.println("Ha leido y aceptado la politica de privacidad");

        emailService.sendForm(name, phone, email, proyectNumber, reason, message);

        return ResponseEntity.ok("Datos recibidos");
    }
}

