package br.com.contmatic.empresa.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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

}
