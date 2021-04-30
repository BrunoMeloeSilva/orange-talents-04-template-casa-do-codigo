package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LivroDTOResponseCompleto {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private Float preco;
	private Integer numeroPaginas;
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date dataPublicacao;
	private LivroAutorDTOResponse autor;

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

	public LivroAutorDTOResponse getAutor() {
		return autor;
	}

	public Optional<LivroDTOResponseCompleto> getOne(Long id, EntityManager entityManager) {
		LivroModel livroModel = entityManager.find(LivroModel.class, id);
		
		if(livroModel != null) {
			this.id = livroModel.getId();
			this.titulo = livroModel.getTitulo();
			this.resumo = livroModel.getResumo();
			this.sumario = livroModel.getSumario();
			this.preco = livroModel.getPreco();
			this.numeroPaginas = livroModel.getNumeroPaginas();
			this.isbn = livroModel.getIsbn();
			this.dataPublicacao = livroModel.getDataPublicacao();
			this.autor = new LivroAutorDTOResponse(livroModel.getAutor());
			return Optional.of(this);
		}
		
		return Optional.ofNullable(null);
	}
}
