package br.com.contmatic.empresatest;

import static br.com.contmatic.empresa.utiltest.Utilidades.isValid;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.SitesEmpresa;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.fixtures.FixtureEmpresa;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.DDD;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.contmatic.empresa.utiltest.Utilidades;
import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {
	
	/** The empresa. */
	private Empresa empresa;
	
	/** The endereco. */
	private Endereco endereco;
	
	/** The endereco 2. */
	private Endereco endereco2;
	
	/** The telefone. */
	private Telefone telefone;
	
	/** The telefone 2. */
	private Telefone telefone2;
	
	/** The funcionario. */
	private Funcionario funcionario;
	
	/** The funcionario 2. */
	private Funcionario funcionario2;
	
	/** The email. */
	private Email email;
		
	/** The site. */
	private SitesEmpresa site;
	
	/** The enderecos. */
	private Set<Endereco> enderecos = new HashSet<>();
	
	/** The telefones. */
	private Set<Telefone> telefones = new HashSet<>();
	
	/** The funcionarios. */
	private Set<Funcionario> funcionarios = new HashSet<>();
	
	/** The emails. */
	private Set<Email> emails = new HashSet<>();
	
	/** The sites. */
	private Set<SitesEmpresa> sites = new HashSet<>();
	
	/**
	 * Inits the.
	 */
	@BeforeClass
	public static void init() {
		Utilidades.reconhecerJodaTime();
		FixtureEmpresa.fakeEmpresa();
	}
	
	/**
	 * Inits the 2.
	 */
	@Before
	public void init2() {	
		empresa = Fixture.from(Empresa.class).gimme("valido");
		endereco = Fixture.from(Endereco.class).gimme("valido");
		endereco2 = Fixture.from(Endereco.class).gimme("valido");
		telefone = Fixture.from(Telefone.class).gimme("valido");
		telefone2 = Fixture.from(Telefone.class).gimme("valido");
		funcionario = Fixture.from(Funcionario.class).gimme("valido");
		funcionario2 = Fixture.from(Funcionario.class).gimme("valido");
		email = Fixture.from(Email.class).gimme("valido");
		site = Fixture.from(SitesEmpresa.class).gimme("valido");
	}

	/**
	 * Deve aceitar empresa valida.
	 */
	@Test
	public void deve_aceitar_empresa_valida() {
		assertTrue(isValid(empresa, empresa.toString()));
	}
	
	/**
	 * Deve aceitar empresa com cnpj valido.
	 */
	@Test
	public void deve_aceitar_empresa_com_cnpj_valido() {
		empresa.setCnpj("74292317000185");
		assertTrue(isValid(empresa, "CNPJ invalido."));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj nulo.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_nulo() {
		empresa.setCnpj(null);
		assertFalse(isValid(empresa, "CNPJ nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj vazio.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_vazio() {
		empresa.setCnpj("");
		assertFalse(isValid(empresa, "CNPJ nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj em branco.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_em_branco() {
		empresa.setCnpj(" 			");
		assertFalse(isValid(empresa, "CNPJ nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj invalido.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_invalido() {
		empresa.setCnpj("04292317000180");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	/**
	 * Deve aceitar empresa com cnpj valido com formatacao certa.
	 */
	@Test
	public void deve_aceitar_empresa_com_cnpj_valido_com_formatacao_certa() {
		empresa.setCnpj("74.292.317/0001-85");
		assertTrue(isValid(empresa, "74.292.317/0001-85"));
	}
	
	/**
	 * Deve aceitar empresa com cnpj valido com formatacao errada.
	 */
	@Test
	public void deve_aceitar_empresa_com_cnpj_valido_com_formatacao_errada() {
		empresa.setCnpj("74.292.3170001-85");
		assertTrue(isValid(empresa, "74.292.3170001-85"));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj com letras.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_letras() {
		empresa.setCnpj("74.292.317/0001-8a");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj so com letras.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_so_com_letras() {
		empresa.setCnpj("aaaaaaaaaaaaaa");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj com outros caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_outros_caracteres_especiais() {
		empresa.setCnpj("!@#$%¨&*)_");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	/**
	 * Deve acertar a quantidade de caracteres do cnpj.
	 */
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_do_cnpj() {
		empresa.setCnpj("74292317000185");
		assertEquals(14, empresa.getCnpj().length());
	}
	
	/**
	 * Deve acertar a quantidade de caracteres do cnpj com formatacao.
	 */
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_do_cnpj_com_formatacao() {
		empresa.setCnpj("74.292.317/0001-85");
		assertThat(empresa.getCnpj().length(), is(18));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj com menos de 14 digitos.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_menos_de_14_digitos() {
		empresa.setCnpj("7429231700018");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	/**
	 * Nao deve aceitar empresa com cnpj com mais de 14 digitos.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_cnpj_com_mais_de_14_digitos() {
		empresa.setCnpj("742923170001812");
		assertFalse(isValid(empresa, "CNPJ invalido."));
	}
	
	/**
	 * Deve aceitar empresa com razao social valida.
	 */
	@Test
	public void deve_aceitar_empresa_com_razao_social_valida() {
		empresa.setRazaoSocial("Empresa 123");
		assertTrue(isValid(empresa, "Empresa 123"));
	}
	
	/**
	 * Deve aceitar empresa com razao social valida com caracteres especiais.
	 */
	@Test
	public void deve_aceitar_empresa_com_razao_social_valida_com_caracteres_especiais() {
		empresa.setRazaoSocial("Empresa !@#$%¨&*()_+");
		assertTrue(isValid(empresa, "Empresa !@#$%¨&*()_+"));
	}
	
	/**
	 * Nao deve aceitar empresa com razao social nula.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_nula() {
		empresa.setRazaoSocial(null);
		assertFalse(isValid(empresa, "Razão social não pode conter apenas espacos, estar vazia ou nula"));
	}
	
	/**
	 * Nao deve aceitar empresa com razao social vazia.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_vazia() {
		empresa.setRazaoSocial("");
		assertFalse(isValid(empresa, "Razão social não pode conter apenas espacos, estar vazia ou nula"));
	}
	
	/**
	 * Nao deve aceitar empresa com razao social em branco.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_em_branco() {
		empresa.setRazaoSocial(" 			");
		assertFalse(isValid(empresa, "Razão social não pode conter apenas espacos, estar vazia ou nula"));
	}

	/**
	 * Deve aceitar empresa com razao social nula.
	 */
	@Test
	public void deve_aceitar_empresa_com_razao_social_nula() {
		empresa.setRazaoSocial(null);
		assertFalse(isValid(empresa, "Razão social não pode conter apenas espacos, estar vazia ou nula"));
	}
	
	/**
	 * Deve aceitar empresa com razao social vazia.
	 */
	@Test
	public void deve_aceitar_empresa_com_razao_social_vazia() {
		empresa.setRazaoSocial("");
		assertTrue(isValid(empresa, ""));
	}
	
	/**
	 * Deve aceitar empresa com razao social em branco.
	 */
	@Test
	public void deve_aceitar_empresa_com_razao_social_em_branco() {
		empresa.setRazaoSocial("   			");
		assertTrue(isValid(empresa, "   			"));
	}
	
	/**
	 * Deve aceitar empresa com razao social com 1 caractere.
	 */
	@Test
	public void deve_aceitar_empresa_com_razao_social_com_1_caractere() {
		empresa.setRazaoSocial("a");
		assertTrue(isValid(empresa, "a"));
	}
	
	/**
	 * Deve aceitar empresa com razao social com 100 caracteres.
	 */
	@Test
	public void deve_aceitar_empresa_com_razao_social_com_100_caracteres() {
		empresa.setRazaoSocial("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		assertTrue(isValid(empresa, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
	}
	
	/**
	 * Nao deve aceitar empresa com razao social com mais de 100 caracteres.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_razao_social_com_mais_de_100_caracteres() {
		empresa.setRazaoSocial("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		assertFalse(isValid(empresa, "Razão social deve ter de 1 a 100 caracteres"));
	}
	
	/**
	 * Deve aceitar empresa com nome fantasia com 1 caractere.
	 */
	@Test
	public void deve_aceitar_empresa_com_nome_fantasia_com_1_caractere() {
		empresa.setNomeFantasia("a");
		assertTrue(isValid(empresa, "a"));
	}
	
	/**
	 * Deve aceitar empresa com nome fantasia com 100 caracteres.
	 */
	@Test
	public void deve_aceitar_empresa_com_nome_fantasia_com_100_caracteres() {
		empresa.setNomeFantasia("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		assertTrue(isValid(empresa, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
	}
	
	/**
	 * Nao deve aceitar empresa com nome fantasia com mais de 100 caracteres.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_nome_fantasia_com_mais_de_100_caracteres() {
		empresa.setNomeFantasia("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		assertFalse(isValid(empresa, "Nome Fantasia deve ter de 1 a 100 caracteres"));
	}
	
	/**
	 * Nao deve aceitar empresa com endereco nulo.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_endereco_nulo() {
		empresa.setEndereco(null);
		assertFalse(isValid(empresa, "Endereço não pode ser nulo"));
	}
	
	/**
	 * Nao deve aceitar empresa com endereco vazio.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_endereco_vazio() {
		empresa.setEndereco(new HashSet<Endereco>());
		assertFalse(isValid(empresa, "A lista de endereço está vazia"));
	}
	
	/**
	 * Deve aceitar empresa com endereco valido.
	 */
	@Test
	public void deve_aceitar_empresa_com_endereco_valido() {
		assertTrue(isValid(empresa, empresa.getEndereco().toString()));
	}
	
	/**
	 * Deve acertar empresa com enderecos iguais e so um endereco.
	 */
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
	
	/**
	 * Deve acertar empresa com enderecos iguais e so um endereco test adicionar endereco guava.
	 */
	@Test
	public void deve_acertar_empresa_com_enderecos_iguais_e_so_um_endereco_test_adicionar_endereco_guava() {
		endereco.setCep("01507001");
		endereco.setNumero("123");

		endereco2.setCep("01507001");
		endereco2.setNumero("123");		
		
		empresa.getEndereco().clear();
		
		empresa.acicionarEndereco(endereco);
		empresa.acicionarEndereco(endereco2);
		assertEquals(1, empresa.getEndereco().size());
	}
	
	/**
	 * Deve aceitar empresa com dois enderecos diferentes.
	 */
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
	
	/**
	 * Deve aceitar empresa com dois enderecos com mesmo cep e numeros diferentes.
	 */
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
	
	/**
	 * Deve aceitar empresa com dois enderecos com cep diferentes e mesmo numero.
	 */
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
	
	/**
	 * Deve aceitar empresa com 100 enderecos.
	 */
	@Test
	public void deve_aceitar_empresa_com_100_enderecos() {
		for (int i = 0; i < 100; i++) {
			endereco.setCep("08588145");
			endereco.setNumero(Integer.toString(i));
			enderecos.add(endereco);
		}
		empresa.setEndereco(enderecos);
		assertTrue(isValid(empresa, empresa.getEndereco().toString()));
	}
	
	/**
	 * Deve acertar que empresa tem 100 enderecos.
	 */
	@Test
	public void deve_acertar_que_empresa_tem_100_enderecos() {
		for (int i = 0; i < 100; i++) {
			endereco.setCep("08588145");
			endereco.setNumero(Integer.toString(i));
			enderecos.add(endereco);
		}
		empresa.setEndereco(enderecos);
		assertThat(empresa.getEndereco().size(), is(100));
	}
	
	/**
	 * Nao deve aceitar empresa com mais de 100 enderecos.
	 */
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
	
	/**
	 * Nao deve aceitar empresa com telefone nulo.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_telefone_nulo() {
		empresa.setTelefone(null);
		assertFalse(isValid(empresa, "Telefone não pode ser nulo"));
	}
	
	/**
	 * Nao deve aceitar empresa com telefone vazio.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_telefone_vazio() {
		empresa.setTelefone(new HashSet<Telefone>());
		assertFalse(isValid(empresa, "A lista de telefone esta vazia"));
	}
	
	/**
	 * Deve aceitar empresa com telefone valido.
	 */
	@Test
	public void deve_aceitar_empresa_com_telefone_valido() {
		assertTrue(isValid(empresa, empresa.getTelefone().toString()));
	}
	
	/**
	 * Deve acertar empresa com telefones iguais e so um telefone.
	 */
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
	
	/**
	 * Deve aceitar empresa com dois telefones diferentes.
	 */
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
	
	/**
	 * Deve aceitar empresa com dois telefones com mesmo numero e ramal diferente.
	 */
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
	
	/**
	 * Deve aceitar empresa com 100 telefones.
	 */
	@Test
	public void deve_aceitar_empresa_com_100_telefones() {
		for (int i = 0; i < 100; i++) {
			telefone.setRamal(Integer.toString(i));
			telefones.add(telefone);
		}
		empresa.setTelefone(telefones);
		assertTrue(isValid(empresa, empresa.getTelefone().toString()));
	}
	
	/**
	 * Deve acertar que empresa tem 100 telefones.
	 */
	@Test
	public void deve_acertar_que_empresa_tem_100_telefones() {
		for (int i = 0; i < 100; i++) {
			telefone.setRamal(Integer.toString(i));
			telefones.add(telefone);
		}
		empresa.setTelefone(telefones);
		assertThat(empresa.getTelefone().size(), is(100));
	}
	
	/**
	 * Nao deve aceitar empresa com mais de 100 telefones.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_mais_de_100_telefones() {
		for (int i = 0; i < 110; i++) {
			telefone.setRamal(Integer.toString(i));
			telefones.add(telefone);
		}
		empresa.setTelefone(telefones);
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 telefones"));
	}
	
	/**
	 * Nao deve aceitar empresa com funcionario nulo.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_funcionario_nulo() {
		empresa.setFuncionario(null);
		assertFalse(isValid(empresa, "Funcionario não pode ser nulo"));
	}
	
	/**
	 * Nao deve aceitar empresa com funcionario vazio.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_funcionario_vazio() {
		empresa.setFuncionario(new HashSet<Funcionario>());
		assertFalse(isValid(empresa, "A lista de funcionarios esta vazia"));
	}
	
	/**
	 * Deve aceitar empresa com funcionario valido.
	 */
	@Test
	public void deve_aceitar_empresa_com_funcionario_valido() {
		assertTrue(isValid(empresa, empresa.getFuncionario().toString()));
	}
	
	/**
	 * Deve acertar empresa com funcionarios iguais e so um funcionario.
	 */
	@Test
	public void deve_acertar_empresa_com_funcionarios_iguais_e_so_um_funcionario() {
		funcionario.setCpf("34501799005");
		
		funcionario2.setCpf("34501799005");

		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);

		empresa.setFuncionario(funcionarios);
		assertThat(empresa.getFuncionario().size(), is(1));
	}
	
	/**
	 * Deve aceitar empresa com dois funcioarios diferentes.
	 */
	@Test
	public void deve_aceitar_empresa_com_dois_funcioarios_diferentes() {
		funcionario.setCpf("34501799005");
		
		funcionario2.setCpf("98958869003");

		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);

		empresa.setFuncionario(funcionarios);
		assertThat(empresa.getFuncionario().size(), is(2));
	}
	
	/**
	 * Deve aceitar empresa com 100 funcionarios.
	 */
	@Test
	public void deve_aceitar_empresa_com_100_funcionarios() {
		for (int i = 0; i < 110; i++) {
			funcionario.setCpf(Integer.toString(i));
			funcionarios.add(funcionario);
		}
		empresa.setFuncionario(funcionarios);
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 funcionarios"));
	}
	
	/**
	 * Nao deve aceitar empresa com mais de 100 funcionarios.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_mais_de_100_funcionarios() {
		for (int i = 0; i < 110; i++) {
			funcionario.setCpf(Integer.toString(i));
			funcionarios.add(funcionario);
		}
		empresa.setFuncionario(funcionarios);
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 funcionarios"));
	}
	
	/**
	 * Nao deve aceitar empresa com email nulo.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_email_nulo() {
		empresa.setEmailEmpresa(null);
		assertFalse(isValid(empresa, "E-mail não pode ser nulo"));
	}
	
	/**
	 * Nao deve aceitar empresa com lista de emails vazia.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_lista_de_emails_vazia() {
		empresa.setEmailEmpresa(new HashSet<Email>());
		assertFalse(isValid(empresa, "A lista de e-mails deve conter pelo menos um email"));
	}
	
	/**
	 * Deve aceitar empresa com um email.
	 */
	@Test
	public void deve_aceitar_empresa_com_um_email() {
		assertTrue(isValid(empresa, "abc@abc.com"));
	}
	
	/**
	 * Deve aceitar empresa com 100 emails.
	 */
	@Test
	public void deve_aceitar_empresa_com_100_emails() {
		for (int i = 0; i < 100; i++) {
			email.setEmail(Integer.toString(i)+"@seila.com");
			email.setFuncionario(funcionario);
			emails.add(email);
		}
		empresa.setEmailEmpresa(emails);
		assertThat(empresa.getEmailEmpresa().size(), is(100));
	}
	
	/**
	 * Nao deve aceitar empresa com mais de 100 emails.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_mais_de_100_emails() {
		for (int i = 0; i < 110; i++) {
			email.setEmail(Integer.toString(i)+"@seila.com");
			funcionario = Fixture.from(Funcionario.class).gimme("valido");
			email.setFuncionario(funcionario);
			emails.add(email);
		}
		empresa.setEmailEmpresa(emails);;
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 emails"));
	}
	
	/**
	 * Deve aceitar empresa com site nulo.
	 */
	@Test
	public void deve_aceitar_empresa_com_site_nulo() {
		empresa.setSite(null);
		assertNull(empresa.getSite());
	}
	
	/**
	 * Deve aceitar empresa com lista de sites vazia.
	 */
	@Test
	public void deve_aceitar_empresa_com_lista_de_sites_vazia() {
		empresa.setEmailEmpresa(new HashSet<Email>());
		assertTrue(isValid(empresa, empresa.getSite().toString()));
	}
	
	/**
	 * Deve aceitar empresa com um site.
	 */
	@Test
	public void deve_aceitar_empresa_com_um_site() {
		site.setUrl("www.seila.com.br");
		sites.add(site);
		empresa.setSite(sites);
		assertTrue(isValid(empresa, "www.seila.com.br"));
	}
	
	/**
	 * Deve aceitar empresa com 100 sites.
	 */
	@Test
	public void deve_aceitar_empresa_com_100_sites() {
		for (int i = 0; i < 100; i++) {
			site.setUrl("www."+Integer.toString(i)+".com");
			sites.add(site);
		}
		empresa.setSite(sites);
		assertThat(empresa.getSite().size(), is(100));
	}
	
	/**
	 * Nao deve aceitar empresa com mais de 100 sites.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_mais_de_100_sites() {
		for (int i = 0; i < 110; i++) {
			site.setUrl("www." + Integer.toString(i) + ".com");
			sites.add(site);
		}
		empresa.setSite(sites);
		assertFalse(isValid(empresa, "A quantidade maxima é de 100 sites"));
	}
	
	/**
	 * Nao deve aceitar empresa com data de registro nula.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_data_de_registro_nula() {
		empresa.setDataDeRegistro(null);
		assertFalse(isValid(empresa, "Data de registro não pode ser nula"));
	}
	
	/**
	 * Nao deve aceitar empresa com data de registro no futuro.
	 */
	@Test
	public void nao_deve_aceitar_empresa_com_data_de_registro_no_futuro() {
		empresa.setDataDeRegistro(new LocalDate(2056,12,12));
		assertFalse(isValid(empresa, "Data de nascimento não pode ser no futuro"));
	}
	
	/**
	 * Deve aceitar funcionario com data de nascimento valida.
	 */
	@Test
	public void deve_aceitar_funcionario_com_data_de_nascimento_valida() {
		empresa.setDataDeRegistro(new LocalDate(2000,12,12));
		assertTrue(isValid(empresa, empresa.getDataDeRegistro().toString()));
	}
	
	/**
	 * Deve respeitar os gets sets.
	 */
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Empresa.class, hasValidGettersAndSetters());
	}
	
	/**
	 * Deve respeitar equals hash code.
	 */
	@Test
	public void deve_respeitar_equals_hashCode() {
	    EqualsVerifier.forClass(Empresa.class).withOnlyTheseFields("cnpj").suppress(Warning.NONFINAL_FIELDS).verify();
	}

}
