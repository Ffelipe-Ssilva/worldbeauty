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
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	@Query(value = "SELECT * FROM servico ORDER BY nome", nativeQuery = true)
	List<Servico> findAlphabetic();
	
	
	@Query(value = "SELECT count(servico.nome) as frequencia,servico.nome,servico.servico_id FROM servico INNER JOIN pedidos ON pedidos.servico_id = servico.servico_id GROUP BY servico.nome,servico.servico_id ORDER BY frequencia desc", nativeQuery = true)
	List<Servico> maiorProcura();
	
	@Query(value = "SELECT count(servico.nome) as frequencia,servico.nome,servico.servico_id FROM pedidos INNER JOIN servico ON pedidos.servico_id = servico.servico_id INNER JOIN cliente ON cliente.cliente_id=pedidos.cliente_id WHERE genero=:genero GROUP BY servico.nome,servico.servico_id ORDER BY frequencia desc", nativeQuery = true)
	List<Servico> maiorProcuraGenero(@Param("genero") String genero);
}
