package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.estado;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais.PaisDTOResponse;
import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais.PaisModel;

public class EstadoDTOResponse {

	private Long id;
	private String nome;
	private PaisDTOResponse paisDTOResponse;
	
	public EstadoDTOResponse(Long paisId, EstadoModel estadoModel, EntityManager entityManager) {
		this.id = estadoModel.getId();
		this.nome = estadoModel.getNome();
		this.paisDTOResponse = getPaisDTOResponse(paisId, entityManager);
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public PaisDTOResponse getPais() {
		return paisDTOResponse;
	}
	
	private PaisDTOResponse getPaisDTOResponse(Long paisId, EntityManager entityManager) {
		//Não preciso tratar possível erro do getSingleResult, pois neste ponto o País vai SEMPRE existir.
		String sql = "From PaisModel p Where p.id = " + paisId;
		TypedQuery<PaisModel> query = entityManager.createQuery(sql, PaisModel.class);
		return new PaisDTOResponse(query.getSingleResult());
	}
}
