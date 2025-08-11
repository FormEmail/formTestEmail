package com.form.formTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendForm (String name, String email, String text){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("smpydmp@gmail.com");
        mail.setSubject("Nuevo mensaje de contacto");
        mail.setText("Nombre: " + name + "\n" + "E-mail: " + email + "\n" + "Mensaje: " + text);
        mail.setFrom("emailform31@gmail.com");

        mailSender.send(mail);
    }
}
