package br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdExistenteValidator implements ConstraintValidator<IdExistente, Object> {

	private Class<?> classeDominio;
	private String identificador;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void initialize(IdExistente constraintAnnotation) {
		this.identificador = constraintAnnotation.identificador();
		this.classeDominio = constraintAnnotation.classeDominio();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String sql = String.format("Select count(*)>0 From %s t Where t.%s = :%2$s"
				, classeDominio.getSimpleName(), identificador );
		
		TypedQuery<Boolean> query = entityManager.createQuery(sql, Boolean.class);
		query.setParameter(identificador, value);
		
		Boolean idExistente = query.getSingleResult();
		
		if(!idExistente) {
			return false;
		}
		return true;
	}

}
