package com.world.beauty.threads;

public class Carteiro implements Runnable{
	/*Informações, porta, login, senha, endereco envio, informações...
	 * 
	 * algo como String login = .....
	 * 
	 * */
	
	public void envairEmail() {
		/*toda a logica de envio de e-mail*/
	}

	/*run não retorna nada!!*/
	/*run não recebe nada!!*/
	@Override
	public void run() {
		envairEmail();
		// TODO Aqui vai o método que deve enviar o e-mail
		System.out.println("Aqui vai o método que deve enviar o e-mail");
	}
}