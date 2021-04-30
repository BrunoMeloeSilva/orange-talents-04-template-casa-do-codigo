package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.brunomeloesilva.casadocodigo.autor.AutorModel;
import br.com.zupacademy.brunomeloesilva.casadocodigo.categoria.CategoriaModel;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.IdExistente;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.ProibeValorDuplicado;

public class LivroDTORequest {
	
	@NotBlank @ProibeValorDuplicado(classeDominio = LivroModel.class, nomeCampo = "titulo")
	private String titulo;
	
	@NotBlank @Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(20)
	private Float preco;
	
	@NotNull @Min(100)
	private Integer numeroPaginas;
	
	@NotBlank @ProibeValorDuplicado(classeDominio = LivroModel.class, nomeCampo = "isbn")
	private String isbn;
	
	@Future @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date dataPublicacao;
	
	@NotNull @IdExistente(classeDominio = CategoriaModel.class, identificador = "id")
	private Long categoriaId;
	
	@NotNull @IdExistente(classeDominio = AutorModel.class, identificador = "id")
	private Long autorId;
	
	public LivroDTORequest(String titulo, String resumo, String sumario, Float preco, Integer numeroPaginas,
			String isbn, @JsonProperty(value = "dataPublicacao") Date dataPublicacao, Long categoriaId,
			Long autoresId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autoresId;
	}

	public LivroModel toModel(EntityManager entityManager) {
		return new LivroModel(this, entityManager);
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