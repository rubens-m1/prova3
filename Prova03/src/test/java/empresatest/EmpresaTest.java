package empresatest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.framework;
import static util.Utilidades.isValid;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.FixtureEmpresa;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

public class EmpresaTest {
	
	private Empresa empresa;
	
	private Endereco endereco;
	
	private Telefone telefone;
	
	@BeforeClass
	public static void init() {
		Utilidades.reconhecerJodaTime();
		FixtureEmpresa.fakeEmpresa();
	}
	
	@Before
	public void init2() {	
		empresa = Fixture.from(Empresa.class).gimme("valido");
//		funcionario2 = Fixture.from(Funcionario.class).gimme("valido");
		endereco = Fixture.from(Endereco.class).gimme("valido");
		telefone = Fixture.from(Telefone.class).gimme("valido");
	}

	@Test
	public void deve_aceitar_empresa_valida() {
		System.out.println(empresa);
		fail();
	}
	
	@Test
	public void deve_aceitar_empresa_com_cnpj_valido() {
		empresa.setCnpj("74292317000185");
		assertTrue(isValid(empresa, "CNPJ invalido."));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_nulo() {
		empresa.setCnpj(null);
		assertFalse(isValid(empresa, "CNPJ nao pode conter apenas espacos, estar vazio ou nulo"));
		fail();
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_vazio() {
		empresa.setCnpj("");
		assertFalse(isValid(empresa, "CNPJ nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_em_branco() {
		empresa.setCnpj(" 			");
		assertFalse(isValid(empresa, "CNPJ nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_invalido() {
		empresa.setCnpj("04292317000180");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	@Test
	public void deve_aceitar_empresa_com_cnpj_valido_com_formatacao_certa() {
		empresa.setCnpj("74.292.317/0001-85");
		assertTrue(isValid(empresa, "74.292.317/0001-85"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_cnpj_valido_com_formatacao_errada() {
		empresa.setCnpj("74.292.3170001-85");
		assertTrue(isValid(empresa, "74.292.3170001-85"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_letras() {
		empresa.setCnpj("74.292.317/0001-8a");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_so_com_letras() {
		empresa.setCnpj("aaaaaaaaaaaaaa");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_outros_caracteres_especiais() {
		empresa.setCnpj("!@#$%¨&*)_");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_do_cnpj() {
		empresa.setCnpj("74292317000185");
		assertThat(empresa.getCnpj().length(), is(14));
	}
	
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_do_cnpj_com_formatacao() {
		empresa.setCnpj("74.292.317/0001-85");
		assertThat(empresa.getCnpj().length(), is(18));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_menos_de_14_digitos() {
		empresa.setCnpj("7429231700018");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_mais_de_14_digitos() {
		empresa.setCnpj("742923170001812");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Empresa.class, hasValidGettersAndSetters());
	}
	
	@Test
	public void deve_respeitar_hash_code() {
		assertThat(Empresa.class, BeanMatchers.hasValidBeanHashCode());
	}

	@Test
	public void deve_respeitar_equals() {
		assertThat(Empresa.class, BeanMatchers.hasValidBeanEquals());
	}

}
