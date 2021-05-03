package br.com.zupacademy.brunomeloesilva.casadocodigo.paisestado.pais;

public class PaisDTOResponse {
	
	private Long id;
	private String nome;

	public PaisDTOResponse(PaisModel paisModel) {
		this.id = paisModel.getId();
		this.nome = paisModel.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
