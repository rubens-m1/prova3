package telefonetest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.telefone.TIPODETELEFONE;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDeTelefoneTest.
 */
public class TipoDeTelefoneTest {

	/** The comercial. */
	private TIPODETELEFONE comercial;
	
	/** The fixo. */
	private TIPODETELEFONE fixo;
	
	/** The celular. */
	private TIPODETELEFONE celular;
	
	/** The validator. */
	private Validator validator;
	
	/** The factory. */
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		comercial = TIPODETELEFONE.TELEFONECOMERCIAL;
		fixo = TIPODETELEFONE.TELEFONEFIXO;
		celular = TIPODETELEFONE.TELEFONECELULAR;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param comercial the comercial
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
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

	/**
	 * Nao deve aceitar telefone comercial nulo.
	 */
	@Test
	public void nao_deve_aceitar_telefone_comercial_nulo() {
		comercial.setNumero(null);
		assertFalse(isValid(comercial, "numero de telefone em branco"));
	}
	
	/**
	 * Nao deve aceitar telefone fixo nulo.
	 */
	@Test
	public void nao_deve_aceitar_telefone_fixo_nulo() {
		fixo.setNumero(null);
		assertFalse(isValid(fixo, "numero de telefone em branco"));
	}
	
	/**
	 * Nao deve aceitar telefone celular nulo.
	 */
	@Test
	public void nao_deve_aceitar_telefone_celular_nulo() {
		celular.setNumero(null);
		assertFalse(isValid(celular, "numero de telefone em branco"));
	}
	
	/**
	 * Nao deve aceitar telefone vazio celular.
	 */
	@Test
	public void nao_deve_aceitar_telefone_vazio_celular() {
		celular.setNumero("");
		assertFalse(isValid(celular, "numero de telefone em branco"));
	}
	
	/**
	 * Nao deve aceitar telefone vazio comercial.
	 */
	@Test
	public void nao_deve_aceitar_telefone_vazio_comercial() {
		comercial.setNumero("");
		assertFalse(isValid(comercial, "numero de telefone em branco"));
	}
	
	/**
	 * Nao deve aceitar telefone vazio fixo.
	 */
	@Test
	public void nao_deve_aceitar_telefone_vazio_fixo() {
		fixo.setNumero("");
		assertFalse(isValid(fixo, "numero de telefone em branco"));
	}
	
	/**
	 * Deve aceitar telefone correto celular.
	 */
	@Test
	public void deve_aceitar_telefone_correto_celular() {
		celular.setNumero("987654321");
		assertTrue(isValid(celular, "987654321"));
	
	}
	
	/**
	 * Deve aceitar telefone correto celular com traco.
	 */
	@Test
	public void deve_aceitar_telefone_correto_celular_com_traco() {
		celular.setNumero("98765-4321");
		assertTrue(isValid(celular, "98765-4321"));
	}
	
	/**
	 * Deve aceitar telefone correto com 8 digitos comercial.
	 */
	@Test
	public void deve_aceitar_telefone_correto_com_8_digitos_comercial() {
		comercial.setNumero("98765432");
		assertTrue(isValid(comercial, "98765432"));
	}
	
	/**
	 * Deve aceitar telefone correto com 8 digitos comercial com traco.
	 */
	@Test
	public void deve_aceitar_telefone_correto_com_8_digitos_comercial_com_traco() {
		comercial.setNumero("9876-5432");
		assertTrue(isValid(comercial, "9876-5432"));
	}

	/**
	 * Deve aceitar telefone correto com 9 digitos comercial.
	 */
	@Test
	public void deve_aceitar_telefone_correto_com_9_digitos_comercial() {
		comercial.setNumero("987654321");
		assertTrue(isValid(comercial, "987654321"));
	}
	
	/**
	 * Deve aceitar telefone correto com 9 digitos comercial com traço.
	 */
	@Test
	public void deve_aceitar_telefone_correto_com_9_digitos_comercial_com_traço() {
		comercial.setNumero("98765-4321");
		assertTrue(isValid(comercial, "98765-4321"));
	}
	
	/**
	 * Deve aceitar telefone correto fixo.
	 */
	@Test
	public void deve_aceitar_telefone_correto_fixo() {
		fixo.setNumero("55555555");
		assertTrue(isValid(fixo, "55555555"));
	}
	
