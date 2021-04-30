package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zupacademy.brunomeloesilva.casadocodigo.autor.AutorModel;
import br.com.zupacademy.brunomeloesilva.casadocodigo.categoria.CategoriaModel;

@Entity
@Table(name = "LIVRO")
public class LivroModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String titulo;
	
	@Column(nullable = false, length = 500)
	private String resumo;
	
	@Column(columnDefinition = "TEXT")
	private String sumario;
	
	@Column(nullable = false, columnDefinition = "NUMERIC(15,2)")
	private Float preco;
	
	@Column(columnDefinition = "INT UNSIGNED")
	private Integer numeroPaginas;
	
	@Column(nullable = false, unique = true)
	private String isbn;
	
	private Date dataPublicacao;
	
	@ManyToOne
	private CategoriaModel categoria;
	
	@ManyToOne
	private AutorModel autor;

	@Deprecated
	public LivroModel() {/*Este construtor é para uso do Hibernate, para as buscas no DB*/}
	
	
	public LivroModel(LivroDTORequest livroDTORequest, EntityManager entityManager) {
		this.titulo = livroDTORequest.getTitulo();
		this.resumo = livroDTORequest.getResumo();
		this.sumario = livroDTORequest.getSumario();
		this.preco = livroDTORequest.getPreco();
		this.numeroPaginas = livroDTORequest.getNumeroPaginas();
		this.isbn = livroDTORequest.getIsbn();
		this.dataPublicacao = livroDTORequest.getDataPublicacao();
		//Essa busca nunca vai dar erro, pois a existencia do Id é checada no DTO, antes de chegar aqui.
		this.categoria = entityManager.find(CategoriaModel.class, livroDTORequest.getCategoriaId());
		this.autor = entityManager.find(AutorModel.class, livroDTORequest.getAutorId());
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

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public AutorModel getAutor() {
		return autor;
	}	
}
