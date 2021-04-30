package br.com.zupacademy.brunomeloesilva.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public LivroDTOResponse cadastrar(@RequestBody @Valid LivroDTORequest livroDTORequest) {
		LivroModel livroModel = livroDTORequest.toModel(entityManager);
		entityManager.persist(livroModel);
		return new LivroDTOResponse(livroModel);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTOResponseResumido>> retornaTodosLivros(){	
		List<LivroDTOResponseResumido> livroDTOResponseResumidoList = LivroDTOResponseResumido.getAll(entityManager);
		
		if(livroDTOResponseResumidoList.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(livroDTOResponseResumidoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDTOResponseCompleto> retornaUmLivro(@PathVariable Long id){	
		Optional<LivroDTOResponseCompleto> livroDTOCompleto = new LivroDTOResponseCompleto().getOne(id, entityManager);
		
		if(livroDTOCompleto.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(livroDTOCompleto.get());
	}
}
