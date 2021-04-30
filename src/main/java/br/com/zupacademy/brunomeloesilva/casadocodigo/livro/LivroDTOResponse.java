package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LivroDTOResponse {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private Float preco;
	private Integer numeroPaginas;
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date dataPublicacao;
	private Long categoriaId;
	private Long autorId;
	
	public LivroDTOResponse(LivroModel livroModel) {
		this.id = livroModel.getId();
		this.titulo = livroModel.getTitulo();
		this.resumo = livroModel.getResumo();
		this.sumario = livroModel.getSumario();
		this.preco = livroModel.getPreco();
		this.numeroPaginas = livroModel.getNumeroPaginas();
		this.isbn = livroModel.getIsbn();
		this.dataPublicacao = livroModel.getDataPublicacao();
		this.categoriaId = livroModel.getCategoria().getId();
		this.autorId = livroModel.getAutor().getId();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Float getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}
}
