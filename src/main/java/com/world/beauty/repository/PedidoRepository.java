package com.world.beauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.world.beauty.entity.Pedidos;
import com.world.beauty.entity.Servico;
import com.world.beauty.entity.Transfer;


@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	@Query(value = "SELECT pedidos.pedido_id,servico.servico_id,servico.nome,cliente.cliente_id, cliente.nome FROM pedidos INNER JOIN cliente ON pedidos.cliente_id = cliente.cliente_id INNER JOIN servico ON "
			+ "pedidos.servico_id = servico.servico_id GROUP BY cliente.cliente_id,servico.nome,pedidos.pedido_id,servico.servico_id ORDER BY cliente.nome", nativeQuery = true)
	List<Pedidos> findEach();
	
	@Query(value = "SELECT pedidos.pedido_id,servico.servico_id,servico.nome,cliente.cliente_id, cliente.nome FROM pedidos INNER JOIN cliente ON pedidos.cliente_id = cliente.cliente_id INNER JOIN servico ON "
			+ "pedidos.servico_id = servico.servico_id WHERE cliente.cliente_id= :id GROUP BY cliente.cliente_id,servico.nome,pedidos.pedido_id,servico.servico_id", nativeQuery = true)
	List<Pedidos> findEachCliente(@Param("id") Long id);
	
	@Query(value = "SELECT count(servico.nome) as frequencia,servico.nome FROM pedidos INNER JOIN servico ON pedidos.servico_id = servico.servico_id GROUP BY servico.nome ORDER BY frequencia desc", nativeQuery = true)
	List<Pedidos> maiorProcura();
	
	@Query(value = "SELECT count(servico.nome) as frequencia,servico.nome,servico.servico_id FROM pedidos INNER JOIN cliente ON pedidos.cliente_id = cliente.cliente_id INNER JOIN servico ON pedidos.servico_id = "
			+ "servico.servico_id WHERE genero=:genero GROUP BY servico.nome,servico.servico_id ORDER BY frequencia desc", nativeQuery = true)
	List<Pedidos> maiorProcuraGenero(@Param("genero") String genero);
	
	

	
}
