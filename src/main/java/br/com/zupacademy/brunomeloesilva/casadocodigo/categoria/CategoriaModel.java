package br.com.zupacademy.brunomeloesilva.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA") 
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;

	public CategoriaModel(String nome) {
		this.nome = nome;
	}

	public String getNome() { return nome; }
	public Long getId() { return id; }
}
