package com.world.beauty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cliente_id")
	private Long id;
	@Column(nullable=false)
	private String nome;
	private String telefone;
	@Column(nullable=false)
	private String dtnasc;
	@Column(nullable=false)
	private String genero;
}
