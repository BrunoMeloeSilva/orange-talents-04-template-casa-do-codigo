package br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProibeEstadoDuplicadoNoMesmoPaisValidator implements ConstraintValidator<ProibeEstadoDuplicadoNoMesmoPais, Object> {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void initialize(ProibeEstadoDuplicadoNoMesmoPais constraintAnnotation) {}
	
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		
		Map<String, Object> mapAtributos = retornaOsAtributosEValoresDoObjeto(object);
		
		String sql = String.format("Select count(*)>0 "
				+ "From PaisEstadoModel pe join pe.estadoModel e "
				+ "Where pe.chaveComposta.pais_id = %s And e.nome = '%s'"
				, mapAtributos.get("paisId"), mapAtributos.get("nome"));
		
		TypedQuery<Boolean> query = entityManager.createQuery(sql, Boolean.class);
		
		Boolean chaveDuplicada = query.getSingleResult();
		
		if(chaveDuplicada) {
			return false;
		}
		return true;
	}

	private Map<String, Object> retornaOsAtributosEValoresDoObjeto(Object object) {
		Class<?> clazz = object.getClass();
	    Map<String, Object> mapAtributos = new HashMap<>();
	    for (Field field : clazz.getDeclaredFields()) {
	        field.setAccessible(true);
	            try {
					mapAtributos.put(field.getName(), field.get(object));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
	    }
		return mapAtributos;
	}
}