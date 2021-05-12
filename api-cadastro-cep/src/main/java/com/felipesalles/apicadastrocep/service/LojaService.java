package com.felipesalles.apicadastrocep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesalles.apicadastrocep.domain.Loja;
import com.felipesalles.apicadastrocep.repositories.LojaRepository;
import com.felipesalles.apicadastrocep.service.exceptions.BusinessException;
import com.felipesalles.apicadastrocep.service.exceptions.ObjectNotFoundException;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public Loja insert(Loja loja) {
		if(cepIntervalIsAvailable(loja)) {
			return lojaRepository.save(loja);
		}
		
		throw new BusinessException("Faixa de CEP já cadastrada");
	}
	
	public List<Loja> findAll(){
		return lojaRepository.findAll();
	}

	public Loja update(Integer id, Loja loja) {
		if(cepIntervalIsAvailable(loja)) {
			var paramLoja = find(id);
			paramLoja.get().setNome(loja.getNome());
			paramLoja.get().setCepInicial(loja.getCepInicial());
			paramLoja.get().setCepFinal(loja.getCepFinal());
			
			return lojaRepository.save(paramLoja.get());
		}
		
		throw new BusinessException("Faixa de CEP já cadastrada");
	}

	public void delete(Integer id) {
		Loja paramLoja = find(id).get();
		
		lojaRepository.delete(paramLoja);
	}
	
	private boolean cepIntervalIsAvailable(Loja loja) {
		List<Loja> lojasCepInicial = lojaRepository.cepIsBetween(loja.getCepInicial());
		List<Loja> lojasCepFinal = lojaRepository.cepIsBetween(loja.getCepFinal());
		List<Loja> lojasIntervaloContido = 
				lojaRepository.cepIntervalIsGreaterThenOtherCepInterval(loja.getCepInicial(), loja.getCepFinal());
		
		return lojasCepInicial.isEmpty() && lojasCepFinal.isEmpty() && lojasIntervaloContido.isEmpty() ? true : false;
	}
	
	private Optional<Loja> find(Integer id){
		Optional<Loja> obj = lojaRepository.findById(id);
		
		return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
	}
}
