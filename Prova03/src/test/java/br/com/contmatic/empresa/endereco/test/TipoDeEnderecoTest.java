package br.com.contmatic.empresa.endereco.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import br.com.contmatic.empresa.endereco.TIPODEENDERECO;

public class TipoDeEnderecoTest {
	
	private Validator validator;

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public boolean isValid(TIPODEENDERECO tipodeendereco, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<TIPODEENDERECO>> restricoes = validator.validate(tipodeendereco);
		for (ConstraintViolation<TIPODEENDERECO> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem)) {
				valido = false;
			}
		return valido;
	}

	@Test
	public void deve_aceitar_tipo_residencial_valido() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		assertTrue(residencial.name().equals(TIPODEENDERECO.ENDERECORESIDENCIAL.name()));
	}
	
	@Test
	public void nao_deve_aceitar_tipo_residecial_diferente_do_especificado() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		assertNotEquals(TIPODEENDERECO.ENDERECOCOMERCIAL.name(), residencial.name());
	}
	
	@Test
	public void nao_deve_aceitar_tipo_residencial_nulo() {
		fail();
//		TIPODEENDERECO residencial = null;
//		residencial.setTipo(null);
//		assertFalse(isValid(residencial, "Tipo de Endereco nao pode ser nulo"));
	}
	
	@Test
	public void deve_acertar_que_o_tipo_residencial_e_diferente_de_nulo() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		assertNotNull(residencial);
	}
	
	@Test
	public void deve_aceitar_tipo_comercial_valido() {
		TIPODEENDERECO comercial = TIPODEENDERECO.ENDERECOCOMERCIAL;
		assertTrue(comercial.name().equals(TIPODEENDERECO.ENDERECOCOMERCIAL.name()));
	}
	
	@Test
	public void nao_deve_aceitar_tipo_comercial_diferente_do_especificado() {
		TIPODEENDERECO comercial = TIPODEENDERECO.ENDERECOCOMERCIAL;
		assertNotEquals(TIPODEENDERECO.ENDERECORESIDENCIAL.name(), comercial.name());
	}
	
	@Test
	public void nao_deve_aceitar_tipo_comercial_nulo() {
		fail();
//		TIPODEENDERECO residencial = null;
//		residencial.setTipo(null);
//		assertFalse(isValid(residencial, "Tipo de Endereco nao pode ser nulo"));
	}
	
	@Test
	public void deve_imprimir_tostring_para_tipo_residencial() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		System.out.println(residencial.toString());
	}
	
	@Test
	public void deve_imprimir_tostring_para_tipo_comercial() {
		TIPODEENDERECO comercial = TIPODEENDERECO.ENDERECOCOMERCIAL;
		System.out.println(comercial.toString());
	}
	
}
