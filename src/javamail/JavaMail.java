/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author AliChaabane
 */
public class JavaMail {
    public static void sendMail(String recepient) throws Exception{
        //preparing  to send email
        System.out.println("Preparation de l'envoi du message");
        Properties p = new Properties();

        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");

        String adr_gmail = "********@gmail.com"; //Your Email address
        String password = "***********";    //Your Password
        Session session = Session.getInstance(p, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(adr_gmail,password);
            }
        });
        Message msg = prepareMessage(session,adr_gmail,recepient);
        Transport.send(msg);
                //Your email sent successfully

            System.out.println("Votre message est envoyé avec succès ! ");
        }

        private static Message prepareMessage(Session session , String adr_gmail ,String recepient){
            try {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(adr_gmail));
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient) );
                msg.setSubject("Tester mon premier email envoyé depuis une app java ");

        // u can use the normal msg with the method setText            
        //String msg_a_envoyer = "Bonjour "+recepient.substring(0,recepient.indexOf("@"))+"!\n Comment vas-tu? ";
        //                msg.setText(msg_a_envoyer);
        
        // ** Or by using the html code with the method setContent
                 String CodeHTML = "<h1> Bonjour </h1>  <br/> JAVA_EMAIL_Sender APP";
                 msg.setContent(CodeHTML,"text/html");
                return msg;
            } catch (AddressException ex ) {
                Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
            }
             catch ( MessagingException ex ) {
                Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
            }      
            return null;
        }
    
}
