package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public LivroDTOResponse cadastrar(@RequestBody @Valid LivroDTORequest livroDTORequest) {
		LivroModel livroModel = livroDTORequest.toModel(entityManager);
		entityManager.persist(livroModel);
		return new LivroDTOResponse(livroModel);
		
	}
}
