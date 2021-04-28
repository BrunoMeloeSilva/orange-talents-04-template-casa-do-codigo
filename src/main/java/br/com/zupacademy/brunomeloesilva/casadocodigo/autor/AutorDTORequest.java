package br.com.zupacademy.brunomeloesilva.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTORequest {
	
	@NotBlank
	private String nome;
	@NotBlank @Email
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public AutorDTORequest(String nome, String email, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getDescricao() { return descricao; }

	public AutorModel toModel() {
		return new AutorModel(this.nome, this.email, this.descricao);
	}
	
	
}
