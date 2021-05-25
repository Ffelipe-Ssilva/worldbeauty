package com.world.beauty.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.world.beauty.entity.Cliente;
import com.world.beauty.repository.ClienteRepository;
import com.world.beauty.threads.Carteiro;

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
		/*Aqui inicia o processo de cadastro de um cliente*/
		System.out.println(cliente.toString());
		clienteRepository.save(cliente);
		/*Aqui finaliza o processo de cadastro de um cliente*/
		
		/*Thread de aviso de cadastro realiado por e-mail*/
		Carteiro carteiro = new Carteiro(); // -> esta é a classe que contém toda a lógica do envio de e-mail
		//carteiro.envairEmail();
		
		Thread processoParalelo = new Thread(carteiro); // -> esta é a classe que vai de fato, des parar o processo em paralelo
		processoParalelo.start(); // o método start é o que de fato inicia a thread
		
		
		return "cadastro";
	}
	
	@PostMapping("/alterar")
	@ResponseStatus(HttpStatus.CREATED)
	public String mudar( Cliente cliente,Model model) {
		
		clienteRepository.save(cliente);
		model.addAttribute("clientes",cliente);
		List<Cliente> clientes=clienteRepository.findAlphabetic();
		return "listacli";
	}
	
	@RequestMapping(value="editar", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Cliente> cliente= clienteRepository.findById(id);
		if(cliente.get()==null) {
			return "listacli";
		}
		model.addAttribute("cliente",cliente.get());
		model.addAttribute("editar",true);
		return "cadastro";
		
		
	}
	

	@RequestMapping(value="deletar", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Long id, Model model)  {
		clienteRepository.deleteById(id);
		return "listacli";
	}

	@RequestMapping(value="encontrar", method = RequestMethod.GET)
	public String findByGenero(@RequestParam("opt") String genero, Model model) {
		List<Cliente> clientes = clienteRepository.findbyGenero(genero);
		model.addAttribute("clientes", clientes);
		return "listacligen";
	}
	
	@GetMapping(value = "/agendar")
	public String agendar(Model model) {
		List<Cliente> cliente=clienteRepository.findAlphabetic();
		model.addAttribute("clientes",cliente);
		return "agendar";
	}

	
}
