package cin.ufpe.aps.AluCar.subsistemas;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.util.Properties;



@Service
public class GoogleEmailService implements EmailService {

    //private final Dotenv dotenv = Dotenv.configure().filename(".env").load();
    //private final String remetente = dotenv.get("REMETENTE"); // Substitua pelo seu e-mail do Gmail
    //private final String senha = dotenv.get("SENHA"); // Substitua pela senha do seu e-mail do Gmail

    private final String assunto = "[AluCar] - Reserva de Veículo";
    private final String corpo = "Você realizou uma reserva com sucesso";

    @Override
    public void enviarEmail(String destinatario) {
        System.out.println("E-mail enviado para: " + destinatario);
    }
    // @Override
    // public void enviarEmail(String destinatario) {

    //     Properties propriedades = new Properties();
    //     propriedades.put("mail.smtp.auth", "true");
    //     propriedades.put("mail.smtp.starttls.enable", "true");
    //     propriedades.put("mail.smtp.host", "smtp.gmail.com");
    //     propriedades.put("mail.smtp.port", "587");

    //     Session session = Session.getInstance(propriedades,
    //             new Authenticator() {
    //                 protected PasswordAuthentication getPasswordAuthentication() {
    //                     return new PasswordAuthentication(remetente, senha);
    //                 }
    //             });

    //     try {
    //         Message message = new MimeMessage(session);
    //         message.setFrom(new InternetAddress(remetente));
    //         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
    //         message.setSubject(assunto);
    //         message.setText(corpo);

    //         Transport.send(message);

    //         System.out.println("E-mail enviado para: " + destinatario);

    //     } catch (MessagingException e) {
    //         throw new RuntimeException(e);
    //     }
    // }
}
