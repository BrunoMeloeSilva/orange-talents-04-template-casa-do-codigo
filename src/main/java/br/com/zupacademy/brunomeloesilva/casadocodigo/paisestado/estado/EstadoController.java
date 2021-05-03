package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.ChaveComposta;
import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.PaisEstadoModel;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping()
	@Transactional
	public EstadoDTOResponse cadastrar(@RequestBody @Valid EstadoDTORequest estadoDTORequest) {
		EstadoModel estadoModel = estadoDTORequest.toModel(entityManager, estadoDTORequest);
		entityManager.persist(estadoModel);
		ChaveComposta chaveComposta = new ChaveComposta(estadoDTORequest.getPaisId(), estadoModel.getId());
		entityManager.persist(new PaisEstadoModel(chaveComposta, estadoModel));
		return new EstadoDTOResponse(estadoDTORequest.getPaisId(), estadoModel, entityManager);
	}
}
