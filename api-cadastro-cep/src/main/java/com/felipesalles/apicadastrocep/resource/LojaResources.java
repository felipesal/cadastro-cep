package com.felipesalles.apicadastrocep.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felipesalles.apicadastrocep.domain.Loja;
import com.felipesalles.apicadastrocep.service.LojaService;

@RestController
@RequestMapping("/lojas")
public class LojaResources {
	
	@Autowired
	private LojaService lojaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Loja addLoja(@RequestBody Loja loja) {
		return lojaService.insert(loja);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Loja> getAllLojas() {
		return lojaService.findAll();
	}
	
	@RequestMapping("/{id}")
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Loja editLoja(@PathVariable Integer id ,@RequestBody Loja loja) {
		return lojaService.update(id, loja);
	}
	
	@RequestMapping("/delete/{id}")
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLoja(@PathVariable Integer id) {
		lojaService.delete(id);
	}
}
