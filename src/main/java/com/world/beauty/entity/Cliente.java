package com.world.beauty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
	
	public Cliente(Long id, String nome, String telefone, String dtnasc, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.dtnasc = dtnasc;
		this.genero = genero;
	}
	public Cliente() {
		
	}
	public Cliente(String nome, String telefone, String dtnasc, String genero) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.dtnasc = dtnasc;
		this.genero = genero;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cliente_id")
	private Long id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Column()
	private String nome;
	@Column()
	private String telefone;
	@Column()
	private String dtnasc;
	@Column()
	private String genero;
}
