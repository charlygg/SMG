package com.ixanaui.comunication;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendEmail {
	
	

	public SendEmail() {
	
		

	}

	public void sendMessage( String email, String mensaje,String subject) {

		
		final String username = "donotreply2@bolsarosa.com";
		final String password = "BolsaRosa2014_";
	

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.bolsarosa.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("donotreply2@bolsarosa.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));

		/*
		 * carga el mensaje
		 */
				System.out.println("mensaje->email " + email);
				message.setSubject(subject);
				message.setContent(mensaje, "text/html");

			Transport.send(message);

			System.out.println("Done");
		

		} catch (MessagingException e) {
			System.out.println(e);
			
		}
		
	}
}
