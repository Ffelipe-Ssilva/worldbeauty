package com.world.beauty.threads;

import javax.mail.PasswordAuthentication;

class SMTPAuthenticator extends javax.mail.Authenticator{
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication("quick0feet@gamil.com", "MutekiShogun!");
	}
}
