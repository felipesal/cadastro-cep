package com.felipesalles.apicadastrocep.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipesalles.apicadastrocep.domain.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer>{

	@Query("SELECT l from Loja l where l.cepInicial <= ?1 AND l.cepFinal >= ?1")
	public List<Loja> cepIsBetween(Long cep);
	
	@Query("SELECT l FROM Loja l WHERE l.cepInicial >= ?1 AND l.cepFinal <= ?2")
	public List<Loja> cepIntervalIsGreaterThenOtherCepInterval(Long cepInicial, Long cepFinal);
	
//	public List<Loja> findByCep
}