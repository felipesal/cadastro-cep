package com.felipesalles.apicadastrocep.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CODIGO_LOJA")
	private String nome;
	
	@Column(name="FAIXA_INICIO")
	private Long cepInicial;
	
	@Column(name="FAIXA_FIM")
	private Long cepFinal;
	
	public Loja() {
		
	}

	public Loja(Integer id, String nome, Long cepInicial, Long cepFinal) {
		this.id = id;
		this.nome = nome;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCepInicial() {
		return cepInicial;
	}

	public void setCepInicial(Long cepInicial) {
		this.cepInicial = cepInicial;
	}

	public Long getCepFinal() {
		return cepFinal;
	}

	public void setCepFinal(Long cepFinal) {
		this.cepFinal = cepFinal;
	}
	
}
