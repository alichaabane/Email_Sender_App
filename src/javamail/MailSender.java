package javamail;

/**
 *
 * @author AliChaabane
 */
public class MailSender {
    
    public static void main(String[] args) throws Exception{
        //il faut desactiver la propriété de votre compte gmail (si elle est desactiver) :https://myaccount.google.com/lesssecureapps
        //u must disable the security for less secure apps in ur gmail account to avoid problem of transport,via
        // this link : :https://myaccount.google.com/lesssecureapps
        
        //the argument for this method is the recipient address
        JavaMail.sendMail("********@gmail.com");
    }    
    
}
