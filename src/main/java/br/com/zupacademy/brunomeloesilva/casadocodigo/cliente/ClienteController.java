package br.com.zupacademy.brunomeloesilva.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public ClienteDTOResponse cadastrar(@RequestBody @Valid ClienteDTORequest clienteDTORequest) {
		ClienteModel clienteModel = clienteDTORequest.toModel(entityManager);
		entityManager.persist(clienteModel);
		return new ClienteDTOResponse(clienteModel);
		
	}
}
