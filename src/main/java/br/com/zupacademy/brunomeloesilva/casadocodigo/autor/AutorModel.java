package br.com.zupacademy.brunomeloesilva.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR") 
public class AutorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, length = 400)
	private String descricao;
	@Column(nullable = false)
	private LocalDateTime dataCriacao;
	
	@Deprecated
	public AutorModel() {/*Este construtor é para uso do Hibernate, para as buscas no DB*/}
	
	public AutorModel(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCriacao = LocalDateTime.now();
	}

	public Long getId() { return id; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getDescricao() { return descricao; }
	public LocalDateTime getDataCriacao() { return dataCriacao; }
	
	
}
