package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO")
public class EstadoModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 80, unique = true, nullable = false)
	private String nome;	
	
	@Deprecated
	public EstadoModel() {/*Este construtor é para uso do Hibernate, para as buscas no DB*/}
	
	public EstadoModel(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
