package br.com.zupacademy.brunomeloesilva.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriaDTORequest {
	
	@NotBlank
	private String nome;

	
	public CategoriaDTORequest(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public String getNome() { return nome; }

	public CategoriaModel toModel() {
		return new CategoriaModel(this.nome);
	}

}
