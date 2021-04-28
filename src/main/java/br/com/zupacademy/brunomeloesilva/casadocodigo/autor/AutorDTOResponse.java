package br.com.zupacademy.brunomeloesilva.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorDTOResponse {
	
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCriacao;
	
	public AutorDTOResponse(AutorModel autorModel) {
		this.id = autorModel.getId();
		this.nome = autorModel.getNome();
		this.email = autorModel.getEmail();
		this.descricao = autorModel.getDescricao();
		this.dataCriacao = autorModel.getDataCriacao();
	}

	public Long geId() { return id; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getDescricao() { return descricao; }
	public LocalDateTime getdataCriacao() { return dataCriacao; }	
}
