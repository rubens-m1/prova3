package empresatest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.SitesEmpresa;
import util.Utilidades;

public class SitesEmpresaTest {
	
	private SitesEmpresa site;
	
	@Before
	public void init() {
		site = new SitesEmpresa();
	}

	@Test
	public void deve_aceitar_site_com_url_nula() {
		site.setUrl(null);
		assertNull(site.getUrl());
	}
	
	@Test
	public void deve_aceitar_site_vazio() {
		site.setUrl("");
		assertTrue(site.getUrl().equals(""));
	}
	
	@Test
	public void deve_aceitar_site_com_apenas_espacos_em_branco() {
		site.setUrl("       ");
		assertTrue(site.getUrl().equals("       "));
	}
	
	@Test
	public void deve_aceitar_site_valido() {
		site.setUrl("www.seila.com.br");
		assertTrue(Utilidades.isValid(site, "www.seila.com.br"));
	}
	
	@Test
	public void deve_aceitar_site_valido_com_numeros() {
		site.setUrl("www.seila1.com.br");
		assertTrue(Utilidades.isValid(site, "www.seila1.com.br"));
	}
	
	@Test
	public void deve_aceitar_site_valido_caracteres_especiais() {
		site.setUrl("www.seila!@#$%¨&*().com.br");
		assertTrue(Utilidades.isValid(site, "www.seila!@#$%¨&*().com.br"));
	}
	
	@Test
	public void deve_aceitar_site_com_quantidade_maxima_de_caracteres() {
		site.setUrl("www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com.br");
		assertTrue(Utilidades.isValid(site, "www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com.br"));
	}
	
	@Test
	public void nao_deve_aceitar_site_com_mais_que_o_maximo_de_caracteres() {
		site.setUrl("www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com.brr");
		assertFalse(Utilidades.isValid(site, "Url deve ter número de caracteres entre 1 a 255"));
	}
	
	@Test
	public void nao_deve_aceitar_site_com_menos_que_o_minimo_de_caracteres() {
		site.setUrl("www");
		assertFalse(Utilidades.isValid(site, "Url deve ter número de caracteres entre 1 a 255"));
	}
	
	@Test
	public void deve_fazer_tostring_de_site_valido() {
		site.setUrl("www.123.com.br");
		assertThat(site.toString(), containsString("www.123.com.br"));
	}
	
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(SitesEmpresa.class, hasValidGettersAndSetters());
	}

	@Test
	public void deve_respeitar_hash_code() {
		assertThat(SitesEmpresa.class, hasValidBeanHashCode());
	}

	@Test
	public void deve_respeitar_equals() {
		assertThat(SitesEmpresa.class, hasValidBeanEquals());
	}

}
