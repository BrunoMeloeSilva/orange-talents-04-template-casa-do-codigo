package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.estado;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais.PaisModel;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.IdExistente;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.ProibeEstadoDuplicadoNoMesmoPais;

@ProibeEstadoDuplicadoNoMesmoPais
public class EstadoDTORequest {
	@NotBlank
	@Size(max = 80)
	private String nome;
	@NotNull
	@IdExistente(classeDominio = PaisModel.class, identificador = "id")
	private Long paisId;

	public EstadoDTORequest(String nome, Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}
	
	public EstadoDTORequest(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Long getPaisId() {
		return paisId;
	}

	public EstadoModel toModel(EntityManager entityManager, EstadoDTORequest estadoDTORequest) {
		return casoNaoExistaRetornaNovoEstadoModel(entityManager, estadoDTORequest);
	}

	private EstadoModel casoNaoExistaRetornaNovoEstadoModel(EntityManager entityManager, EstadoDTORequest estadoDTORequest) {
		String sql = String.format("From EstadoModel e Where e.nome = '%s'", estadoDTORequest.getNome());
		TypedQuery<EstadoModel> query = entityManager.createQuery(sql, EstadoModel.class);
		
		EstadoModel estadoModel = null;
		try {
			estadoModel = query.getSingleResult();
		}catch (NoResultException e) {
			estadoModel = new EstadoModel(this.nome);
		}
		
		return estadoModel;
	}

}
//TODO trocar o nome @IdExistente para @IdJaDeveExistir