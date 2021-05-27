package com.world.beauty.threads;

import java.util.Properties;

/* Nesta classe estão as informações necessárias para conectar a um serviço de e-mail.
 * Algumas delas são:
 * Remetente (endereço de e-mail que irá enviar o e-mail)
 * Nome do remetente (nome que aperece como identificado, quando o destinatário abre o e-mail)
 * Destinatário
 * Usuario SMTP (conta que deve logar no serviço de e-mail)
 * Senha da conta
 * IP ou Hostname da servidor de e-mail
 * Porta (número da porta, onde o serviço SMTP está em execução)*/

public class Configuracao {

	private String remetente;
	private String remetente_nome;
	private String destinatario;
	private String usuario_smtp;
	private String senha;
	private String hostname;
	private String porta;

	/*
	 * Neste, e apenas para fins de aprendizagem, as informações que serão usadas
	 * para conectar no serviço de e-mail deverão ser passadas no construtor
	 */
	public Configuracao(String remetente, String remetente_nome, String destinatario, String usuario_smtp, String senha,
			String hostname, String porta) {

		this.remetente = remetente;
		this.remetente_nome = remetente_nome;
		this.destinatario = destinatario;
		this.usuario_smtp = usuario_smtp;
		this.senha = senha;
		this.hostname = hostname;
		this.porta = porta;
	}

	/*
	 * IMPORTANTE! Neste exemplo, estamos usando a biblioteca java mail sender. Ela
	 * trabalha com um objeto do pacote java.util, chamado de properties
	 * (propriedades em inglês). Este objeto é usado para encapsular as
	 * configurações de conexão. Abaixo, foi desenvolvido um método para fazer este
	 * procedimento, com os dados fornecidos
	 */

	public Properties obterPropriedades() {
		// Iniciando o objeto de propriedades:
		Properties propriedades = System.getProperties();
		// Inserindo a propriedade que informa qual o tipo de protocolo será usado na
		// conexão, neste caso o SMTP:
		propriedades.put("mail.transport.protocol", "smtp");
		// Inserindo a propriedade que informa qual a porta do serviço:
		propriedades.put("mail.smtp.port", this.porta); // (this.porta é a referência a variável porta, que foi
														// preenchida na linha 38)
		// Inserindo propriedades de autenticação:
		propriedades.put("mail.smtp.auth", "true");
		propriedades.put("mail.smtp.auth.login.disable", "true");
		propriedades.put("mail.smtp.starttls.enable", "true");
		propriedades.put("mail.smtp.starttls.required", "true");
		propriedades.put("mail.smtp.ssl.enable", "true");
		/*
		 * A explicação do que são cada uma das propriedades de autenticação não foi
		 * colocada aqui. Isto para não deixar os comentários do código muito longos.
		 * Mas é possível buscar por estas informações facilmente em tutoriais
		 */
		return propriedades;
	}

	public String getRemetente() {
		return remetente;
	}

	public String getRemetente_nome() {
		return remetente_nome;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public String getUsuario_smtp() {
		return usuario_smtp;
	}

	public String getSenha() {
		return senha;
	}

	public String getHostname() {
		return hostname;
	}

	public String getPorta() {
		return porta;
	}
}
