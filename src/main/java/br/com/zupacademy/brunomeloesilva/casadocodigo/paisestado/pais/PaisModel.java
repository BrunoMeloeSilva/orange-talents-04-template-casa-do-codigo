package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS")
public class PaisModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 80, unique = true, nullable = false)
	private String nome;
	
	@Deprecated
	public PaisModel() {/*Este construtor é para uso do Hibernate, para as buscas no DB*/}
	
	public PaisModel(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
}
