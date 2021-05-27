package com.world.beauty.threads;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

public class Carteiro implements Runnable {
	final String senderEmailID = "carteirodeemails@gmail.com";
	final String senderPassword = "12QWOP90";
	final String emailSMTPserver = "smtp.gmail.com";
	final String emailServerPort = "465";
	String receiverEmailID = null;
	String emailSubject = "Confirmação";
	String emailBody = "Cadastro de Cliente confirmado";
	
	public void envairEmail(String receiverEmailId,String emailSubject,String emailBody) {
		this.receiverEmailID=receiverEmailId;
		this.emailSubject=emailSubject;
		this.emailBody=emailBody;
		Properties properties=new Properties();
		properties.put("mail.smtp.user", senderEmailID);
		properties.put("mail.smtp.host", emailSMTPserver);
		properties.put("mail.smtp.post", emailServerPort);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.socketFactory.port",emailServerPort);
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback","false");
		SecurityManager security=System.getSecurityManager();
		try {
			javax.mail.Authenticator auth=new SMTPAuthenticator();
			Session session=Session.getInstance(properties,auth);
			MimeMessage msg=new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmailID));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
			Transport.send(msg);
			System.out.println("mensagem enviada com sucesso");
		}
		catch(Exception e) {
			System.out.println("-------erro-------");
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		envairEmail("ffelipe.ssilva02@gmail.com", "Confirmação", "Cadastro de Cliente confirmado");
		// TODO Aqui vai o método que deve enviar o e-mail
		System.out.println("Aqui vai o método que deve enviar o e-mail");
	}
}