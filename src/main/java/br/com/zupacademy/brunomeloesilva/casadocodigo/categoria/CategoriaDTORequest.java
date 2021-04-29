package br.com.zupacademy.brunomeloesilva.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.ProibeValorDuplicado;

public class CategoriaDTORequest {
	
	@NotBlank @ProibeValorDuplicado(classeDominio = CategoriaModel.class, nomeCampo = "nome")
	private String nome;

	
	public CategoriaDTORequest(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public String getNome() { return nome; }

	public CategoriaModel toModel() {
		return new CategoriaModel(this.nome);
	}

}
