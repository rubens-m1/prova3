package br.com.contmatic.empresatest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.SitesEmpresa;
import br.com.contmatic.empresa.utiltest.Utilidades;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class SitesEmpresaTest.
 */
public class SitesEmpresaTest {
	
	/** The site. */
	private SitesEmpresa site;
	
	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		site = new SitesEmpresa();
	}

	/**
	 * Deve aceitar site com url nula.
	 */
	@Test
	public void deve_aceitar_site_com_url_nula() {
		site.setUrl(null);
		assertNull(site.getUrl());
	}
	
	/**
	 * Deve aceitar site vazio.
	 */
	@Test
	public void deve_aceitar_site_vazio() {
		site.setUrl("");
		assertTrue(site.getUrl().equals(""));
	}
	
	/**
	 * Deve aceitar site com apenas espacos em branco.
	 */
	@Test
	public void deve_aceitar_site_com_apenas_espacos_em_branco() {
		site.setUrl("       ");
		assertTrue(site.getUrl().equals("       "));
	}
	
	/**
	 * Deve aceitar site valido.
	 */
	@Test
	public void deve_aceitar_site_valido() {
		site.setUrl("www.seila.com.br");
		assertTrue(Utilidades.isValid(site, "www.seila.com.br"));
	}
	
	/**
	 * Deve aceitar site valido com numeros.
	 */
	@Test
	public void deve_aceitar_site_valido_com_numeros() {
		site.setUrl("www.seila1.com.br");
		assertTrue(Utilidades.isValid(site, "www.seila1.com.br"));
	}
	
	/**
	 * Deve aceitar site valido caracteres especiais.
	 */
	@Test
	public void deve_aceitar_site_valido_caracteres_especiais() {
		site.setUrl("www.seila!@#$%¨&*().com.br");
		assertTrue(Utilidades.isValid(site, "www.seila!@#$%¨&*().com.br"));
	}
	
	/**
	 * Deve aceitar site com quantidade maxima de caracteres.
	 */
	@Test
	public void deve_aceitar_site_com_quantidade_maxima_de_caracteres() {
		site.setUrl("www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com.br");
		assertTrue(Utilidades.isValid(site, "www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com.br"));
	}
	
	/**
	 * Nao deve aceitar site com mais que o maximo de caracteres.
	 */
	@Test
	public void nao_deve_aceitar_site_com_mais_que_o_maximo_de_caracteres() {
		site.setUrl("www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com.brr");
		assertFalse(Utilidades.isValid(site, "Url deve ter número de caracteres entre 1 a 255"));
	}
	
	/**
	 * Nao deve aceitar site com menos que o minimo de caracteres.
	 */
	@Test
	public void nao_deve_aceitar_site_com_menos_que_o_minimo_de_caracteres() {
		site.setUrl("www");
		assertFalse(Utilidades.isValid(site, "Url deve ter número de caracteres entre 1 a 255"));
	}
	
	/**
	 * Deve fazer tostring de site valido.
	 */
	@Test
	public void deve_fazer_tostring_de_site_valido() {
		site.setUrl("www.123.com.br");
		assertThat(site.toString(), containsString("www.123.com.br"));
	}
	
	/**
	 * Deve respeitar os gets sets.
	 */
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(SitesEmpresa.class, hasValidGettersAndSetters());
	}

    /**
     * Deve respeitar equals hash code.
     */
    @Test
    public void deve_respeitar_equals_hashCode() {
        EqualsVerifier.forClass(SitesEmpresa.class).withOnlyTheseFields("url").suppress(Warning.NONFINAL_FIELDS).verify();
    }

}
