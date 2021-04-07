package com.world.beauty.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.world.beauty.entity.Servico;
import com.world.beauty.repository.ServicoRepository;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	private ServicoRepository servicoRepository;
	@GetMapping("/todos")
	public List<Servico> listar() {
		return servicoRepository.findAlphabetic();
	}
}
