package br.com.zupacademy.brunomeloesilva.casadocodigo.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public CategoriaDTOResponse cadastrar(@RequestBody @Valid CategoriaDTORequest categoriaDTORequest) {
		CategoriaModel categoriaModel = categoriaDTORequest.toModel();
		entityManager.persist(categoriaModel);
		return new CategoriaDTOResponse(categoriaModel);
	}
}
