package br.com.contmatic.empresa.enderecotest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.empresa.endereco.TIPODEENDERECO;

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
		assertThat(residencial.getTipo(), is("Endereco Residencial"));
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
	 * Deve imprimir tostring para tipo residencial.
	 */
	@Test
	public void deve_imprimir_tostring_para_tipo_residencial() {
		TIPODEENDERECO residencial = TIPODEENDERECO.ENDERECORESIDENCIAL;
		assertThat(residencial.toString(), containsString("ENDERECORESIDENCIAL"));
	}
	
	/**
	 * Deve imprimir tostring para tipo comercial.
	 */
	@Test
	public void deve_imprimir_tostring_para_tipo_comercial() {
		TIPODEENDERECO comercial = TIPODEENDERECO.ENDERECOCOMERCIAL;
		assertThat(comercial.toString(), containsString("ENDERECOCOMERCIAL"));
	}
	
}
