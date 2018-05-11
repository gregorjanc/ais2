package paketi;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail {
	

	public void posljiMail(String prejemnik, String sporocilo) {

		final String username = "actualgregor@gmail.com";
		final String password = "gregor18";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("actualgregor@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(prejemnik));
			message.setSubject("Fitnes");
			message.setText(sporocilo);

			Transport.send(message);

			System.out.println("Mail-----------------------------------------------------------------------------------------");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
