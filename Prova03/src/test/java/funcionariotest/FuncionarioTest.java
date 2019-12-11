package funcionariotest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.funcionario.FixtureFuncionario;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;

public class FuncionarioTest {
	
	private Funcionario funcionario;
	
	private Funcionario funcionario2;
	
	private Endereco endereco;
	
	private Telefone telefone;
	
	private Telefone telefone1;
	
	private Set<Telefone> telefones;
	
	private Validator validator;

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	@BeforeClass
	public static void init() {
		FixtureFuncionario.fakeFuncionario();
	}
	
	@Before
	public void init2() {	
		funcionario = Fixture.from(Funcionario.class).gimme("valido");
		funcionario2 = Fixture.from(Funcionario.class).gimme("valido");
		endereco = Fixture.from(Endereco.class).gimme("valido");
		telefone = Fixture.from(Telefone.class).gimme("valido");
	}
	
	public boolean isValid(Funcionario funcionario, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Funcionario>> restricoes = validator.validate(funcionario);
		for (ConstraintViolation<Funcionario> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}

	@Test
	public void deve_aceitar_funcionario_valido() {
		System.out.println(funcionario);
	}
	
	/**
	 * Testes de CPF
	 **/
	
	@Test
	public void nao_deve_aceitar_funcionario_com_cpf_nulo() {
		funcionario.setCpf(null);
		assertFalse(isValid(funcionario, "CPF nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_funcionario_com_cpf_vazio() {
		funcionario.setCpf("");
		assertFalse(isValid(funcionario, "CPF nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_cpf_em_branco() {
		funcionario.setCpf("             ");
		assertFalse(isValid(funcionario, "CPF nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void deve_aceitar_cpf_valido() {
		funcionario.setCpf("27975838098");
		assertTrue(isValid(funcionario, "27975838098"));
	}
	
	@Test
	public void deve_aceitar_cpf_valido_com_pontos_e_tracos() {
		funcionario.setCpf("279.758.380-98");
		assertTrue(funcionario.getCpf().equals("279.758.380-98"));
	}
	
	@Test
	public void deve_aceitar_cpf_valido_com_pontos_e_tracos_1() {
		funcionario.setCpf("279.758.380-98");
		assertTrue(isValid(funcionario, "279.758.380-98"));
	}
	
	@Test
	public void nao_deve_aceitar_cpf_invalido() {
		funcionario.setCpf("27975838091");
		assertFalse(isValid(funcionario, "CPF invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_cpf_com_numeros_e_letras() {
		funcionario.setCpf("2797583809a");
		assertFalse(isValid(funcionario, "CPF invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_cpf_so_com_letras() {
		funcionario.setCpf("aaaaaaaaaaa");
		assertFalse(isValid(funcionario, "CPF invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_cpf_com_numeros_e_caracteres_especiais() {
		funcionario.setCpf("2797583809!");
		assertFalse(isValid(funcionario, "CPF invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_cpf_so_com_caracteres_especiais() {
		funcionario.setCpf("!@#$%¨&*()_+");
		assertFalse(isValid(funcionario, "CPF invalido"));
	}
	
	@Test
	public void deve_acertar_o_tamanho_de_onze_caracteres_no_cpf() {
		funcionario.setCpf("27975838098");
		assertThat(funcionario.getCpf().length(), is(11));
	}
	
	@Test
	public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
		funcionario.setCpf("2797583809");
		assertFalse(isValid(funcionario, "O CPF deve conter exatamente 11 digitos"));
	}
	
	@Test
	public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
		funcionario.setCpf("279758380981");
		assertFalse(isValid(funcionario, "O CPF deve conter exatamente 11 digitos"));
	}
	
	/**
	 * Testes de Primeiro Nome
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_nome_nulo() {
		funcionario.setPrimeiroNome(null);
		assertFalse(isValid(funcionario, "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_nome_vazio() {
		funcionario.setPrimeiroNome("");
		assertFalse(isValid(funcionario, "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_nome_em_branco() {
		funcionario.setPrimeiroNome("               ");
		assertFalse(isValid(funcionario, "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void deve_aceitar_primeiro_nome_valido() {
		funcionario.setPrimeiroNome("Roberto");
		assertTrue(funcionario.getPrimeiroNome().equals("Roberto"));
	}
	
	@Test
	public void nao_deve_aceitar_primeiro_nome_com_numeros() {
		funcionario.setPrimeiroNome("Paulo123");
		assertFalse(isValid(funcionario, "O campo deve conter somente letras"));
	}
	
	@Test
	public void nao_deve_acetar_primeiro_nome_com_caracteres_especiais() {
		funcionario.setPrimeiroNome("Maria!@#$");
		assertFalse(isValid(funcionario, "O campo deve conter somente letras"));
	}
	
	@Test
	public void deve_aceitar_nome_valido_com_o_minimo_de_caracteres() {
		funcionario.setPrimeiroNome("A");
		assertTrue(funcionario.getPrimeiroNome().equals("A"));
	}
	
	
	@Test
	public void deve_acertar_o_comprimento_minimo_do_primeiro_nome() {
		funcionario.setPrimeiroNome("a");
		assertThat(funcionario.getPrimeiroNome().length(), is(1));
	}
	
	@Test
	public void deve_aceitar_primeiro_nome_valido_com_o_maximo_de_caracteres() {
		funcionario.setPrimeiroNome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(funcionario.getPrimeiroNome().equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
	}
	
	
	@Test
	public void deve_acertar_o_comprimento_maximo_do_primeiro_nome() {
		funcionario.setPrimeiroNome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertThat(funcionario.getPrimeiroNome().length(), is(50));
	}
	
	
	@Test
	public void nao_deve_aceitar_primeiro_nome_maior_que_o_comprimento_maximo() {
		funcionario.setPrimeiroNome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertFalse(isValid(funcionario, "O campo primeiro nome deve conter de 1 a 50 caracteres"));
	}
	
	@Test
	public void nao_deve_aceitar_primeiro_nome_com_espacos() {
		funcionario.setPrimeiroNome("Ana Paula");
		assertFalse(isValid(funcionario, "O campo deve conter somente letras"));
	}
	
	/**
	 * Testes de Sobrenome
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_sobrenome_nulo() {
		funcionario.setSobrenome(null);
		assertFalse(isValid(funcionario, "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_sobrenome_vazio() {
		funcionario.setSobrenome("");
		assertFalse(isValid(funcionario, "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_sobrenome_em_branco() {
		funcionario.setSobrenome("        ");
		assertFalse(isValid(funcionario, "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void deve_aceitar_sobrenome_valido() {
		funcionario.setSobrenome("Roberto");
		assertTrue(funcionario.getSobrenome().equals("Roberto"));
	}
	
	@Test
	public void nao_deve_aceitar_sobrenome_com_numeros() {
		funcionario.setSobrenome("Paula123");
		assertFalse(isValid(funcionario, "O campo sobrenome deve conter somente letras e espacos"));
	}
	
	@Test
	public void nao_deve_acetar_sobrenome_com_caracteres_especiais() {
		funcionario.setSobrenome("Maria!@#$");
		assertFalse(isValid(funcionario, "O campo sobrenome deve conter somente letras e espacos"));
	}
	
	@Test
	public void deve_aceitar_sobrenome_valido_com_o_minimo_de_caracteres() {
		funcionario.setSobrenome("A");
		assertTrue(funcionario.getSobrenome().equals("A"));
	}
	
	
	@Test
	public void deve_acertar_o_comprimento_minimo_do_sobrenome() {
		funcionario.setSobrenome("a");
		assertThat(funcionario.getSobrenome().length(), is(1));
	}
	
	@Test
	public void deve_aceitar_sobrenome_valido_com_o_maximo_de_caracteres() {
		funcionario.setSobrenome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(funcionario.getSobrenome().equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
	}
	
	
	@Test
	public void deve_acertar_o_comprimento_maximo_do_sobrenome() {
		funcionario.setSobrenome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertThat(funcionario.getSobrenome().length(), is(50));
	}
	
	
	@Test
	public void nao_deve_aceitar_sobrenome_maior_que_o_comprimento_maximo() {
		funcionario.setSobrenome("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertFalse(isValid(funcionario, "O campo sobrenome nome deve conter de 1 a 50 caracteres"));
	}
	
	@Test
	public void deve_aceitar_sobrenome_com_espacos() {
		funcionario.setSobrenome("de Paula");
		assertTrue(funcionario.getSobrenome().equals("de Paula"));
	}
	
	
	/**
	 * Testes de Data de Nascimento
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_data_de_nascimento_nula() {
		funcionario.setDataDeNascimento(null);
		assertFalse(isValid(funcionario, "Data de nascimento nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_data_de_nascimento_vazia() {
		funcionario.setDataDeNascimento(new LocalDate());
		System.out.println(funcionario.getDataDeNascimento());
		fail();
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_data_de_nascimento_no_futuro() {
		funcionario.setDataDeNascimento(new LocalDate(2019,12,12));
		System.out.println(funcionario.getDataDeNascimento());
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_menos_de_16_anos() {
		
	}
	
	
//
	boolean isValidDate(String dateToValidate){
	    String pattern = "yyyy-MM-dd";

	    try {
	        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
	        fmt.parseDateTime(dateToValidate);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Testes de Cargo
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_cargo_nulo() {
		funcionario.setCargo(null);
		assertFalse(isValid(funcionario, "Cargo nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_cargo_vazio() {
		funcionario.setCargo("");
		assertFalse(isValid(funcionario, "Cargo nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_cargo_em_branco() {
		funcionario.setCargo("        ");
		assertFalse(isValid(funcionario, "Cargo nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_cargo_valido() {
		funcionario.setCargo("Analista");
		assertTrue(funcionario.getCargo().equals("Analista"));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_cargo_valido_com_espacos() {
		funcionario.setCargo("Analista Pleno");
		assertTrue(funcionario.getCargo().equals("Analista Pleno"));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_cargo_valido_com_espacos_e_acento() {
		funcionario.setCargo("Analista Sênior");
		assertTrue(funcionario.getCargo().equals("Analista Sênior"));
	}
	
	@Test
	public void nao_deve_aceitar_cargo_com_caracteres_especiais() {
		funcionario.setCargo("Analista!@#$");
		assertFalse(isValid(funcionario, "O campo sobrenome deve conter somente letras e espacos"));
	}
	
	@Test
	public void nao_deve_aceitar_cargo_com_numeros() {
		funcionario.setCargo("Tecnico123");
		assertFalse(isValid(funcionario, "O campo cargo deve conter somente letras e espacos"));
	}
	
	@Test
	public void deve_aceitar_cargo_com_a_quantidade_minima_de_caracteres() {
		funcionario.setCargo("TI");
		assertTrue(funcionario.getCargo().equals("TI"));
	}
	
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_minima_em_cargo() {
		funcionario.setCargo("TI");
		assertThat(funcionario.getCargo().length(), is(2));
	}	
	
	@Test
	public void nao_deve_aceitar_cargo_com_a_quantidade_de_caracteres_menor_que_a_minima() {
		funcionario.setCargo("a");
		assertFalse(isValid(funcionario, "O campo cargo nome deve conter de 2 a 50 caracteres"));
	}
	
	@Test
	public void deve_aceitar_cargo_com_a_quantidade_de_caracteres_maxima() {
		funcionario.setCargo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertTrue(funcionario.getCargo().equals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
	}
	
	@Test
	public void deve_acertar_a_quantidade_de_caracteres_do_cargo() {
		funcionario.setCargo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertThat(funcionario.getCargo().length(), is(50));
	}
	
	@Test
	public void nao_deve_aceitar_cargo_com_a_quantidade_de_caracteres_maior_que_a_maxima() {
		funcionario.setCargo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB");
		assertFalse(isValid(funcionario, "O campo cargo nome deve conter de 2 a 50 caracteres"));
	}
	
	/**
	 * Testes de Salario
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_nulo() {
		funcionario.setSalario(null);
		assertFalse(isValid(funcionario, "Salario nao pode ser nulo"));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_salario_valido() {
		funcionario.setSalario(2000.00);
		assertThat(funcionario.getSalario(), is(2000.00));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_salario_minimo() {
		funcionario.setSalario(998.00);
		assertThat(funcionario.getSalario(), is(998.00));
	}

	
	@Test
	public void deve_aceitar_funcionario_com_salario_maximo() {
		funcionario.setSalario(999999999.00);
		assertThat(funcionario.getSalario(), is(999999999.00));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_menor_que_o_salario_minimo() {
		funcionario.setSalario(997.00);
		assertFalse(isValid(funcionario, "O valor do salario deve ser maior ou igual a 998"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_maior_que_o_salario_maximo() {
		funcionario.setSalario(1000000000.00);
		assertFalse(isValid(funcionario, "O valor do salario deve ser menor ou igual a 999999999"));
	}
	
	/**
	 * Testes de Endereco
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_endereco_nulo() {
		funcionario.setEndereco(null);
		assertFalse(isValid(funcionario, "Endereco nao pode ser nulo"));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_endereco_valido() {
		funcionario.setEndereco(endereco);
		assertThat(funcionario.getEndereco(), is(endereco));
	}
	
	/**
	 * Testes de Telefone
	 **/
	
	@Test
	public void nao_deve_aceitar_funcionario_com_telefone_nulo() {
		funcionario.setTelefone(null);
		assertFalse(isValid(funcionario, "Telefone nao pode ser nulo"));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_telefone_valido() {
		telefones = new HashSet<>();
		telefones.add(telefone);
		funcionario.setTelefone(telefones);
		assertTrue(funcionario.getTelefone().equals(telefones));
	}
	
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
	 * Testes de email
	 **/
	
	@Test
	public void nao_deve_aceitar_funcionario_com_email_nulo() {
		funcionario.setEmail(null);
		assertFalse(isValid(funcionario, "E-mail nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_email_vazio() {
		funcionario.setEmail("");
		assertFalse(isValid(funcionario, "E-mail nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_email_em_branco() {
		funcionario.setEmail("        ");
		assertFalse(isValid(funcionario, "E-mail nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void deve_aceitar_funcionario_com_email_valido() {
		funcionario.setEmail("email@empresa.com");
		assertTrue(funcionario.getEmail().equals("email@empresa.com"));
	}

	@Test
	public void nao_deve_aceitar_funcionario_com_email_invalido_sem_arroba() {
		funcionario.setEmail("funcionario.123.com.br");
		assertFalse(isValid(funcionario, "E-mail invalido"));

	}

	@Test
	public void nao_deve_aceitar_funcionario_com_email_invalido_com_espaco() {
		funcionario.setEmail("funcionario @123.com");
		assertFalse(isValid(funcionario, "E-mail invalido"));
	}

	@Test
	public void nao_deve_aceitar_funcionario_com_email_invalido_com_espaco_e_sem_arroba() {
		funcionario.setEmail("funcionario .123.com");
		assertFalse(isValid(funcionario, "E-mail invalido"));
	}

	@Test
	public void nao_deve_aceitar_email_invalido_com_espaco_e_com_mais_de_um_arroba() {
		funcionario.setEmail("funcionario @@123.com");
		assertFalse(isValid(funcionario, "E-mail invalido"));
	}

	@Test
	public void nao_deve_aceitar_email_com_mais_de_um_arroba() {
		funcionario.setEmail("aa@@.com.br");
		assertFalse(isValid(funcionario, "E-mail invalido"));
	}
	
	/**
	 * Testes de Funcionario
	 **/
	
	@Test
	public void deve_acertar_que_funcionarios_iguais_tem_o_mesmo_hash_code() {
		funcionario2 = funcionario;
		assertTrue(funcionario.hashCode() == funcionario2.hashCode());
	}
	
	@Test
	public void nao_deve_aceitar_que_funcionarios_iguais_tenham_hashcodes_diferentes() {
		funcionario2 = funcionario;
		assertFalse(funcionario.hashCode() != funcionario2.hashCode());
	}
	
	@Test
	public void deve_acertar_que_funcionarios_diferentes_tenham_hashcodes_diferentes() {
		funcionario.setCpf("22187618072");
		assertTrue(funcionario.hashCode() != funcionario2.hashCode());
	}
	
	@Test
	public void nao_deve_aceitar_que_funcionarios_diferentes_tenham_hashcodes_iguais() {
		funcionario.setCpf("22187618072");
		assertFalse(funcionario.hashCode() == funcionario2.hashCode());
	}
	
	@Test
	public void deve_fazer_to_string_de_funcionario() {
		System.out.println(funcionario.toString());
	}
	
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Funcionario.class, hasValidGettersAndSetters());
	}

	@Test
	public void deve_respeitar_hash_code() {
		assertThat(Funcionario.class, BeanMatchers.hasValidBeanHashCode());
	}

	@Test
	public void deve_respeitar_equals() {
		assertThat(Funcionario.class, BeanMatchers.hasValidBeanEquals());
	}
	
//	public void gerarData() {
//		registerValueGenerator(new ValueGenerator<DateTime>() {
//			public DateTime generate() {
//				return new DateTime(new Random().nextLong()).withMillisOfSecond(0);
//			}
//		}, DateTime.class);
//	}

}
