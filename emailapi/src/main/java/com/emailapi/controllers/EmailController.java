package com.emailapi.controllers;

import com.emailapi.model.emailModel;
import com.emailapi.services.mailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private mailService mail;

    @GetMapping(value = "/greet", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Hello test teh Api...!", HttpStatus.OK);
    }

    @PostMapping(value = "/sendmail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendEmail(@RequestBody emailModel email) {
        boolean b = this.mail.sendEmail(email.getTo(),email.getSubject(), email.getText());
        if(b) {
            return  ResponseEntity.ok("Email was sent..!!");
        }else {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
