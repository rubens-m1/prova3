package enderecotest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.endereco.FixtureEndereco;
import br.com.contmatic.empresa.endereco.TIPODEENDERECO;
import br.com.six2six.fixturefactory.Fixture;

public class EnderecoTest {

	private Endereco endereco;

	private Bairro bairro;

	private Set<Bairro> bairros;

	private Validator validator;

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	private String quantidadeMaxima;

	private Integer n;

	// private Bairro bairro;

	@BeforeClass
	public static void init() {
		FixtureEndereco.fakeEndereco();
	}

	@Before
	public void init2() {
		endereco = Fixture.from(Endereco.class).gimme("valido");
		bairro = new Bairro();
		bairro.setBairro("Tatuapé");
		bairros = new HashSet<>();
	}

	public boolean isValid(Endereco endereco, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Endereco>> restricoes = validator.validate(endereco);
		for (ConstraintViolation<Endereco> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}

	@Test
	public void deve_aceitar_endereco_completo_valido() {
		System.out.println(endereco);
		assertTrue(endereco.equals(endereco));
		// assertTrue(fakeEndereco.equals(fakeEndereco));
	}

	@Test
	public void nao_deve_aceitar_endereco_nulo() {
		endereco = null;
		assertNull(endereco);
	}

	/**
	 * Testes de Logradouro
	 */

	@Test
	public void nao_deve_aceitar_endereco_sem_logradouro() {
		endereco.setLogradouro(null);
		System.out.println(endereco);
		assertFalse(isValid(endereco, "Logradouro nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void deve_acertar_valor_minimo_de_caracteres_em_logradouro() {
		endereco.setLogradouro("av a");
		assertThat(String.valueOf(endereco.getLogradouro()).length(), is(4));
	}

	@Test
	public void deve_acertar_valor_minimo_de_caracteres_em_logradouro_nao_e_diferente() {
		endereco.setLogradouro("1234");
		assertNotEquals(String.valueOf(endereco.getLogradouro().length()), is(4));
		fail();
		// assertnot
		// assertThat(String.valueOf(endereco.getLogradouro()).length(), is);
	}

	@Test
	public void deve_aceitar_valor_minimo_de_caracteres_em_logradouro() {
		endereco.setLogradouro("av a");
		assertTrue(endereco.getLogradouro().equals("av a"));
	}

	@Test
	public void deve_acertar_o_numero_de_caracteres_do_logradouro() {
		fail();
	}

	@Test
	public void nao_deve_aceitar_valor_menor_que_o_minimo_de_caracteres_em_logradouro() {
		endereco.setLogradouro("123");
		assertFalse(isValid(endereco, "Logradouro deve conter de 5 a 200 caracteres"));
	}

	@Test
	public void deve_aceitar_valor_maximo_de_caracteres_em_logradouro() {
		quantidadeMaxima = new String(randomAlphanumeric(200));
		endereco.setLogradouro(quantidadeMaxima);
		assertTrue(endereco.getLogradouro().equals(quantidadeMaxima));
	}

	@Test
	public void nao_deve_aceitar_valor_maior_que_o_maximo_de_caracteres_em_logradouro() {
		quantidadeMaxima = new String(randomAlphanumeric(201));
		endereco.setLogradouro(quantidadeMaxima);
		assertFalse(isValid(endereco, "Logradouro deve conter de 5 a 200 caracteres"));
	}

	@Test
	public void nao_deve_aceitar_logradouro_somente_espacos() {
		endereco.setLogradouro("                               ");
		assertFalse(isValid(endereco, "Logradouro nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_logradouro_vazio() {
		endereco.setLogradouro("");
		assertFalse(isValid(endereco, "Logradouro nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_caracteres_especiais() {
		endereco.setLogradouro("!@#$%");
		assertFalse(isValid(endereco, "Caractere invalido"));
	}

	@Test
	public void nao_deve_aceitar_logradouro_com_caracteres_especiais() {
		endereco.setLogradouro("rua 123 !@#$");
		assertFalse(isValid(endereco, "Caractere invalido"));
	}

	@Test
	public void nao_deve_aceitar_logradouro_com_caracteres_especiais_com_numeros() {
		endereco.setLogradouro("!@#123");
		assertFalse(isValid(endereco, "Caractere invalido"));
	}

	@Test
	public void deve_aceitar_logradouro_letras_e_numeros() {
		endereco.setLogradouro("Rua Sei la 123");
		assertTrue(endereco.getLogradouro().equals("Rua Sei la 123"));
	}

	@Test
	public void deve_aceitar_logradouro_com_acentos() {
		endereco.setLogradouro("Rua São José áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ");
		assertTrue(endereco.getLogradouro().equals("Rua São José áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ"));
	}

	/**
	 * Testes de Numero
	 */

	@Test
	public void nao_deve_aceitar_endereco_com_numero_nulo() {
		endereco.setNumero(null);
		assertFalse(isValid(endereco, "Numero nao pode ser nulo"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_numero_vazio() {
		endereco.setNumero("");
		assertFalse(isValid(endereco, "Numero nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_endereco_numero_contendo_apenas_espacos_em_branco() {
		endereco.setNumero("              ");
		assertFalse(isValid(endereco, "Numero nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_numero_menor_que_0() {
		n = (int) (-1 * (Math.random() * 2147483647));
		endereco.setNumero(String.valueOf(n));
		assertFalse(isValid(endereco, "Numero nao pode ser menor que 0"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_numero_minimo_de_integer_pois_e_negativo() {
		endereco.setNumero(String.valueOf(-2147483648));
		assertFalse(isValid(endereco, "Numero nao pode ser menor que 0"));
	}

	@Test
	public void deve_aceitar_endereco_com_numero_entre_0_e_999999() {
		n = (int) (Math.random() * 999999);
		endereco.setNumero(String.valueOf(n));
		assertTrue(endereco.getNumero().equals(String.valueOf(n)));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_numero_maior_que_999999() {
		n = (int) ((Math.random() * 2146483648) + 999999);
		endereco.setNumero(String.valueOf(n));
		assertFalse(isValid(endereco, "Numero nao pode ser maior que 999999"));
	}

	@Test
	public void nao_deve_aceitar_endereco_numero_maximo_de_integer_2147483647() {
		endereco.setNumero(String.valueOf(2147483647));
		assertFalse(isValid(endereco, "numero nao pode ser maior que 999999"));
	}

	/**
	 * Testes de Cep
	 */
	
	@Test
	public void deve_aceitar_endereco_com_cep_valido() {
		endereco.setCep("04055041");
		assertTrue(endereco.getCep().equals("04055041"));
	}
	
	@Test
	public void deve_aceitar_endereco_com_cep_valido_comecado_com_0() {
		fail();
	}

	@Test
	public void deve_aceitar_endereco_com_cep_valido_comecado_com_numeros_diferentes_de_0() {
		fail();
	}
	
	@Test
	public void nao_deve_aceitar_endereco_com_cep_nulo() {
		endereco.setCep(null);
		assertFalse(isValid(endereco, "Cep nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_vazio() {
		endereco.setCep("");
		assertFalse(isValid(endereco, "Cep nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_contendo_apenas_espacos_em_branco() {
		endereco.setCep("              ");
		assertFalse(isValid(endereco, "Cep nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	

	@Test
	public void deve_aceitar_endereco_com_o_menor_cep_01001000() {
		endereco.setCep("01001000");
		assertTrue(endereco.getCep().equals("01001000"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_menor_que_01001000_com_0_a_esquerda() {
		endereco.setCep("00000001");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	@Test
	public void deve_aceitar_endereco_com_o_maior_cep_99999999() {
		endereco.setCep("99999999");
		assertTrue(isValid(endereco, "99999999"));
	}
	
	@Test
	public void nao_deve_aceitar_endereco_com_cep_maior_que_99999999() {
		endereco.setCep("100000000");
		assertFalse(isValid(endereco, "Cep invalido"));
	}
	

	@Test
	public void nao_deve_aceitar_endereco_com_cep_com_menos_que_8_digitos() {
		endereco.setCep("1234567");
		assertFalse(isValid(endereco, "Cep deve conter 8 digitos"));
	}
	

	@Test
	public void nao_deve_aceitar_endereco_cep_com_mais_que_8_digitos() {
		endereco.setCep("123456789");
		assertFalse(isValid(endereco, "Cep deve conter 8 digitos"));
	}

	@Test
	public void nao_deve_aceitar_cep_nao_com_mais_de_oito_digitos_mesmo_com_zeros_na_frente() {
		endereco.setCep("012345678");
		assertFalse(isValid(endereco, "Cep deve conter 8 digitos"));
	}

	@Test
	public void deve_acertar_endereco_com_cep_com_8_digitos() {
		endereco.setCep("12345678");
		assertThat(String.valueOf(endereco.getCep()).length(), is(8));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_com_letras() {
		endereco.setCep("a1234567");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_so_letras() {
		endereco.setCep("abcdefgh");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	@Test
	public void nao_deve_aceitar_endereco_cep_com_caractere_especial_caso_com_7_numeros_e_8_caracteres() {
		endereco.setCep("#1234567");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_com_caractere_especial_caso_com_8_numeros_e_9_caracteres() {
		endereco.setCep("#12345678");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_so_com_caracteres_especiais() {
		endereco.setCep("!@#$%Â¨&*");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_cep_negativo_com_a_quantidade_de_digitos_certo() {
		endereco.setCep("-12345678");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	@Test
	public void nao_deve_aceitar_cep_negativo_com_a_quantidade_de_digitos_incorreta() {
		endereco.setCep("-1234567");
		assertFalse(isValid(endereco, "Cep invalido"));
	}

	/**
	 * Testes de Complemento
	 */

	@Test
	public void deve_aceitar_endereco_sem_complemento() {
		endereco.setComplemento(null);
		assertNull(endereco.getComplemento());
	}
	
	@Test
	public void deve_aceitar_endereco_com_complemtento_valido() {
		endereco.setComplemento("casa 2");
		assertTrue(endereco.getComplemento().equals("casa 2"));
	}
	
	@Test
	public void deve_aceitar_endereco_com_complemtento_vazio() {
		endereco.setComplemento("");
		assertTrue(endereco.getComplemento().equals(""));
	}
	
	@Test
	public void deve_aceitar_endereco_com_complemtento_apenas_com_espacos_em_branco() {
		endereco.setComplemento("                ");
		assertTrue(endereco.getComplemento().equals("                "));
	}
	
	public void deve_aceitar_complemento_com_caracteres_especiais() {
		endereco.setComplemento("!@#$%Â¨&*");
		assertTrue(endereco.getComplemento().equals("!@#$%Â¨&*"));
	}

	@Test
	public void deve_aceitar_complemento_com_acentos() {
		endereco.setComplemento("São Judas");
		assertTrue(endereco.getComplemento().equals("São Judas"));
	}

	@Test
	public void deve_aceitar_endereco_com_tamanho_maximo_no_complemento() {
		endereco.setComplemento(randomAlphanumeric(100));
		System.out.println(endereco.getComplemento());
		assertThat(String.valueOf(endereco.getComplemento()).length(), is(100));
	}
	
	@Test
	public void nao_deve_aceitar_endereco_com_complemento_maior_que_o_tamanho_maximo() {
		endereco.setComplemento(randomAlphanumeric(101));
		System.out.println(endereco.getComplemento());
		assertFalse(isValid(endereco, "Logradouro deve conter no maximo 100 caracteres"));
	}
	
	/**
	 * Testes de Tipo
	 * */

	@Test
	public void nao_deve_aceitar_endereco_sem_tipo() {
		endereco.setTipo(null);
		assertFalse(isValid(endereco, "Tipo de Endereco nao pode ser nulo"));
	}
	
	@Test
	public void deve_aceitar_endereco_com_tipo_comercial_valido() {
		endereco.setTipo(TIPODEENDERECO.ENDERECOCOMERCIAL);
		assertTrue(endereco.getTipo().equals(TIPODEENDERECO.ENDERECOCOMERCIAL));
	}
	
	@Test
	public void deve_aceitar_endereco_com_tipo_residencia_valido() {
		endereco.setTipo(TIPODEENDERECO.ENDERECORESIDENCIAL);
		assertTrue(endereco.getTipo().equals(TIPODEENDERECO.ENDERECORESIDENCIAL));
	}
	
	/**
	 * Testes de Bairro
	 * */

	@Test
	public void nao_deve_aceitar_endereco_sem_bairro() {
		endereco.setBairro(null);
		assertFalse(isValid(endereco, "Bairro nao pode ser nulo"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_bairro_com_caracteres_especiais() {
		bairro.setBairro("!@#$%");
		endereco.setBairro(bairro);
		System.out.println(endereco.getBairro());
		assertFalse(isValid(endereco, "Nome de bairro invalido"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_bairro_com_caracteres_especiais_e_letras() {
		bairro.setBairro("São Judas !@#$%Â¨&*");
		endereco.setBairro(bairro);
		assertFalse(isValid(endereco, "Nome de bairro invalido"));
	}

	@Test
	public void nao_deve_aceitar_endereco_com_bairro_com_caracteres_especiais_com_numeros() {
		bairro.setBairro("1234 !@#$%Â¨&*");
		endereco.setBairro(bairro);
		assertFalse(isValid(endereco, "Nome de bairro invalido"));
	}

	@Test
	public void nao_deve_aceitar_enderec_com_bairro_com_caracteres_especiais_letras_e_numeros() {
		bairro.setBairro("bairro 123 !@#$%Â¨&*");
		endereco.setBairro(bairro);
		assertFalse(isValid(endereco, "Nome de bairro invalido"));
	}

	@Test
	public void deve_aceitar_bairro_com_acentos() {
		bairro.setBairro("São Judas");
		endereco.setBairro(bairro);
		assertTrue(String.valueOf(endereco.getBairro()).equals("São Judas"));
	}
	
	/**
	 * Testes de Cidade
	 * */

	@Test
	public void nao_deve_aceitar_endereco_sem_cidade() {
		endereco.setCidade(null);
		assertFalse(isValid(endereco, "Cidade nao pode ser nula"));
	}
}
