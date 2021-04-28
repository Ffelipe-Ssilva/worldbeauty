package com.world.beauty.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.world.beauty.dto.ClienteDto;
import com.world.beauty.entity.Cliente;
import com.world.beauty.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
//
	@GetMapping("/todos")
	public List<Cliente> listar(){
		return clienteRepository.findAlphabetic();
	}//

	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update( Cliente cliente) {
		System.out.println(cliente.toString());
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/deletar/{id}")//
	public List<Cliente> delete(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return clienteRepository.findAlphabetic();
	}

	@RequestMapping(value="encontrar", method = RequestMethod.GET)
	public List<Cliente> findbyGenero(@RequestParam("opt") String genero) {
		return clienteRepository.findbyGenero(genero);
	}
	
	

	
}
