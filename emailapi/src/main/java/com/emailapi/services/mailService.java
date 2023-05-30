package com.emailapi.services;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class mailService {

    public boolean sendEmail(String to, String text, String message) {

        boolean flag = false;

        String from = "apatan1015";
        //Smtp_properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");

//        String uname = "apatan1015";
        String password = "iulgkulwevjqcssb";
        //session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            Message msg = new MimeMessage(session);
            msg.setRecipient(jakarta.mail.Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from));
            msg.setSubject(text);
            msg.setText(message);
            Transport.send(msg);

            flag = true;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
