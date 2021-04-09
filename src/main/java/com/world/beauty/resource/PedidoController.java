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

import com.world.beauty.entity.Cliente;
import com.world.beauty.entity.Pedidos;
import com.world.beauty.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/todos")
	public List<Pedidos> listar() {
		return pedidoRepository.findAlphabetic();
	}
	
	@PostMapping("/marcar")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedidos adicionar(@RequestBody Pedidos pedidos) {
		System.out.println(pedidos.toString());
		return pedidoRepository.save(pedidos);
	}
	
	@GetMapping("/popgeral")
	public List<Pedidos> listarpopgeal() {
		return pedidoRepository.maiorProcuraGeral();
	}
}