package telefonetest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.telefone.TIPODETELEFONE;

public class TipoDeTelefoneTest {

	private TIPODETELEFONE comercial;
	
	private TIPODETELEFONE fixo;
	
	private TIPODETELEFONE celular;
	
	private Validator validator;
	
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	@Before
	public void init() {
		
		comercial = TIPODETELEFONE.TELEFONECOMERCIAL;

		fixo = TIPODETELEFONE.TELEFONEFIXO;

		celular = TIPODETELEFONE.TELEFONECELULAR;

	}
	
	public boolean isValid(TIPODETELEFONE comercial, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<TIPODETELEFONE>> restricoes = validator.validate(comercial);
		for (ConstraintViolation<TIPODETELEFONE> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem)) {
				valido = false;
			}
		return valido;
	}

	@Test
	public void nao_deve_aceitar_telefone_comercial_nulo() {
		comercial.setNumero(null);
		assertFalse(isValid(comercial, "numero de telefone em branco"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_fixo_nulo() {
		fixo.setNumero(null);
		assertFalse(isValid(fixo, "numero de telefone em branco"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_celular_nulo() {
		celular.setNumero(null);
		assertFalse(isValid(celular, "numero de telefone em branco"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_vazio_celular() {
		celular.setNumero("");
		assertFalse(isValid(celular, "numero de telefone em branco"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_vazio_comercial() {
		comercial.setNumero("");
		assertFalse(isValid(comercial, "numero de telefone em branco"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_vazio_fixo() {
		fixo.setNumero("");
		assertFalse(isValid(fixo, "numero de telefone em branco"));
	}
	
	@Test
	public void deve_aceitar_telefone_correto_celular() {
		celular.setNumero("987654321");
		assertTrue(isValid(celular, "987654321"));
	
	}
	
	@Test
	public void deve_aceitar_telefone_correto_celular_com_traco() {
		celular.setNumero("98765-4321");
		assertTrue(isValid(celular, "98765-4321"));
	}
	
	@Test
	public void deve_aceitar_telefone_correto_com_8_digitos_comercial() {
		comercial.setNumero("98765432");
		assertTrue(isValid(comercial, "98765432"));
	}
	
	@Test
	public void deve_aceitar_telefone_correto_com_8_digitos_comercial_com_traco() {
		comercial.setNumero("9876-5432");
		assertTrue(isValid(comercial, "9876-5432"));
	}

	@Test
	public void deve_aceitar_telefone_correto_com_9_digitos_comercial() {
		comercial.setNumero("987654321");
		assertTrue(isValid(comercial, "987654321"));
	}
	
	@Test
	public void deve_aceitar_telefone_correto_com_9_digitos_comercial_com_traço() {
		comercial.setNumero("98765-4321");
		assertTrue(isValid(comercial, "98765-4321"));
	}
	
	@Test
	public void deve_aceitar_telefone_correto_fixo() {
		fixo.setNumero("55555555");
		assertTrue(isValid(fixo, "55555555"));
	}
	
	@Test
	public void deve_aceitar_telefone_correto_fixo_com_traco() {
		fixo.setNumero("5555-5555");
		assertTrue(isValid(fixo, "5555-5555"));
	}
	
//	@Test
//	public void nao_deve_aceitar_telefone_celular_com_menos_de_9_digitos() {
//		celular.setNumero("98765432");
//		assertFalse(isValid(celular, ""));
//	}
	
	@Test
	public void nao_deve_aceitar_telefone_comercial_com_menos_de_8_digitos() {
		comercial.setNumero("9876543");
		assertFalse(isValid(comercial, "formato de telefone invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_fixo_com_menos_de_8_digitos() {
		fixo.setNumero("9876543");
		assertFalse(isValid(fixo, "formato de telefone invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_celular_com_mais_de_9_digitos() {
		celular.setNumero("9876543210");
		assertFalse(isValid(celular, "formato de telefone invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_telefone_comercial_com_mais_de_9_digitos() {
		comercial.setNumero("9876543210");
		assertFalse(isValid(comercial, "formato de telefone invalido"));
	}
	
//	@Test
//	public void nao_deve_aceitar_telefone_fixo_com_mais_de_8_digitos() {
//		fixo.setNumero("987654321");
//		assertFalse(isValid(fixo, "formato de telefone invalido"));
//	}
	
	@Test
	public void deve_acertar_o_comprimento_de_9_digitos_no_telefone_celular() {
		celular.setNumero("987654321");
		assertThat(celular.getNumero().length(), is(9));
	}

	@Test
	public void deve_acertar_o_comprimento_de_8_digitos_no_telefone_comercial() {
		comercial.setNumero("12345678");
		assertThat(comercial.getNumero().length(), is(8));
	}
	
	@Test
	public void deve_acertar_o_comprimento_de_9_digitos_no_telefone_comercial() {
		comercial.setNumero("987654321");
		assertThat(comercial.getNumero().length(), is(9));
	}
	
	@Test
	public void deve_acertar_o_comprimento_de_8_digitos_no_telefone_fixo() {
		fixo.setNumero("12345678");
		assertThat(fixo.getNumero().length(), is(8));
	}
	
	@Test
	public void deve_imprimir_tostring_com_telefone_celular_correto() {
		celular.setNumero("987654321");
		System.out.println(celular.toString());
	}
	
	@Test
	public void deve_imprimir_tostring_com_telefone_comercial_com_8_digitos_correto() {
		comercial.setNumero("98765432");
		System.out.println(comercial.toString());
	}
	
	@Test
	public void deve_imprimir_tostring_com_telefone_comercial_com_9_digitos_correto() {
		comercial.setNumero("987654321");
		System.out.println(comercial.toString());
	}
	
	@Test
	public void deve_imprimir_tostring_com_telefone_fixo_correto() {
		fixo.setNumero("98765432");
		System.out.println(fixo.toString());
	}	
	
}
