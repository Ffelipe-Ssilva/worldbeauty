package com.world.beauty.builder;

import org.springframework.stereotype.Service;

import com.world.beauty.dto.ClienteDto;
import com.world.beauty.entity.Cliente;

@Service
public class ClienteBuilder {
	private Cliente cliente;
	public Cliente buildCliente(ClienteDto clienteDto) {
		return Cliente.builder()
                .nome(clienteDto.get())
                .genero(clienteDto)
                .dtnasc(clienteDto)
                .telefone(clienteDto);
	}
}
