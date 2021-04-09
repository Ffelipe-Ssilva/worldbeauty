package com.world.beauty.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.world.beauty.dto.ServicoDto;
import com.world.beauty.entity.Servico;
import com.world.beauty.repository.ServicoRepository;

@RestController
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

}
