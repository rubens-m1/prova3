package br.com.contmatic.empresa.util.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.contmatic.empresa.Empresa;

public class MetodosUteis {
	
	private Validator validator;

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			
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
//		registerValueGenerator(new ValueGenerator<LocalDate>() {
//			public LocalDate generate() {
//				return new LocalDate(new Random().nextLong());
//			}
//		}, LocalDate.class);
//	}
	
//	public void gerarData() {
//		registerValueGenerator(new ValueGenerator<DateTime>() {
//			public DateTime generate() {
//				return new DateTime(new Random().nextLong()).withMillisOfSecond(0);
//			}
//		}, DateTime.class);
//	}

}
