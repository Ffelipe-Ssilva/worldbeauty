package com.world.beauty;

public class ThreadEmail {
	  public static void main(String[] args) {
	        Heranca h = new Heranca();
	        //h.run();
	        // -------------------
	        Implementacao imp = new Implementacao();
	        Thread doJava = new Thread(imp);
	        doJava.start();
	        
	        System.out.println("era pra executar depois");

	 
}
