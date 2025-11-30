package edu.unl.cc.ordermaster.domain;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class Gmail {
    private static String email = "arevalofranz2007@gmail.com";
    private static String pass = "vaek lehp prqv bogs";


    private Session session;

    private void propiedadesEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", email);
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        props.setProperty("mail.smtp.auth", "true");

        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication (){
                return new PasswordAuthentication(email, pass);
            }
        };
        session = Session.getInstance(props, auth);
    }

    public void enviarEmail(String emailto, LocalDate fecha,String subject, String content) {
        propiedadesEmail();
        try {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(email));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(emailto));
            mensaje.setSubject(subject);
            mensaje.setSentDate(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            MimeBodyPart cuerpoMensaje = new MimeBodyPart();
            cuerpoMensaje.setContent(content, "text/html;charset=utf-8");
            Multipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(cuerpoMensaje);
            MimeBodyPart adjunto = new MimeBodyPart();
            adjunto.attachFile("D:\\\\Usuarios\\\\Franz\\\\Documentacion\\\\reporte.pdf");
            multiparte.addBodyPart(adjunto);
            mensaje.setContent(multiparte);
            Transport.send(mensaje);
        } catch (AddressException e) {
            System.out.println("error AddressException: "+e.getMessage());
        } catch (MessagingException ex){
            System.out.println("error MessagingException: "+ex.getMessage());
        } catch (IOException e) {
            System.out.println("error IOException: "+e.getMessage());
        }
    }
}
