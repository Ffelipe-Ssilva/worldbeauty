package com.world.beauty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.world.beauty.model.Cliente;
import com.world.beauty.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/falar")
	public String falar() {
		return "oi";
	}
	
	@PostMapping
	public Cliente adicionar(@RequestBody Cliente cliente) {
	return clienteRepository.save(cliente);
	}

}
