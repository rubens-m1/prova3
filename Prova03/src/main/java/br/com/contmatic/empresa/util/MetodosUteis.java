package br.com.contmatic.empresa.util;

import java.util.Random;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.DateTime;

import br.com.contmatic.empresa.Empresa;

public class MetodosUteis {
	
	public Validator validator;

	public ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		
	public boolean isValid(Empresa empresa, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Empresa>> restricoes = validator.validate(empresa);
		for (ConstraintViolation<Empresa> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem)) {
				valido = false;
			}
		return valido;
	}
	
//	public void gerarData() {
//		registerValueGenerator(new ValueGenerator<DateTime>() {
//			public DateTime generate() {
//				return new DateTime(new Random().nextLong()).withMillisOfSecond(0);
//			}
//		}, DateTime.class);
//	}

}
