package funcionariotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.funcionario.FixtureFuncionario;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.six2six.fixturefactory.Fixture;

public class FuncionarioTest {
	
	private Funcionario funcionario;
	
	private Validator validator;

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	@BeforeClass
	public static void init() {
		FixtureFuncionario.fakeFuncionario();
	}
	
	@Before
	public void init2() {	
		funcionario = Fixture.from(Funcionario.class).gimme("valido");
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
	 * */
	
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
	public void nao_deve_aceitar_funcionario_com_data_de_nascimento_em_branco() {
		fail();
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_data_de_nascimento_no_futuro() {
		
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_menos_de_16_anos() {
		
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
		
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_vazio() {
		
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_salario_em_branco() {
		
	}
	
	/**
	 * Testes de Endereco
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_endereco_nulo() {
		
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_endereco_vazio() {
		
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_endereco_em_branco() {
		
	}
	
	/**
	 * Testes de Telefone
	 * */
	
	@Test
	public void nao_deve_aceitar_funcionario_com_telefone_nulo() {
		
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_telefone_vazio() {
		
	}
	
	@Test
	public void nao_deve_aceitar_funcionario_com_telefone_em_branco() {
		
	}

}
