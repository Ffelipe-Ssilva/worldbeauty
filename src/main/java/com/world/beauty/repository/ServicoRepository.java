package com.world.beauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.world.beauty.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	@Query(value = "SELECT * FROM servico ORDER BY nome", nativeQuery = true)
	List<Servico> findAlphabetic();
}
