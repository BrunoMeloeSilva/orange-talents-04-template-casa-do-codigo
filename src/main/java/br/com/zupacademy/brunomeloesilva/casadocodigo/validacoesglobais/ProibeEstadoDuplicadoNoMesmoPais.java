package br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ProibeEstadoDuplicadoNoMesmoPaisValidator.class})
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ProibeEstadoDuplicadoNoMesmoPais {
	
	String message() default "{br.com.zupacademy.brunomeloesilva.casadocodigo.validacoesglobais.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
