package com.world.beauty.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.world.beauty.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	@Query(value = "SELECT * FROM cliente WHERE cliente.genero = :genero ORDER BY nome", nativeQuery = true)
	List<Cliente> findbyGenero(@Param("genero") String genero);
	
	
	
	@Query(value = "SELECT * FROM cliente ORDER BY nome", nativeQuery = true)
	List<Cliente> findAlphabetic();
	
	/*@Modifying
	@Query(value = "DELETE FROM public.cliente WHERE cliente.cliente_id = :id")
	List<> deleteCliente(@Param("id") Long id);*/
	
	
	

}
