package com.world.beauty.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pedido_id")
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
		Pedidos other = (Pedidos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Long getServico_id() {
		return servico_id;
	}
	public void setServico_id(Long servico_id) {
		this.servico_id = servico_id;
	}
	/*@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")*/
	private Long cliente_id;
   /* @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "servico_id")*/
	private Long servico_id;
}
