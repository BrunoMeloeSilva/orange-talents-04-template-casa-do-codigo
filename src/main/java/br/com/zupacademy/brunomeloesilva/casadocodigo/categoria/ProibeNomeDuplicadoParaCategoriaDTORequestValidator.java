package br.com.zupacademy.brunomeloesilva.casadocodigo.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoParaCategoriaDTORequestValidator implements Validator {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDTORequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) 
			return;
		
		if(nomeJaexiste(target, errors)) 
			errors.rejectValue("nome", null, "O nome informado já existe.");
	}

	private boolean nomeJaexiste(Object target, Errors errors) {
		TypedQuery<String> query = entityManager
				.createQuery("Select c.nome From CategoriaModel c Where c.nome = :nome", String.class);
		
		CategoriaDTORequest categoriaDTORequest = (CategoriaDTORequest) target;
		List<String> categoriasJaExistentes = query.setParameter("nome", categoriaDTORequest.getNome()).getResultList();
		
		if(categoriasJaExistentes.size() > 0) {
			return true;
		}
		return false;
	}
}
