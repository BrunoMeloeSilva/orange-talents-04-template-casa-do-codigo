package br.com.zupacademy.brunomeloesilva.casadocodigo.autor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoParaAutorDTORequestValidator implements Validator {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTORequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) 
			return;
		
		if(emailJaexiste(target, errors)) 
			errors.rejectValue("email", null, "O email informado já existe.");
	}
	
	private boolean emailJaexiste(Object target, Errors errors) {
		TypedQuery<String> query = entityManager
				.createQuery("Select a.email From AutorModel a Where a.email = :email", String.class);
		
		AutorDTORequest autorDTORequest = (AutorDTORequest) target;
		List<String> emailsJaExistentes = query.setParameter("email", autorDTORequest.getEmail()).getResultList();
		
		if(emailsJaExistentes.size() > 0) {
			return true;
		}
		return false;
	}
}