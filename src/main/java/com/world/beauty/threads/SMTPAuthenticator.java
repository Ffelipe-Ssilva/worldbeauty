package com.world.beauty.threads;

import javax.mail.PasswordAuthentication;

class SMTPAuthenticator extends javax.mail.Authenticator{
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication("carteirodeemails@gmail.com", "12QWOP90");
	}
}
