package enderecotest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.contmatic.empresa.endereco.TIPODEENDERECO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDeEnderecoTest.
 */
public class TipoDeEnderecoTest {

	/**
	 * Deve aceitar tipo residencial valido.
	 */
	@Test
	public void deve_aceitar_tipo_residencial_valido() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		assertTrue(residencial.name().equals(TIPODEENDERECO.ENDERECORESIDENCIAL.name()));
	}
	
	/**
	 * Nao deve aceitar tipo residecial diferente do especificado.
	 */
	@Test
	public void nao_deve_aceitar_tipo_residecial_diferente_do_especificado() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		assertNotEquals(TIPODEENDERECO.ENDERECOCOMERCIAL.name(), residencial.name());
	}
	
	/**
	 * Nao deve aceitar tipo residencial nulo.
	 */
	@Test
	public void nao_deve_aceitar_tipo_residencial_nulo() {
		fail();
//		TIPODEENDERECO residencial = null;
//		residencial.setTipo(null);
//		assertFalse(isValid(residencial, "Tipo de Endereco nao pode ser nulo"));
	}
	
	/**
	 * Deve acertar que o tipo residencial e diferente de nulo.
	 */
	@Test
	public void deve_acertar_que_o_tipo_residencial_e_diferente_de_nulo() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		assertNotNull(residencial);
	}
	
	/**
	 * Deve aceitar tipo comercial valido.
	 */
	@Test
	public void deve_aceitar_tipo_comercial_valido() {
		TIPODEENDERECO comercial = TIPODEENDERECO.ENDERECOCOMERCIAL;
		assertTrue(comercial.name().equals(TIPODEENDERECO.ENDERECOCOMERCIAL.name()));
	}
	
	/**
	 * Nao deve aceitar tipo comercial diferente do especificado.
	 */
	@Test
	public void nao_deve_aceitar_tipo_comercial_diferente_do_especificado() {
		TIPODEENDERECO comercial = TIPODEENDERECO.ENDERECOCOMERCIAL;
		assertNotEquals(TIPODEENDERECO.ENDERECORESIDENCIAL.name(), comercial.name());
	}
	
	/**
	 * Nao deve aceitar tipo comercial nulo.
	 */
	@Test
	public void nao_deve_aceitar_tipo_comercial_nulo() {
		fail();
//		TIPODEENDERECO residencial = null;
//		residencial.setTipo(null);
//		assertFalse(isValid(residencial, "Tipo de Endereco nao pode ser nulo"));
	}
	
	/**
	 * Deve imprimir tostring para tipo residencial.
	 */
	@Test
	public void deve_imprimir_tostring_para_tipo_residencial() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		System.out.println(residencial.toString());
	}
	
	/**
	 * Deve imprimir tostring para tipo comercial.
	 */
	@Test
	public void deve_imprimir_tostring_para_tipo_comercial() {
		TIPODEENDERECO comercial = TIPODEENDERECO.ENDERECOCOMERCIAL;
		System.out.println(comercial.toString());
	}
	
}
