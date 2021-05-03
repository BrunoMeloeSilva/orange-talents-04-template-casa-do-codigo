package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping
	@Transactional
	public PaisDTOResponse cadastrar(@RequestBody @Valid PaisDTORequest paisDTORequest) {
		PaisModel paisModel = paisDTORequest.toModel();
		entityManager.persist(paisModel);
		return new PaisDTOResponse(paisModel);
	}
}
