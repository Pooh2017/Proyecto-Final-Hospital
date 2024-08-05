/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;


public class EmailSender {

    public static boolean sendEmail(String to, String subject, String body, String attachmentPath) {
        final String from = "migueltopicosavanzados@gmail.com"; // Cambia esto por tu correo electrónico
        final String password = "4132mzJ9"; // Cambia esto por tu contraseña

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar TLS
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Puerto para TLS

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            if (attachmentPath != null && !attachmentPath.isEmpty()) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(attachmentPath);
                multipart.addBodyPart(attachmentPart);
            }

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Correo enviado exitosamente.");
            return true; // Indica éxito

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo.");
            return false; // Indica fallo
        }
    }
}