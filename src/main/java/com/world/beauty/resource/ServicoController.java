package com.world.beauty.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.world.beauty.dto.ServicoDto;
import com.world.beauty.entity.Cliente;
import com.world.beauty.entity.Pedidos;
import com.world.beauty.entity.Servico;
import com.world.beauty.entity.Transfer;
import com.world.beauty.repository.PedidoRepository;
import com.world.beauty.repository.ServicoRepository;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;

	@GetMapping("/todos")
	public List<Servico> listar() {
		return servicoRepository.findAlphabetic();
	}

	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public Servico adicionar(@RequestBody Servico servico) {
		return servicoRepository.save(servico);
	}
	
	@RequestMapping(value="populargen", method = RequestMethod.GET)
	public String findPopularservgen(@RequestParam("opt") String genero,Model model) {
		List<Servico> servico = servicoRepository.maiorProcuraGenero(genero);
		model.addAttribute("servicos", servico);
		return "servpopgen";
	}
	
	
	
	/*@GetMapping("/popular")
	public List<Servico> findPopular() {
		return servicoRepository.maiorProcura();
	}*/
	
	@RequestMapping(value="popular", method = RequestMethod.GET)
	public String findPopularserv(Model model) {
		List<Servico> servico = servicoRepository.maiorProcura();
		model.addAttribute("servicos", servico);
		System.out.println(servico);
		return "servpop";
	}

}
