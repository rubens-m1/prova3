package empresatest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.framework;
import static util.Utilidades.isValid;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.FixtureEmpresa;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.DDD;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

public class EmpresaTest {
	
	private Empresa empresa;
	
	private Endereco endereco;
	
	private Endereco endereco2;
	
	private Telefone telefone;
	
	private Telefone telefone2;
	
	private Funcionario funcionario;
	
	private Funcionario funcionario2;
	
	private Set<Endereco> enderecos = new HashSet<>();
	
	private Set<Telefone> telefones = new HashSet<>();
	
	private Set<Funcionario> funcionarios = new HashSet<>();
	
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
		telefone2 = Fixture.from(Telefone.class).gimme("valido");
		endereco = new Endereco();
		endereco2 = new Endereco();
		funcionario = new Funcionario();
		funcionario2 = new Funcionario();
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
		fail();
		//empresa.setCnpj(null);
		//assertFalse(isValid(empresa, "CNPJ nao pode conter apenas espacos, estar vazio ou nulo"));
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
	public void deve_aceitar_empresa_com_razao_social_valida() {
		empresa.setRazaoSocial("Empresa 123");
		assertTrue(isValid(empresa, "Empresa 123"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_razao_social_valida_com_caracteres_especiais() {
		empresa.setRazaoSocial("Empresa !@#$%¨&*()_+");
		assertTrue(isValid(empresa, "Empresa !@#$%¨&*()_+"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_nula() {
		empresa.setRazaoSocial(null);
		assertFalse(isValid(empresa, "Razão social não pode conter apenas espacos, estar vazio ou nula"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_vazia() {
		empresa.setRazaoSocial("");
		assertFalse(isValid(empresa, "Razão social não pode conter apenas espacos, estar vazia ou nula"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_em_branco() {
		empresa.setRazaoSocial(" 			");
		assertFalse(isValid(empresa, "Razão social não pode conter apenas espacos, estar vazia ou nula"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_razao_social_nula() {
		empresa.setRazaoSocial(null);
		assertTrue(empresa.getRazaoSocial().equals(null));
	}
	
	@Test
	public void deve_aceitar_empresa_com_razao_social_vazia() {
		empresa.setRazaoSocial("");
		assertTrue(isValid(empresa, ""));
	}
	
	@Test
	public void deve_aceitar_empresa_com_razao_social_em_branco() {
		empresa.setRazaoSocial("   			");
		assertTrue(isValid(empresa, "   			"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_razao_social_com_1_caractere() {
		empresa.setRazaoSocial("a");
		assertTrue(isValid(empresa, "a"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_razao_social_com_100_caracteres() {
		empresa.setRazaoSocial("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		assertTrue(isValid(empresa, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_com_mais_de_100_caracteres() {
		empresa.setRazaoSocial("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		assertFalse(isValid(empresa, "Razão social deve ter de 1 a 100 caracteres"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_nome_fantasia_com_1_caractere() {
		empresa.setNomeFantasia("a");
		assertTrue(isValid(empresa, "a"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_nome_fantasia_com_100_caracteres() {
		empresa.setNomeFantasia("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		assertTrue(isValid(empresa, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_nome_fantasia_com_mais_de_100_caracteres() {
		empresa.setNomeFantasia("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		assertFalse(isValid(empresa, "Nome Fantasia deve ter de 1 a 100 caracteres"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_endereco_nulo() {
		empresa.setEndereco(null);
		assertFalse(isValid(empresa, "Endereço não pode ser nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_endereco_vazio() {
		empresa.setEndereco(new HashSet<Endereco>());
		assertFalse(isValid(empresa, "A lista de endereço está vazia"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_endereco_valido() {
		assertTrue(isValid(empresa, empresa.getEndereco().toString()));
	}
	
	@Test
	public void deve_acertar_empresa_com_enderecos_iguais_e_so_um_endereco() {
		endereco.setCep("01507001");
		endereco.setNumero("123");

		endereco2.setCep("01507001");
		endereco2.setNumero("123");

		enderecos.add(endereco);
		enderecos.add(endereco2);

		empresa.setEndereco(enderecos);
		assertThat(empresa.getEndereco().size(), is(1));
	}
	
	@Test
	public void deve_aceitar_empresa_com_dois_enderecos_diferentes() {
		endereco.setCep("12345678");
		endereco.setNumero("123");

		endereco2.setCep("01507001");
		endereco2.setNumero("124");

		enderecos.add(endereco);
		enderecos.add(endereco2);

		empresa.setEndereco(enderecos);
		assertThat(empresa.getEndereco().size(), is(2));
	}
	
	@Test
	public void deve_aceitar_empresa_com_dois_enderecos_com_mesmo_cep_e_numeros_diferentes() {
		endereco.setCep("01507001");
		endereco.setNumero("123");

		endereco2.setCep("01507001");
		endereco2.setNumero("124");

		enderecos.add(endereco);
		enderecos.add(endereco2);

		empresa.setEndereco(enderecos);
		assertThat(empresa.getEndereco().size(), is(2));
	}
	
	@Test
	public void deve_aceitar_empresa_com_dois_enderecos_com_cep_diferentes_e_mesmo_numero() {
		endereco.setCep("01507001");
		endereco.setNumero("123");

		endereco2.setCep("01507001");
		endereco2.setNumero("124");

		enderecos.add(endereco);
		enderecos.add(endereco2);

		empresa.setEndereco(enderecos);
		assertThat(empresa.getEndereco().size(), is(2));
	}
	
	
	@Test
	public void nao_deve_aceitar_empresa_com_mais_de_100_enderecos() {
		for (int i = 0; i < 110; i++) {
			endereco.setCep("08588145");
			endereco.setNumero(Integer.toString(i));
			enderecos.add(endereco);
		}
		empresa.setEndereco(enderecos);
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 enderecos"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_telefone_nulo() {
		empresa.setTelefone(null);
		assertFalse(isValid(empresa, "Telefone não pode ser nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_telefone_vazio() {
		empresa.setTelefone(new HashSet<Telefone>());
		assertFalse(isValid(empresa, "A lista de telefone esta vazia"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_telefone_valido() {
		assertTrue(isValid(empresa, empresa.getTelefone().toString()));
	}
	
	@Test
	public void deve_acertar_empresa_com_telefones_iguais_e_so_um_telefone() {
		telefone.setDdd(DDD.DDD11);
		telefone.setNumero("999999999");
		telefone.setRamal("1");

		telefone2.setDdd(DDD.DDD11);
		telefone2.setNumero("999999999");
		telefone2.setRamal("1");

		telefones.add(telefone);
		telefones.add(telefone2);

		empresa.setTelefone(telefones);
		assertThat(empresa.getTelefone().size(), is(1));
	}
	
	@Test
	public void deve_aceitar_empresa_com_dois_telefones_diferentes() {
		telefone.setDdd(DDD.DDD11);
		telefone.setNumero("999999999");
		telefone.setRamal("1");

		telefone2.setDdd(DDD.DDD11);
		telefone2.setNumero("999999998");
		telefone2.setRamal("1");

		telefones.add(telefone);
		telefones.add(telefone2);

		empresa.setTelefone(telefones);
		assertThat(empresa.getTelefone().size(), is(2));
	}
	
	@Test
	public void deve_aceitar_empresa_com_dois_telefones_com_mesmo_numero_e_ramal_diferente() {
		telefone.setDdd(DDD.DDD11);
		telefone.setNumero("999999999");
		telefone.setRamal("1");

		telefone2.setDdd(DDD.DDD11);
		telefone2.setNumero("999999998");
		telefone2.setRamal("2");

		telefones.add(telefone);
		telefones.add(telefone2);

		empresa.setTelefone(telefones);
		assertThat(empresa.getTelefone().size(), is(2));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_mais_de_100_telefones() {
		for (int i = 0; i < 110; i++) {
			telefone.setRamal(Integer.toString(i));
			telefones.add(telefone);
		}
		empresa.setTelefone(telefones);
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 telefones"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_funcionario_nulo() {
		empresa.setFuncionario(null);
		assertFalse(isValid(empresa, "Funcionario não pode ser nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_funcionario_vazio() {
		empresa.setFuncionario(new HashSet<Funcionario>());
		assertFalse(isValid(empresa, "A lista de funcionarios esta vazia"));
	}
	
	@Test
	public void deve_aceitar_empresa_com_funcionario_valido() {
		assertTrue(isValid(empresa, empresa.getFuncionario().toString()));
	}
	
	@Test
	public void deve_acertar_empresa_com_funcionarios_iguais_e_so_um_funcionario() {
		funcionario.setCpf("34501799005");
		
		funcionario2.setCpf("34501799005");

		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);

		empresa.setFuncionario(funcionarios);
		assertThat(empresa.getFuncionario().size(), is(1));
	}
	
	@Test
	public void deve_aceitar_empresa_com_dois_funcioarios_diferentes() {
		funcionario.setCpf("34501799005");
		
		funcionario2.setCpf("98958869003");

		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);

		empresa.setFuncionario(funcionarios);
		assertThat(empresa.getFuncionario().size(), is(2));
	}
	
	@Test
	public void nao_deve_aceitar_empresa_com_mais_de_100_funcionarios() {
		for (int i = 0; i < 110; i++) {
			funcionario.setCpf(Integer.toString(i));
			funcionarios.add(funcionario);
		}
		empresa.setFuncionario(funcionarios);
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 funcionarios"));
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
