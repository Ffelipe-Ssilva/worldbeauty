package com.world.beauty.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
//
	@GetMapping("/todos")
	public String listar(Model model){
		List<Cliente> cliente=clienteRepository.findAlphabetic();
		model.addAttribute("clientes",cliente);
		return "listacli";
	}//

	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public String update( Cliente cliente) {
		System.out.println(cliente.toString());
		clienteRepository.save(cliente);
		return "cadastro";
	}

	@RequestMapping(value="encontrar", method = RequestMethod.DELETE)
	public String delete(@RequestParam("opt") Long id, Model model)  {
		clienteRepository.deleteById(id);
		return clienteRepository.findAlphabetic();
	}

	@RequestMapping(value="encontrar", method = RequestMethod.GET)
	public String findByGenero(@RequestParam("opt") String genero, Model model) {
		List<Cliente> clientes = clienteRepository.findbyGenero(genero);
		model.addAttribute("clientes", clientes);
		return "listacligen";
	}
	
	

	
}
