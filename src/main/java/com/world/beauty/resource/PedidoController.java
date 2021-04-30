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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/todos")
	public String listar(Model model) {
		
		List<Pedidos> pedido =pedidoRepository.findEach();
		model.addAttribute("pedidos",pedido);
		return "listapedido";
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/agendar")
	@ResponseStatus(HttpStatus.CREATED)
	public String agendar( PedidoCliente pedidoCliente,Model model) {
		
		System.out.println(pedidoCliente.getCliente_id());
		System.out.println(pedidoCliente.getServico_id());
		
		Pedidos pedido = new Pedidos();
		System.out.println(pedido);
		pedido.setCliente(clienteRepository.getOne(new Long(pedidoCliente.getCliente_id())));
		System.out.println(clienteRepository.getOne(new Long(pedidoCliente.getCliente_id())));
		pedido.setServico(servicoRepository.getOne(new Long(pedidoCliente.getServico_id())));
		System.out.println(servicoRepository.getOne(new Long(pedidoCliente.getServico_id())));
		System.out.println(pedido);
		pedidoRepository.save(pedido);
		List<Cliente> cliente=clienteRepository.findAlphabetic();
		model.addAttribute("clientes",cliente);
		return "agendar";
	}
	
	/*@GetMapping("/popgeral")
	public List<Pedidos> listarpopgeal() {
		return pedidoRepository.maiorProcuraGeral();
	}*/
	
	@RequestMapping(value="encontrar", method = RequestMethod.GET)
	public String findbyId(@RequestParam("id") Long id,Model model) {
		List<Pedidos> pedidos= pedidoRepository.findEachCliente(id);
		model.addAttribute("pedidos",pedidos);
		return "listapedido";
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
