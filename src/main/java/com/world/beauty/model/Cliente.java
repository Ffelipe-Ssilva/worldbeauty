package com.world.beauty.model;

import javax.persistence.Entity;

@Entity
public class Cliente {
	private Long id;
	private String nome;
	private String telefone;
	private String dtnasc;
	private String genero;
}
