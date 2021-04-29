package br.com.zupacademy.brunomeloesilva.casadocodigo.categoria;

public class CategoriaDTOResponse {

	private Long id;
	private String nome;
	
	public CategoriaDTOResponse(CategoriaModel categoriaModel) {
		this.id = categoriaModel.getId();
		this.nome = categoriaModel.getNome();
	}

	public String getNome() { return nome; }
	public Long getid() { return id; }
}
