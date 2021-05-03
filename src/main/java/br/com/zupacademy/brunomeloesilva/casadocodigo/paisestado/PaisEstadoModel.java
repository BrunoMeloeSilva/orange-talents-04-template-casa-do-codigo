package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.estado.EstadoModel;

@Entity
@Table(name = "pais_estado")
public class PaisEstadoModel {
	
	@EmbeddedId
	private ChaveComposta chaveComposta;
	
	@ManyToOne
	@MapsId("estado_id")
	@JoinColumn(name = "estado_id")
	private EstadoModel estadoModel;

	public PaisEstadoModel(ChaveComposta chaveComposta, EstadoModel estadoModel) {
		this.chaveComposta = chaveComposta;
		this.estadoModel = estadoModel;
	}	
}
