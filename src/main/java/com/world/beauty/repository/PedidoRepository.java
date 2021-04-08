package com.world.beauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.world.beauty.entity.Pedidos;


@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	@Query(value = "SELECT * FROM pedidos", nativeQuery = true)
	List<Pedidos> findAlphabetic();
	
	@Query(value = "SELECT count(servico.nome) as frequencia, servico.nome FROM pedidos,cliente,servico GROUP BY servico.nome ORDER BY frequencia desc", nativeQuery = true)
	List<Pedidos> maiorProcuraGeral();
}
