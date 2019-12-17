package enviando.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private String userName = "davidtestejava@gmail.com";
	private String password = "@Lenovo2020";

	@Test
	public void testeEmail() {

		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true"); // Autorização
			properties.put("mail.smtp.starttls", "true"); // Autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com"); // Servidor E-MAIL
			properties.put("mail.smtp.port", "465"); // Porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465"); // Expecifica a porta a ser conectado pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Classe socket de conexao ao SMTP

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, password);
				}
			});

			Address[] toUser = InternetAddress.parse("deh0_@hotmail.com, davidarruda762@gmail.com");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName)); // Quem está enviando
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Chegou o E-MAIL enviado com Java"); // Assunto do Email
			message.setText("Email do Java");

			Transport.send(message);

			System.out.println(session);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
