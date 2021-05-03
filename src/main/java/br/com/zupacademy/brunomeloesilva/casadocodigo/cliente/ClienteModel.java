package br.com.zupacademy.brunomeloesilva.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.estado.EstadoModel;
import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais.PaisModel;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	@Column(nullable = false, length = 14, unique = true)
	private String cpfOuCnpj;
	@Column(nullable = false)
	private String endereco;
	@Column(nullable = false)
	private String complemento;
	@Column(nullable = false)
	private String cidade;
	@ManyToOne 
	@JoinColumn(name = "pais_id", nullable = false)
	private PaisModel pais;
	@ManyToOne 
	@JoinColumn(name = "estado_id")
	private EstadoModel estado;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String cep;
	
	@Deprecated
	public ClienteModel() {/*Este construtor é para uso do Hibernate, para as buscas no DB*/}

	public ClienteModel(ClienteDTORequest clienteDTORequest, EntityManager entityManager) {
		this.email = clienteDTORequest.getEmail();
		this.nome = clienteDTORequest.getNome();
		this.sobrenome = clienteDTORequest.getSobrenome();
		this.cpfOuCnpj = clienteDTORequest.getCpfOuCnpj();
		this.endereco = clienteDTORequest.getEndereco();
		this.complemento = clienteDTORequest.getComplemento();
		this.cidade = clienteDTORequest.getCidade();
		this.telefone = clienteDTORequest.getTelefone();
		this.cep = clienteDTORequest.getCep();
		this.pais = entityManager.find(PaisModel.class, clienteDTORequest.getPaisId());
		//Porque a regra diz que pode ser opcional ou não o Estado.
		if(clienteDTORequest.getEstadoId() != null)
			this.estado = entityManager.find(EstadoModel.class, clienteDTORequest.getEstadoId());	
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public PaisModel getPais() {
		return pais;
	}

	public EstadoModel getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
}
