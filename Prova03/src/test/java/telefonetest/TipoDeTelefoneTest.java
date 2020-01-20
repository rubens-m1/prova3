package telefonetest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.telefone.TIPODETELEFONE;

/**
 * The Class TipoDeTelefoneTest.
 */
public class TipoDeTelefoneTest {

	/** The fixo. */
	private TIPODETELEFONE fixo;

	/** The celular. */
	private TIPODETELEFONE celular;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		fixo = TIPODETELEFONE.TELEFONEFIXO;
		celular = TIPODETELEFONE.TELEFONECELULAR;
	}

	/**
	 * Deve acertar que tipo de telefone fixo nao esta nulo.
	 */
	@Test
	public void deve_acertar_que_tipo_de_telefone_fixo_nao_esta_nulo() {
		assertNotNull(fixo);
	}

	/**
	 * Deve acertar que tipo de telefone celular nao esta nulo.
	 */
	@Test
	public void deve_acertar_que_tipo_de_telefone_celular_nao_esta_nulo() {
		assertNotNull(celular);
	}

	/**
	 * Deve acertar o get tipo fixo.
	 */
	@Test
	public void deve_acertar_o_get_tipo_fixo() {
		assertThat(fixo.getNumero(), is("[1-9][0-9]{7}"));
	}

	/**
	 * Deve acertar o get tipo celular.
	 */
	@Test
	public void deve_acertar_o_get_tipo_celular() {
		assertThat(celular.getNumero(), is("9[0-9]{8}"));
	}

	/**
	 * Test do to string fixo.
	 */
	@Test
	public void test_do_to_string_fixo() {
		assertTrue(fixo.toString().contains("TELEFONEFIXO"));
	}

	/**
	 * Test do to string celular.
	 */
	@Test
	public void test_do_to_string_celular() {
		assertTrue(celular.toString().contains("TELEFONECELULAR"));
	}

}
