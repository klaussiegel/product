package edu.klaus.product.controller;

import edu.klaus.product.business.model.EmailDTO;
import edu.klaus.product.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping()
    public ResponseMessage sendEmail(@RequestBody EmailDTO emailDTO) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("klaussiegel2@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello Klaus \n Spring Boot Email");

        javaMailSender.send(msg);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Email was sended");
        return responseMessage;
    }
}
