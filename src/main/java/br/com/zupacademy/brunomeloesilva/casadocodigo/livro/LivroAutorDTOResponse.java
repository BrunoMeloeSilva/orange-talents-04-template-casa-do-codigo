package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import br.com.zupacademy.brunomeloesilva.casadocodigo.autor.AutorModel;

public class LivroAutorDTOResponse {
	
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	
	public LivroAutorDTOResponse(AutorModel autorModel) {
		this.id = autorModel.getId();
		this.nome = autorModel.getNome();
		this.email = autorModel.getEmail();
		this.descricao = autorModel.getDescricao();
	}

	public Long geId() { return id; } 
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getDescricao() { return descricao; }
}
