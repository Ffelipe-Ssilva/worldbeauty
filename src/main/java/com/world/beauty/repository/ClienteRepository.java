package com.world.beauty.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.world.beauty.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	@Query(value = "SELECT * FROM cliente WHERE cliente.status = :genero", nativeQuery = true)
	Collection<Cliente> findbyGenero(String genero);
	
	
	
	@Query(value = "SELECT * FROM cliente ORDER BY nome", nativeQuery = true)
	List<Cliente> findAlphabetic();
	
	
	@Query(value = "DELETE FROM cliente where cliente_id=:id", nativeQuery = true)
	Cliente deleteCliente(Long id);

}
