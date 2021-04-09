package com.world.beauty.resource;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.world.beauty.entity.Cliente;
import com.world.beauty.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/todos")
	public List<Cliente> listar() {
		return clienteRepository.findAlphabetic();
	}

	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		System.out.println(cliente.toString());
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/deletar/{id}")
	public List<Cliente> delete(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return clienteRepository.findAlphabetic();
	}

	@GetMapping("/encontrar/{genero}")
	public List<Cliente> findbyGenero(@PathVariable String genero) {
		return clienteRepository.findbyGenero(genero);
	}

}
