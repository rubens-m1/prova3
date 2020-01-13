package funcionariotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.funcionario.FixtureFuncionario;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioTest.
 */
public class FuncionarioTest {
	
	/** The funcionario. */
	private Funcionario funcionario;
	
	/** The funcionario 2. */
	private Funcionario funcionario2;
	
	/** The endereco. */
	private Endereco endereco;
	
	/** The telefone. */
	private Telefone telefone;
	
	/** The telefone 1. */
	private Telefone telefone1;
	
	/** The telefones. */
	private Set<Telefone> telefones;	
	
	/**
	 * Inits the.
	 */
	@BeforeClass
	public static void init() {
		Utilidades.reconhecerJodaTime();
		FixtureFuncionario.fakeFuncionario();
	}
	
	/**
	 * Inits the 2.
	 */
	@Before
	public void init2() {	
		funcionario = Fixture.from(Funcionario.class).gimme("valido");
		funcionario2 = Fixture.from(Funcionario.class).gimme("valido");
		endereco = Fixture.from(Endereco.class).gimme("valido");
		telefone = Fixture.from(Telefone.class).gimme("valido");
	}

	/**
	 * Deve aceitar funcionario valido.
	 */
	@Test
	public void deve_aceitar_funcionario_valido() {
		System.out.println(funcionario);
	}
	
	/**
	 * Testes de CPF.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_cpf_nulo() {
		funcionario.setCpf(null);
		assertFalse(Utilidades.isValid(funcionario, "CPF nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar funcionario com cpf vazio.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_cpf_vazio() {
		funcionario.setCpf("");
		assertFalse(Utilidades.isValid(funcionario, "CPF nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com cpf em branco.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_cpf_em_branco() {
		funcionario.setCpf("             ");
		assertFalse(Utilidades.isValid(funcionario, "CPF nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Deve aceitar cpf valido.
	 */
	@Test
	public void deve_aceitar_cpf_valido() {
		funcionario.setCpf("27975838098");
		assertTrue(Utilidades.isValid(funcionario, "27975838098"));
	}
	
	/**
	 * Deve aceitar cpf valido com pontos e tracos.
	 */
	@Test
	public void deve_aceitar_cpf_valido_com_pontos_e_tracos() {
		funcionario.setCpf("279.758.380-98");
		assertTrue(funcionario.getCpf().equals("279.758.380-98"));
	}
	
	/**
	 * Deve aceitar cpf valido com pontos e tracos 1.
	 */
	@Test
	public void deve_aceitar_cpf_valido_com_pontos_e_tracos_1() {
		funcionario.setCpf("279.758.380-98");
		assertTrue(Utilidades.isValid(funcionario, "279.758.380-98"));
	}
	
	/**
	 * Nao deve aceitar cpf invalido.
	 */
	@Test
	public void nao_deve_aceitar_cpf_invalido() {
		funcionario.setCpf("27975838091");
		assertFalse(Utilidades.isValid(funcionario, "CPF invalido"));
	}
	
	/**
	 * Nao deve aceitar cpf com numeros e letras.
	 */
	@Test
	public void nao_deve_aceitar_cpf_com_numeros_e_letras() {
		funcionario.setCpf("2797583809a");
		assertFalse(Utilidades.isValid(funcionario, "CPF invalido"));
	}
	
	/**
	 * Nao deve aceitar cpf so com letras.
	 */
	@Test
	public void nao_deve_aceitar_cpf_so_com_letras() {
		funcionario.setCpf("aaaaaaaaaaa");
		assertFalse(Utilidades.isValid(funcionario, "CPF invalido"));
	}
	