	/**
	 * Deve aceitar telefone correto fixo com traco.
	 */
	@Test
	public void deve_aceitar_telefone_correto_fixo_com_traco() {
		fixo.setNumero("5555-5555");
		assertTrue(isValid(fixo, "5555-5555"));
	}
	
	/**
	 * Nao deve aceitar telefone celular com menos de 9 digitos.
	 */
	@Test
	public void nao_deve_aceitar_telefone_celular_com_menos_de_9_digitos() {
		fail();
//		celular.setNumero("98765432");
//		assertFalse(isValid(celular, ""));
	}
	
	/**
	 * Nao deve aceitar telefone comercial com menos de 8 digitos.
	 */
	@Test
	public void nao_deve_aceitar_telefone_comercial_com_menos_de_8_digitos() {
		comercial.setNumero("9876543");
		assertFalse(isValid(comercial, "formato de telefone invalido"));
	}
	
	/**
	 * Nao deve aceitar telefone fixo com menos de 8 digitos.
	 */
	@Test
	public void nao_deve_aceitar_telefone_fixo_com_menos_de_8_digitos() {
		fixo.setNumero("9876543");
		assertFalse(isValid(fixo, "formato de telefone invalido"));
	}
	
	/**
	 * Nao deve aceitar telefone celular com mais de 9 digitos.
	 */
	@Test
	public void nao_deve_aceitar_telefone_celular_com_mais_de_9_digitos() {
		celular.setNumero("9876543210");
		assertFalse(isValid(celular, "formato de telefone invalido"));
	}
	
	/**
	 * Nao deve aceitar telefone comercial com mais de 9 digitos.
	 */
	@Test
	public void nao_deve_aceitar_telefone_comercial_com_mais_de_9_digitos() {
		comercial.setNumero("9876543210");
		assertFalse(isValid(comercial, "formato de telefone invalido"));
	}
	
	/**
	 * Nao deve aceitar telefone fixo com mais de 8 digitos.
	 */
	@Test
	public void nao_deve_aceitar_telefone_fixo_com_mais_de_8_digitos() {
		fail();
//		fixo.setNumero("987654321");
//		assertFalse(isValid(fixo, "formato de telefone invalido"));
	}
	
	/**
	 * Deve acertar o comprimento de 9 digitos no telefone celular.
	 */
	@Test
	public void deve_acertar_o_comprimento_de_9_digitos_no_telefone_celular() {
		celular.setNumero("987654321");
		assertThat(celular.getNumero().length(), is(9));
	}

	/**
	 * Deve acertar o comprimento de 8 digitos no telefone comercial.
	 */
	@Test
	public void deve_acertar_o_comprimento_de_8_digitos_no_telefone_comercial() {
		comercial.setNumero("12345678");
		assertThat(comercial.getNumero().length(), is(8));
	}
	
	/**
	 * Deve acertar o comprimento de 9 digitos no telefone comercial.
	 */
	@Test
	public void deve_acertar_o_comprimento_de_9_digitos_no_telefone_comercial() {
		comercial.setNumero("987654321");
		assertThat(comercial.getNumero().length(), is(9));
	}
	
	/**
	 * Deve acertar o comprimento de 8 digitos no telefone fixo.
	 */
	@Test
	public void deve_acertar_o_comprimento_de_8_digitos_no_telefone_fixo() {
		fixo.setNumero("12345678");
		assertThat(fixo.getNumero().length(), is(8));
	}
	
	/**
	 * Deve imprimir tostring com telefone celular correto.
	 */
	@Test
	public void deve_imprimir_tostring_com_telefone_celular_correto() {
		celular.setNumero("987654321");
		System.out.println(celular.toString());
	}
	
	/**
	 * Deve imprimir tostring com telefone comercial com 8 digitos correto.
	 */
	@Test
	public void deve_imprimir_tostring_com_telefone_comercial_com_8_digitos_correto() {
		comercial.setNumero("98765432");
		System.out.println(comercial.toString());
	}
	
	/**
	 * Deve imprimir tostring com telefone comercial com 9 digitos correto.
	 */
	@Test
	public void deve_imprimir_tostring_com_telefone_comercial_com_9_digitos_correto() {
		comercial.setNumero("987654321");
		System.out.println(comercial.toString());
	}
	
	/**
	 * Test do to string.
	 */
	@Test
	public void test_do_to_string() {
		fixo.setNumero("98765432");
		assertTrue(fixo.toString().contains("98765432"));
	}	
	
}
