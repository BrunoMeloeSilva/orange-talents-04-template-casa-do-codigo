package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.ProibeValorDuplicado;

public class PaisDTORequest {
	
	@NotBlank
	@Size(max = 80)
	@ProibeValorDuplicado(classeDominio = PaisModel.class, nomeCampo = "nome")
	private String nome;

	public PaisDTORequest(@JsonProperty(value = "nome") String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public PaisModel toModel() {
		return new PaisModel(this.nome);
	}
}
