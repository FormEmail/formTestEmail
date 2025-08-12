package com.form.formTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendForm (String name, String phone, String email, String proyectNumber, String reason, String message){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("smpydmp@gmail.com");
        mail.setSubject("Nuevo mensaje de contacto");
        mail.setText("Nombre: " + name + "\n" + "Teléfono: " + phone + "\n" + "E-mail: " + email + "\n" + "Nº de proyecto: " + proyectNumber + "\n" + "Motivo de contacto: " + reason + "\n" + "Mensaje: " + message + "\n" + "Se ha leido y aceptado la politica de privacidad");
        mail.setFrom("emailform31@gmail.com");

        mailSender.send(mail);
    }
}
