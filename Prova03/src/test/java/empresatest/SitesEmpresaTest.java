package empresatest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.contmatic.empresa.SitesEmpresa;

public class SitesEmpresaTest {

	@Test
	public void deve_aceitar_site_nulo() {
		
	}
	
	@Test
	public void deve_aceitar_site_vazio() {

	}
	
	@Test
	public void deve_aceitar_site_com_apenas_espacos_em_branco() {

	}
	
	@Test
	public void deve_aceitar_site_valido() {

	}
	
	@Test
	public void deve_aceitar_site_com_quantidade_maxima_de_caracteres() {

	}
	
	@Test
	public void nao_deve_aceitar_site_com_mais_que_o_maximo_de_caracteres() {

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
