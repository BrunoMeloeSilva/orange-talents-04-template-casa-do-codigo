package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LivroDTOResponseResumido {
	
	private Long id;
	private String titulo;
	
	public LivroDTOResponseResumido(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}	
	
	public static List<LivroDTOResponseResumido> getAll(EntityManager entityManager){
		TypedQuery<LivroModel> query = entityManager.createQuery("From LivroModel", LivroModel.class);
		List<LivroModel> LivroModelList = query.getResultList();
		
		return converteUmaListaDeLivroModelParaLivroDTOResponseResumido(LivroModelList);
	}

	private static List<LivroDTOResponseResumido> converteUmaListaDeLivroModelParaLivroDTOResponseResumido(List<LivroModel> LivroModelList) {
		return LivroModelList.stream()
			.map(livroModel -> new LivroDTOResponseResumido(livroModel.getId(), livroModel.getTitulo()))
			.collect(Collectors.toList());
	}
}
