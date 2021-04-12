package com.world.beauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.world.beauty.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	@Query(value = "SELECT * FROM cliente WHERE cliente.genero = :genero ORDER BY nome", nativeQuery = true)
	List<Cliente> findbyGenero(@Param("genero") String genero);
	
	
	
	@Query(value = "SELECT * FROM cliente ORDER BY cliente.nome", nativeQuery = true)
	List<Cliente> findAlphabetic();


	
	
	
	
	

}
