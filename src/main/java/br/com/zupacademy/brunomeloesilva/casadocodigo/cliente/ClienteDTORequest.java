package br.com.zupacademy.brunomeloesilva.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais.PaisModel;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.CpfOuCnpj;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.EstadoDevePertencerAoPais;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.EstadoObrigatorioSePaisTiverEstado;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.IdExistente;
import br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.ProibeValorDuplicado;

@EstadoObrigatorioSePaisTiverEstado(identificadorPais = "paisId", identificadorEstado = "estadoId")
@EstadoDevePertencerAoPais(identificadorPais = "paisId", identificadorEstado = "estadoId")
public class ClienteDTORequest {
	
	@NotBlank @Email @ProibeValorDuplicado(classeDominio = ClienteModel.class, nomeCampo = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@ProibeValorDuplicado(classeDominio = ClienteModel.class, nomeCampo = "cpfOuCnpj")
	@CpfOuCnpj
	private String cpfOuCnpj;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@IdExistente(classeDominio = PaisModel.class, identificador = "id")
	private Long paisId;
	private Long estadoId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public ClienteDTORequest(String email, String nome, String sobrenome, String cpfOuCnpj, String endereco,
			String complemento, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
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

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public ClienteModel toModel(EntityManager entityManager) {
		return new ClienteModel(this, entityManager);
	}
}
