package br.com.zupacademy.brunomeloesilva.casadocodigo.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public AutorDTOResponse cadastrar(@RequestBody @Valid AutorDTORequest autorDTORequest) {
		AutorModel autorModel = autorDTORequest.toModel();
		entityManager.persist(autorModel);
		return new AutorDTOResponse(autorModel);
	}
}
