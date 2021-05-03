package br.com.zupacademy.brunomeloesilva.casadocodigo.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.estado.EstadoDTOResponse;
import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais.PaisDTOResponse;

@JsonInclude(Include.NON_NULL)
public class ClienteDTOResponse {
	
	private Long id;
	private String email;
	private String nome;
	private String sobrenome;
	private String cpfOuCnpj;
	private String endereco;
	private String complemento;
	private String cidade;
	private PaisDTOResponse pais;
	private EstadoDTOResponse estado;
	private String telefone;
	private String cep;

	public ClienteDTOResponse(ClienteModel clienteModel) {
		this.id = clienteModel.getId();
		this.email = clienteModel.getEmail();
		this.nome = clienteModel.getNome();
		this.sobrenome = clienteModel.getSobrenome();
		this.cpfOuCnpj = clienteModel.getCpfOuCnpj();
		this.endereco = clienteModel.getEndereco();
		this.complemento = clienteModel.getComplemento();
		this.cidade = clienteModel.getCidade();
		this.pais = new PaisDTOResponse(clienteModel.getPais());
		this.telefone = clienteModel.getTelefone();
		this.cep = clienteModel.getCep();
		//Porque a regra diz que pode ser opcional ou não o Estado.
		if(clienteModel.getEstado() != null)
			this.estado = new EstadoDTOResponse(clienteModel.getEstado());
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

	public PaisDTOResponse getPais() {
		return pais;
	}

	public EstadoDTOResponse getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
}
