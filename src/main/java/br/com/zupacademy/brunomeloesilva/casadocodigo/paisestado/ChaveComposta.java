package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChaveComposta implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long pais_id;
	private Long estado_id;
	
	public ChaveComposta(Long pais_id, Long estado_id) {
		this.pais_id = pais_id;
		this.estado_id = estado_id;
	}
	
	public Long getPais_id() {
		return pais_id;
	}

	public Long getEstado_id() {
		return estado_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado_id == null) ? 0 : estado_id.hashCode());
		result = prime * result + ((pais_id == null) ? 0 : pais_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChaveComposta other = (ChaveComposta) obj;
		if (estado_id == null) {
			if (other.estado_id != null)
				return false;
		} else if (!estado_id.equals(other.estado_id))
			return false;
		if (pais_id == null) {
			if (other.pais_id != null)
				return false;
		} else if (!pais_id.equals(other.pais_id))
			return false;
		return true;
	}
}
