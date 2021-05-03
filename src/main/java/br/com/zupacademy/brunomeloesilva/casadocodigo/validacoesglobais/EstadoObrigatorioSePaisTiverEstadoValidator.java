package br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoObrigatorioSePaisTiverEstadoValidator implements ConstraintValidator<EstadoObrigatorioSePaisTiverEstado, Object> {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private String identificadorPais;
	private String identificadorEstado;
	
	@Override
	public void initialize(EstadoObrigatorioSePaisTiverEstado constraintAnnotation) {
		identificadorPais = constraintAnnotation.identificadorPais();
		identificadorEstado = constraintAnnotation.identificadorEstado();
	}
	
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		
		Map<String, Object> mapAtributos = retornaOsAtributosEValoresDoObjeto(object);
		
		String sql = String.format("Select count(*) > 0 From PaisEstadoModel pe Where pe.chaveComposta.pais_id = %s", mapAtributos.get(identificadorPais));
		TypedQuery<Boolean> query = entityManager.createQuery(sql, Boolean.class);
		Boolean paisPossuiEstados = query.getSingleResult();
		
		if(paisPossuiEstados && mapAtributos.get(identificadorEstado) == null) {
			return false;
		}
		return true;
	}

	//TODO Este método está se repetindo no meu código, portanto, deveria estar em uma classe separada.
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