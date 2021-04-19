package com.world.beauty.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.world.beauty.datahandle.PedidoCliente;
import com.world.beauty.entity.Cliente;
import com.world.beauty.entity.Pedidos;
import com.world.beauty.entity.Servico;
import com.world.beauty.entity.Transfer;
import com.world.beauty.repository.ClienteRepository;
import com.world.beauty.repository.PedidoRepository;
import com.world.beauty.repository.ServicoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/todos")
	public List<Pedidos> listar() {
		return pedidoRepository.findEach();
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/agendar")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedidos agendar(@RequestBody PedidoCliente pedidoCliente) {
		
		System.out.println(pedidoCliente.getCliente_id());
		System.out.println(pedidoCliente.getServico_id());
		
		Pedidos pedido = new Pedidos();
		System.out.println(pedido);
		pedido.setCliente(clienteRepository.getOne(new Long(pedidoCliente.getCliente_id())));
		System.out.println(clienteRepository.getOne(new Long(pedidoCliente.getCliente_id())));
		pedido.setServico(servicoRepository.getOne(new Long(pedidoCliente.getServico_id())));
		System.out.println(servicoRepository.getOne(new Long(pedidoCliente.getServico_id())));
		System.out.println(pedido);
		return pedidoRepository.save(pedido);
	}
	
	/*@GetMapping("/popgeral")
	public List<Pedidos> listarpopgeal() {
		return pedidoRepository.maiorProcuraGeral();
	}*/
	
	@GetMapping("/encontrar/{id}")
	public List<Pedidos> findbyId(@PathVariable Long id) {
		System.out.println(id);
		System.out.println(pedidoRepository.findEachCliente(id));
		return pedidoRepository.findEachCliente(id);
	}
	
	@GetMapping("/populargen/{genero}")
	public List<Pedidos> findbyGenero(@PathVariable String genero) {
		System.out.println(genero);
		System.out.println(pedidoRepository.maiorProcuraGenero(genero));
		return pedidoRepository.maiorProcuraGenero(genero);
	}
	
	@GetMapping("/popular")
	public List<Pedidos> findPopular() {
		System.out.println(pedidoRepository.maiorProcura());
		return pedidoRepository.maiorProcura();
	}
}
