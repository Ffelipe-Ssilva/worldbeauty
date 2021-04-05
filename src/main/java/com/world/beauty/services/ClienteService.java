package com.world.beauty.services;

import java.util.List;
import java.util.Optional;

import com.world.beauty.entity.Cliente;

public interface ClienteService {
	Cliente createCliente(Cliente cliente);
	
	List<Cliente> listCliente();
	
	Optional<Cliente> findById(Long id);
}
