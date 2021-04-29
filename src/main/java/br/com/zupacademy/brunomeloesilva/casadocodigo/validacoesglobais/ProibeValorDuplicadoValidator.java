package br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProibeValorDuplicadoValidator implements ConstraintValidator<ProibeValorDuplicado, Object> {

	private Class<?> classeDominio;
	private String nomeCampo;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void initialize(ProibeValorDuplicado constraintAnnotation) {
		this.nomeCampo = constraintAnnotation.nomeCampo();
		this.classeDominio = constraintAnnotation.classeDominio();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String sql = String.format("Select 1 From %s t Where t.%s = :%2$s"
				, classeDominio.getSimpleName(), nomeCampo );
		
		Query query = entityManager.createQuery(sql);
		query.setParameter(nomeCampo, value);
		
		List<?> valoresJaExistentes = query.getResultList();
		
		if(valoresJaExistentes.size() > 0) {
			return false;
		}
		return true;
	}

}