	/**
	 * Nao deve aceitar cpf com numeros e caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_cpf_com_numeros_e_caracteres_especiais() {
		funcionario.setCpf("2797583809!");
		assertFalse(Utilidades.isValid(funcionario, "CPF invalido"));
	}
	
	/**
	 * Nao deve aceitar cpf so com caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_cpf_so_com_caracteres_especiais() {
		funcionario.setCpf("!@#$%¨&*()_+");
		assertFalse(Utilidades.isValid(funcionario, "CPF invalido"));
	}
	
	/**
	 * Deve acertar o tamanho de onze caracteres no cpf.
	 */
	@Test
	public void deve_acertar_o_tamanho_de_onze_caracteres_no_cpf() {
		funcionario.setCpf("27975838098");
		assertThat(funcionario.getCpf().length(), is(11));
	}
	
	/**
	 * Nao deve aceitar cpf com menos de onze digitos.
	 */
	@Test
	public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
		funcionario.setCpf("2797583809");
		assertFalse(Utilidades.isValid(funcionario, "O CPF deve conter exatamente 11 digitos"));
	}
	
	/**
	 * Nao deve aceitar cpf com mais de onze digitos.
	 */
	@Test
	public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
		funcionario.setCpf("279758380981");
		assertFalse(Utilidades.isValid(funcionario, "O CPF deve conter exatamente 11 digitos"));
	}
	
	/**
	 * Testes de Primeiro Nome.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_nome_nulo() {
		funcionario.setPrimeiroNome(null);
		assertFalse(Utilidades.isValid(funcionario, "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com nome vazio.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_nome_vazio() {
		funcionario.setPrimeiroNome("");
		assertFalse(Utilidades.isValid(funcionario, "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com nome em branco.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_nome_em_branco() {
		funcionario.setPrimeiroNome("               ");
		assertFalse(Utilidades.isValid(funcionario, "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Deve aceitar primeiro nome valido.
	 */
	@Test
	public void deve_aceitar_primeiro_nome_valido() {
		funcionario.setPrimeiroNome("Roberto");
		assertTrue(funcionario.getPrimeiroNome().equals("Roberto"));
	}
	
	/**
	 * Nao deve aceitar primeiro nome com numeros.
	 */
	@Test
	public void nao_deve_aceitar_primeiro_nome_com_numeros() {
		funcionario.setPrimeiroNome("Paulo123");
		assertFalse(Utilidades.isValid(funcionario, "O campo deve conter somente letras"));
	}
	
	/**
	 * Nao deve acetar primeiro nome com caracteres especiais.
	 */
	@Test
	public void nao_deve_acetar_primeiro_nome_com_caracteres_especiais() {
		funcionario.setPrimeiroNome("Maria!@#$");
		assertFalse(Utilidades.isValid(funcionario, "O campo deve conter somente letras"));
	}
	
	/**
	 * Deve aceitar nome valido com o minimo de caracteres.
	 */
	@Test
	public void deve_aceitar_nome_valido_com_o_minimo_de_caracteres() {
		funcionario.setPrimeiroNome("A");
		assertTrue(funcionario.getPrimeiroNome().equals("A"));
	}
	
	
	/**
	 * Deve acertar o comprimento minimo do primeiro nome.
	 */
	@Test
	public void deve_acertar_o_comprimento_minimo_do_primeiro_nome() {
		funcionario.setPrimeiroNome("a");
		assertThat(funcionario.getPrimeiroNome().length(), is(1));
	}
	
	/**
	 * Deve aceitar primeiro nome valido com o maximo de caracteres.
	 */
	@Test
	public void deve_aceitar_primeiro_nome_valido_com_o_maximo_de_caracteres() {
		funcionario.setPrimeiroNome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(funcionario.getPrimeiroNome().equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
	}
	
	
	/**
	 * Deve acertar o comprimento maximo do primeiro nome.
	 */
	@Test
	public void deve_acertar_o_comprimento_maximo_do_primeiro_nome() {
		funcionario.setPrimeiroNome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertThat(funcionario.getPrimeiroNome().length(), is(50));
	}
	
	
	/**
	 * Nao deve aceitar primeiro nome maior que o comprimento maximo.
	 */
	@Test
	public void nao_deve_aceitar_primeiro_nome_maior_que_o_comprimento_maximo() {
		funcionario.setPrimeiroNome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertFalse(Utilidades.isValid(funcionario, "O campo primeiro nome deve conter de 1 a 50 caracteres"));
	}
	
	/**
	 * Nao deve aceitar primeiro nome com espacos.
	 */
	@Test
	public void nao_deve_aceitar_primeiro_nome_com_espacos() {
		funcionario.setPrimeiroNome("Ana Paula");
		assertFalse(Utilidades.isValid(funcionario, "O campo deve conter somente letras"));
	}
	
	/**
	 * Testes de Sobrenome.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_sobrenome_nulo() {
		funcionario.setSobrenome(null);
		assertFalse(Utilidades.isValid(funcionario, "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com sobrenome vazio.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_sobrenome_vazio() {
		funcionario.setSobrenome("");
		assertFalse(Utilidades.isValid(funcionario, "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com sobrenome em branco.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_sobrenome_em_branco() {
		funcionario.setSobrenome("        ");
		assertFalse(Utilidades.isValid(funcionario, "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Deve aceitar sobrenome valido.
	 */
	@Test
	public void deve_aceitar_sobrenome_valido() {
		funcionario.setSobrenome("Roberto");
		assertTrue(funcionario.getSobrenome().equals("Roberto"));
	}
	
	/**
	 * Nao deve aceitar sobrenome com numeros.
	 */
	@Test
	public void nao_deve_aceitar_sobrenome_com_numeros() {
		funcionario.setSobrenome("Paula123");
		assertFalse(Utilidades.isValid(funcionario, "O campo sobrenome deve conter somente letras e espacos"));
	}
	
	/**
	 * Nao deve acetar sobrenome com caracteres especiais.
	 */
	@Test
	public void nao_deve_acetar_sobrenome_com_caracteres_especiais() {
		funcionario.setSobrenome("Maria!@#$");
		assertFalse(Utilidades.isValid(funcionario, "O campo sobrenome deve conter somente letras e espacos"));
	}
	
	/**
	 * Deve aceitar sobrenome valido com o minimo de caracteres.
	 */
	@Test
	public void deve_aceitar_sobrenome_valido_com_o_minimo_de_caracteres() {
		funcionario.setSobrenome("A");
		assertTrue(funcionario.getSobrenome().equals("A"));
	}
	
	/**
	 * Deve acertar o comprimento minimo do sobrenome.
	 */
	@Test
	public void deve_acertar_o_comprimento_minimo_do_sobrenome() {
		funcionario.setSobrenome("a");
		assertThat(funcionario.getSobrenome().length(), is(1));
	}
	
	/**
	 * Deve aceitar sobrenome valido com o maximo de caracteres.
	 */
	@Test
	public void deve_aceitar_sobrenome_valido_com_o_maximo_de_caracteres() {
		funcionario.setSobrenome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(funcionario.getSobrenome().equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
	}
	
	
	/**
	 * Deve acertar o comprimento maximo do sobrenome.
	 */
	@Test
	public void deve_acertar_o_comprimento_maximo_do_sobrenome() {
		funcionario.setSobrenome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertThat(funcionario.getSobrenome().length(), is(50));
	}
	
	
	/**
	 * Nao deve aceitar sobrenome maior que o comprimento maximo.
	 */
	@Test
	public void nao_deve_aceitar_sobrenome_maior_que_o_comprimento_maximo() {
		funcionario.setSobrenome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertFalse(Utilidades.isValid(funcionario, "O campo sobrenome nome deve conter de 1 a 50 caracteres"));
	}
	
	/**
	 * Deve aceitar sobrenome com espacos.
	 */
	@Test
	public void deve_aceitar_sobrenome_com_espacos() {
		funcionario.setSobrenome("de Paula");
		assertTrue(funcionario.getSobrenome().equals("de Paula"));
	}
	
	/**
	 * Testes de Data de Nascimento.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_data_de_nascimento_nula() {
		funcionario.setDataDeNascimento(null);
		assertFalse(Utilidades.isValid(funcionario, "Data de nascimento não pode ser nula"));
	}
	
	/**
	 * Nao deve aceitar funcionario com data de nascimento no futuro.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_data_de_nascimento_no_futuro() {
		funcionario.setDataDeNascimento(new LocalDate(2056,12,12));
		assertFalse(Utilidades.isValid(funcionario, "Data de nascimento não pode ser no futuro"));
	}
	
	/**
	 * Deve aceitar funcionario com data de nascimento valida.
	 */
	@Test
	public void deve_aceitar_funcionario_com_data_de_nascimento_valida() {
		funcionario.setDataDeNascimento(new LocalDate(1995,12,12));
		assertTrue(Utilidades.isValid(funcionario,funcionario.getDataDeNascimento().toString()));
	}
	
	/**
	 * Testes de Cargo.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_cargo_nulo() {
		funcionario.setCargo(null);
		assertFalse(Utilidades.isValid(funcionario, "Cargo nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com cargo vazio.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_cargo_vazio() {
		funcionario.setCargo("");
		assertFalse(Utilidades.isValid(funcionario, "Cargo nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com cargo em branco.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_cargo_em_branco() {
		funcionario.setCargo("        ");
		assertFalse(Utilidades.isValid(funcionario, "Cargo nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Deve aceitar funcionario com cargo valido.
	 */
	@Test
	public void deve_aceitar_funcionario_com_cargo_valido() {
		funcionario.setCargo("Analista");
		assertTrue(funcionario.getCargo().equals("Analista"));
	}
	
	/**
	 * Deve aceitar funcionario com cargo valido com espacos.
	 */
	@Test
	public void deve_aceitar_funcionario_com_cargo_valido_com_espacos() {
		funcionario.setCargo("Analista Pleno");
		assertTrue(funcionario.getCargo().equals("Analista Pleno"));
	}
	
	/**
	 * Deve aceitar funcionario com cargo valido com espacos e acento.
	 */
	@Test
	public void deve_aceitar_funcionario_com_cargo_valido_com_espacos_e_acento() {
		funcionario.setCargo("Analista Sênior");
		assertTrue(funcionario.getCargo().equals("Analista Sênior"));
	}
	
	/**
	 * Nao deve aceitar cargo com caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_cargo_com_caracteres_especiais() {
		funcionario.setCargo("Analista!@#$");
		assertFalse(Utilidades.isValid(funcionario, "O campo sobrenome deve conter somente letras e espacos"));
	}
	
	/**
	 * Nao deve aceitar cargo com numeros.
	 */
	@Test
	public void nao_deve_aceitar_cargo_com_numeros() {
		funcionario.setCargo("Tecnico123");
		assertFalse(Utilidades.isValid(funcionario, "O campo cargo deve conter somente letras e espacos"));
	}
	
	/**
	 * Deve aceitar cargo com a quantidade minima de caracteres.
	 */
	@Test
	public void deve_aceitar_cargo_com_a_quantidade_minima_de_caracteres() {
		funcionario.setCargo("TI");
		assertTrue(funcionario.getCargo().equals("TI"));
	}
	
	/**
	 * Deve acertar a quantidade de caracteres minima em cargo.
	 */
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_minima_em_cargo() {
		funcionario.setCargo("TI");
		assertThat(funcionario.getCargo().length(), is(2));
	}	
	
	/**
	 * Nao deve aceitar cargo com a quantidade de caracteres menor que a minima.
	 */
	@Test
	public void nao_deve_aceitar_cargo_com_a_quantidade_de_caracteres_menor_que_a_minima() {
		funcionario.setCargo("a");
		assertFalse(Utilidades.isValid(funcionario, "O campo cargo nome deve conter de 2 a 50 caracteres"));
	}
	
	/**
	 * Deve aceitar cargo com a quantidade de caracteres maxima.
	 */
	@Test
	public void deve_aceitar_cargo_com_a_quantidade_de_caracteres_maxima() {
		funcionario.setCargo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(funcionario.getCargo().equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
	}
	
	/**
	 * Deve acertar a quantidade de caracteres do cargo.
	 */
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_do_cargo() {
		funcionario.setCargo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertThat(funcionario.getCargo().length(), is(50));
	}
	
	/**
	 * Nao deve aceitar cargo com a quantidade de caracteres maior que a maxima.
	 */
	@Test
	public void nao_deve_aceitar_cargo_com_a_quantidade_de_caracteres_maior_que_a_maxima() {
		funcionario.setCargo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB");
		assertFalse(Utilidades.isValid(funcionario, "O campo cargo nome deve conter de 2 a 50 caracteres"));
	}
	
	/**
	 * Testes de Salario.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_nulo() {
		funcionario.setSalario(null);
		assertFalse(Utilidades.isValid(funcionario, "Salario nao pode ser nulo"));
	}
	
	/**
	 * Deve aceitar funcionario com salario valido.
	 */
	@Test
	public void deve_aceitar_funcionario_com_salario_valido() {
		funcionario.setSalario(2000.00);
		assertThat(funcionario.getSalario(), is(2000.00));
	}
	
	/**
	 * Deve aceitar funcionario com salario minimo.
	 */
	@Test
	public void deve_aceitar_funcionario_com_salario_minimo() {
		funcionario.setSalario(998.00);
		assertThat(funcionario.getSalario(), is(998.00));
	}

	
	/**
	 * Deve aceitar funcionario com salario maximo.
	 */
	@Test
	public void deve_aceitar_funcionario_com_salario_maximo() {
		funcionario.setSalario(999999999.00);
		assertThat(funcionario.getSalario(), is(999999999.00));
	}
	
	/**
	 * Nao deve aceitar funcionario com salario menor que o salario minimo.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_menor_que_o_salario_minimo() {
		funcionario.setSalario(997.00);
		assertFalse(Utilidades.isValid(funcionario, "O valor do salario deve ser maior ou igual a 998"));
	}
	
	/**
	 * Nao deve aceitar funcionario com salario maior que o salario maximo.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_maior_que_o_salario_maximo() {
		funcionario.setSalario(1000000000.00);
		assertFalse(Utilidades.isValid(funcionario, "O valor do salario deve ser menor ou igual a 999999999"));
	}
	
	/**
	 * Testes de Endereco.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_endereco_nulo() {
		funcionario.setEndereco(null);
		assertFalse(Utilidades.isValid(funcionario, "Endereco nao pode ser nulo"));
	}
	
	/**
	 * Deve aceitar funcionario com endereco valido.
	 */
	@Test
	public void deve_aceitar_funcionario_com_endereco_valido() {
		funcionario.setEndereco(endereco);
		assertThat(funcionario.getEndereco(), is(endereco));
	}
	
	/**
	 * Testes de Telefone.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_telefone_nulo() {
		funcionario.setTelefone(null);
		assertFalse(Utilidades.isValid(funcionario, "Telefone nao pode ser nulo"));
	}
	
	/**
	 * Deve aceitar funcionario com telefone valido.
	 */
	@Test
	public void deve_aceitar_funcionario_com_telefone_valido() {
		telefones = new HashSet<>();
		telefones.add(telefone);
		funcionario.setTelefone(telefones);
		assertTrue(funcionario.getTelefone().equals(telefones));
	}
	
	/**
	 * Deve aceitar funcionario com mais de um telefone.
	 */
	@Test
	public void deve_aceitar_funcionario_com_mais_de_um_telefone() {
		telefones = new HashSet<>();
		telefone1 = Fixture.from(Telefone.class).gimme("valido");
		telefones.add(telefone);
		telefones.add(telefone1);
		funcionario.setTelefone(telefones);
		assertTrue(funcionario.getTelefone().equals(telefones));
	}
	
	/**
	 * Testes de email.
	 */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_email_nulo() {
		funcionario.setEmail(null);
		assertFalse(Utilidades.isValid(funcionario, "E-mail nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com email vazio.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_email_vazio() {
		funcionario.setEmail("");
		assertFalse(Utilidades.isValid(funcionario, "E-mail nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar funcionario com email em branco.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_email_em_branco() {
		funcionario.setEmail("        ");
		assertFalse(Utilidades.isValid(funcionario, "E-mail nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Deve aceitar funcionario com email valido.
	 */
	@Test
	public void deve_aceitar_funcionario_com_email_valido() {
		funcionario.setEmail("email@empresa.com");
		assertTrue(funcionario.getEmail().equals("email@empresa.com"));
	}

	/**
	 * Nao deve aceitar funcionario com email invalido sem arroba.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_email_invalido_sem_arroba() {
		funcionario.setEmail("funcionario.123.com.br");
		assertFalse(Utilidades.isValid(funcionario, "E-mail invalido"));

	}

	/**
	 * Nao deve aceitar funcionario com email invalido com espaco.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_email_invalido_com_espaco() {
		funcionario.setEmail("funcionario @123.com");
		assertFalse(Utilidades.isValid(funcionario, "E-mail invalido"));
	}

	/**
	 * Nao deve aceitar funcionario com email invalido com espaco e sem arroba.
	 */
	@Test
	public void nao_deve_aceitar_funcionario_com_email_invalido_com_espaco_e_sem_arroba() {
		funcionario.setEmail("funcionario .123.com");
		assertFalse(Utilidades.isValid(funcionario, "E-mail invalido"));
	}

	/**
	 * Nao deve aceitar email invalido com espaco e com mais de um arroba.
	 */
	@Test
	public void nao_deve_aceitar_email_invalido_com_espaco_e_com_mais_de_um_arroba() {
		funcionario.setEmail("funcionario @@123.com");
		assertFalse(Utilidades.isValid(funcionario, "E-mail invalido"));
	}

	/**
	 * Nao deve aceitar email com mais de um arroba.
	 */
	@Test
	public void nao_deve_aceitar_email_com_mais_de_um_arroba() {
		funcionario.setEmail("aa@@.com.br");
		assertFalse(Utilidades.isValid(funcionario, "E-mail invalido"));
	}
	
	/**
	 * Testes de Funcionario.
	 */
	
	@Test
	public void deve_acertar_que_funcionarios_iguais_tem_o_mesmo_hash_code() {
		funcionario2 = funcionario;
		assertTrue(funcionario.hashCode() == funcionario2.hashCode());
	}
	
	/**
	 * Nao deve aceitar que funcionarios iguais tenham hashcodes diferentes.
	 */
	@Test
	public void nao_deve_aceitar_que_funcionarios_iguais_tenham_hashcodes_diferentes() {
		funcionario2 = funcionario;
		assertFalse(funcionario.hashCode() != funcionario2.hashCode());
	}
	
	/**
	 * Deve acertar que funcionarios diferentes tenham hashcodes diferentes.
	 */
	@Test
	public void deve_acertar_que_funcionarios_diferentes_tenham_hashcodes_diferentes() {
		funcionario.setCpf("22187618072");
		assertTrue(funcionario.hashCode() != funcionario2.hashCode());
	}
	
	/**
	 * Nao deve aceitar que funcionarios diferentes tenham hashcodes iguais.
	 */
	@Test
	public void nao_deve_aceitar_que_funcionarios_diferentes_tenham_hashcodes_iguais() {
		funcionario.setCpf("22187618072");
		assertFalse(funcionario.hashCode() == funcionario2.hashCode());
	}
	
	/**
	 * Deve fazer to string de funcionario.
	 */
	@Test
	public void deve_fazer_to_string_de_funcionario() {
		System.out.println(funcionario.toString());
	}
	
	/**
	 * Deve respeitar os gets sets.
	 */
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Funcionario.class, BeanMatchers.hasValidGettersAndSetters());
	}

	/**
	 * Deve respeitar hash code.
	 */
	@Test
	public void deve_respeitar_hash_code() {
		assertThat(Funcionario.class, BeanMatchers.hasValidBeanHashCode());
	}

	/**
	 * Deve respeitar equals.
	 */
	@Test
	public void deve_respeitar_equals() {
		assertThat(Funcionario.class, BeanMatchers.hasValidBeanEquals());
	}
	


}
