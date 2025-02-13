package br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ProibeValorDuplicadoValidator.class})
@Retention(RUNTIME)
@Target(FIELD)
public @interface ProibeValorDuplicado {
	
	String message() default "{javax.validation.constraints.ProibeValorDuplicado.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String nomeCampo();
	Class<?> classeDominio();
}
//TODO Esse nome de pacote para o erro não tem nada haver, trocar para o pacote atual