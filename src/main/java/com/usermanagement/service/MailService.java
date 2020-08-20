package com.usermanagement.service;

import com.usermanagement.dto.UserDto;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailService {

    String host="smtp.gmail.com";
    String port="587";
    String senderMail="kalyanirane19@gmail.com";
    String password="kalyani@143";


    public String sendEmail(UserDto userDto) {

        if(userDto==null)
            return "User Not Found";

        Properties properties=new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }
        };

        try {
            Session session = Session.getInstance(properties, auth);

            Message message = new MimeMessage(session);

            String subject = "Password Recovery Request";

            message.setFrom(new InternetAddress(senderMail));
            InternetAddress[] toAddresses = { new InternetAddress(userDto.email) };
            message.setRecipients(Message.RecipientType.TO, toAddresses);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(getEmailContent(userDto.name,userDto.email,userDto.password));

            Transport.send(message);
            return "Reset Password Link Has Been Sent";
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "Reset Password Link Has Been Not Sent";
    }

    public String getEmailContent(String name, String mail, String password) {
        return "Welcome " + name + "\n\nWe received an password recovery request on " +
                "User Management for " + mail +
                "\nYour password is " + password;
    }

}
