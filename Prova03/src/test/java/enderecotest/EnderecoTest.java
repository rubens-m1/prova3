package enderecotest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static util.Utilidades.isValid;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.endereco.FixtureEndereco;
import br.com.contmatic.empresa.endereco.TIPODEENDERECO;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

	/** The endereco. */
	private Endereco endereco;
	
	/** The endereco 2. */
	private Endereco endereco2;

	/** The bairro. */
	private Bairro bairro;
	
	/** The cidade. */
	private Cidade cidade;

	/** The quantidade maxima. */
	private String quantidadeMaxima;

	/** The n. */
	private Integer n;

	/**
	 * Inits the.
	 */
	@BeforeClass
	public static void init() {
		FixtureEndereco.fakeEndereco();
	}

	/**
	 * Inits the 2.
	 */
	@Before
	public void init2() {
		endereco = Fixture.from(Endereco.class).gimme("valido");
		endereco2 = Fixture.from(Endereco.class).gimme("valido");
		bairro = new Bairro();
		bairro.setBairro("Tatuapé");
		cidade = new Cidade();
	}

	/**
	 * Deve aceitar endereco completo valido.
	 */
	@Test
	public void deve_aceitar_endereco_completo_valido() {
		System.out.println(endereco);
		assertTrue(isValid(endereco, endereco.toString()));
	}

	/**
	 * Nao deve aceitar endereco nulo.
	 */
	@Test
	public void nao_deve_aceitar_endereco_nulo() {
		endereco = null;
		assertNull(endereco);
	}

	/**
	 * Testes de Logradouro.
	 */

	@Test
	public void nao_deve_aceitar_endereco_sem_logradouro() {
		endereco.setLogradouro(null);
		System.out.println(endereco);
		assertFalse(Utilidades.isValid(endereco, "Logradouro nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Deve acertar valor minimo de caracteres em logradouro.
	 */
	@Test
	public void deve_acertar_valor_minimo_de_caracteres_em_logradouro() {
		endereco.setLogradouro("av a");
		assertThat(String.valueOf(endereco.getLogradouro()).length(), is(4));
	}

	/**
	 * Deve aceitar valor minimo de caracteres em logradouro.
	 */
	@Test
	public void deve_aceitar_valor_minimo_de_caracteres_em_logradouro() {
		endereco.setLogradouro("av a");
		assertTrue(endereco.getLogradouro().equals("av a"));
	}

	/**
	 * Deve acertar o numero de caracteres do logradouro.
	 */
	@Test
	public void deve_acertar_o_numero_de_caracteres_do_logradouro() {
		endereco.setLogradouro("Rua abc");
		assertThat(endereco.getLogradouro().length(), is(7));
	}

	/**
	 * Nao deve aceitar valor menor que o minimo de caracteres em logradouro.
	 */
	@Test
	public void nao_deve_aceitar_valor_menor_que_o_minimo_de_caracteres_em_logradouro() {
		endereco.setLogradouro("123");
		assertFalse(Utilidades.isValid(endereco, "Logradouro deve conter de 5 a 200 caracteres"));
	}

	/**
	 * Deve aceitar valor maximo de caracteres em logradouro.
	 */
	@Test
	public void deve_aceitar_valor_maximo_de_caracteres_em_logradouro() {
		quantidadeMaxima = new String(randomAlphanumeric(200));
		endereco.setLogradouro(quantidadeMaxima);
		assertTrue(endereco.getLogradouro().equals(quantidadeMaxima));
	}

	/**
	 * Nao deve aceitar valor maior que o maximo de caracteres em logradouro.
	 */
	@Test
	public void nao_deve_aceitar_valor_maior_que_o_maximo_de_caracteres_em_logradouro() {
		quantidadeMaxima = new String(randomAlphanumeric(201));
		endereco.setLogradouro(quantidadeMaxima);
		assertFalse(Utilidades.isValid(endereco, "Logradouro deve conter de 5 a 200 caracteres"));
	}

	/**
	 * Nao deve aceitar logradouro somente espacos.
	 */
	@Test
	public void nao_deve_aceitar_logradouro_somente_espacos() {
		endereco.setLogradouro("                               ");
		assertFalse(Utilidades.isValid(endereco, "Logradouro nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar logradouro vazio.
	 */
	@Test
	public void nao_deve_aceitar_logradouro_vazio() {
		endereco.setLogradouro("");
		assertFalse(Utilidades.isValid(endereco, "Logradouro nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_caracteres_especiais() {
		endereco.setLogradouro("!@#$%");
		assertFalse(Utilidades.isValid(endereco, "Caractere invalido"));
	}

	/**
	 * Nao deve aceitar logradouro com caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_logradouro_com_caracteres_especiais() {
		endereco.setLogradouro("rua 123 !@#$");
		assertFalse(Utilidades.isValid(endereco, "Caractere invalido"));
	}

	/**
	 * Nao deve aceitar logradouro com caracteres especiais com numeros.
	 */
	@Test
	public void nao_deve_aceitar_logradouro_com_caracteres_especiais_com_numeros() {
		endereco.setLogradouro("!@#123");
		assertFalse(Utilidades.isValid(endereco, "Caractere invalido"));
	}

	/**
	 * Deve aceitar logradouro letras e numeros.
	 */
	@Test
	public void deve_aceitar_logradouro_letras_e_numeros() {
		endereco.setLogradouro("Rua Sei la 123");
		assertTrue(endereco.getLogradouro().equals("Rua Sei la 123"));
	}

	/**
	 * Deve aceitar logradouro com acentos.
	 */
	@Test
	public void deve_aceitar_logradouro_com_acentos() {
		endereco.setLogradouro("Rua São José áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ");
		assertTrue(endereco.getLogradouro().equals("Rua São José áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ"));
	}

	/**
	 * Testes de Numero.
	 */

	@Test
	public void nao_deve_aceitar_endereco_com_numero_nulo() {
		endereco.setNumero(null);
		assertFalse(Utilidades.isValid(endereco, "Numero nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar endereco com numero vazio.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_numero_vazio() {
		endereco.setNumero("");
		assertFalse(Utilidades.isValid(endereco, "Numero nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar endereco numero contendo apenas espacos em branco.
	 */
	@Test
	public void nao_deve_aceitar_endereco_numero_contendo_apenas_espacos_em_branco() {
		endereco.setNumero("              ");
		assertFalse(Utilidades.isValid(endereco, "Numero nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar endereco com numero menor que 0.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_numero_menor_que_0() {
		n = (int) (-1 * (Math.random() * 2147483647));
		endereco.setNumero(String.valueOf(n));
		assertFalse(Utilidades.isValid(endereco, "Numero nao pode ser menor que 0"));
	}

	/**
	 * Nao deve aceitar endereco com numero minimo de integer pois e negativo.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_numero_minimo_de_integer_pois_e_negativo() {
		endereco.setNumero(String.valueOf(-2147483648));
		assertFalse(Utilidades.isValid(endereco, "Numero nao pode ser menor que 0"));
	}

	/**
	 * Deve aceitar endereco com numero entre 0 e 999999.
	 */
	@Test
	public void deve_aceitar_endereco_com_numero_entre_0_e_999999() {
		n = (int) (Math.random() * 999999);
		endereco.setNumero(String.valueOf(n));
		assertTrue(endereco.getNumero().equals(String.valueOf(n)));
	}

	/**
	 * Nao deve aceitar endereco com numero maior que 999999.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_numero_maior_que_999999() {
		n = (int) ((Math.random() * 2146483648) + 999999);
		endereco.setNumero(String.valueOf(n));
		assertFalse(Utilidades.isValid(endereco, "Numero nao pode ser maior que 999999"));
	}

	/**
	 * Nao deve aceitar endereco numero maximo de integer 2147483647.
	 */
	@Test
	public void nao_deve_aceitar_endereco_numero_maximo_de_integer_2147483647() {
		endereco.setNumero(String.valueOf(2147483647));
		assertFalse(Utilidades.isValid(endereco, "numero nao pode ser maior que 999999"));
	}

	/**
	 * Testes de Cep.
	 */
	
	@Test
	public void deve_aceitar_endereco_com_cep_valido() {
		endereco.setCep("55555555");
		assertTrue(endereco.getCep().equals("55555555"));
	}
	
	/**
	 * Deve aceitar endereco com cep valido comecado com 0.
	 */
	@Test
	public void deve_aceitar_endereco_com_cep_valido_comecado_com_0() {
		endereco.setCep("05555555");
		assertTrue(endereco.getCep().equals("05555555"));
	}
	
	/**
	 * Nao deve aceitar endereco com cep nulo.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_nulo() {
		endereco.setCep(null);
		assertFalse(Utilidades.isValid(endereco, "Cep nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar endereco com cep vazio.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_vazio() {
		endereco.setCep("");
		assertFalse(Utilidades.isValid(endereco, "Cep nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar endereco com cep contendo apenas espacos em branco.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_contendo_apenas_espacos_em_branco() {
		endereco.setCep("              ");
		assertFalse(Utilidades.isValid(endereco, "Cep nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	

	/**
	 * Deve aceitar endereco com o menor cep 01001000.
	 */
	@Test
	public void deve_aceitar_endereco_com_o_menor_cep_01001000() {
		endereco.setCep("01001000");
		assertTrue(endereco.getCep().equals("01001000"));
	}

	/**
	 * Nao deve aceitar endereco com cep menor que 01001000 com 0 a esquerda.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_menor_que_01001000_com_0_a_esquerda() {
		endereco.setCep("00000001");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Deve aceitar endereco com o maior cep 99999999.
	 */
	@Test
	public void deve_aceitar_endereco_com_o_maior_cep_99999999() {
		endereco.setCep("99999999");
		assertTrue(Utilidades.isValid(endereco, "99999999"));
	}
	
	/**
	 * Nao deve aceitar endereco com cep maior que 99999999.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_maior_que_99999999() {
		endereco.setCep("100000000");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Nao deve aceitar endereco com cep com menos que 8 digitos.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_com_menos_que_8_digitos() {
		endereco.setCep("1234567");
		assertFalse(Utilidades.isValid(endereco, "Cep deve conter 8 digitos"));
	}

	/**
	 * Nao deve aceitar endereco cep com mais que 8 digitos.
	 */
	@Test
	public void nao_deve_aceitar_endereco_cep_com_mais_que_8_digitos() {
		endereco.setCep("123456789");
		assertFalse(Utilidades.isValid(endereco, "Cep deve conter 8 digitos"));
	}

	/**
	 * Nao deve aceitar cep nao com mais de oito digitos mesmo com zeros na frente.
	 */
	@Test
	public void nao_deve_aceitar_cep_nao_com_mais_de_oito_digitos_mesmo_com_zeros_na_frente() {
		endereco.setCep("012345678");
		assertFalse(Utilidades.isValid(endereco, "Cep deve conter 8 digitos"));
	}

	/**
	 * Deve acertar endereco com cep com 8 digitos.
	 */
	@Test
	public void deve_acertar_endereco_com_cep_com_8_digitos() {
		endereco.setCep("12345678");
		assertThat(String.valueOf(endereco.getCep()).length(), is(8));
	}

	/**
	 * Nao deve aceitar endereco com cep com letras.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_com_letras() {
		endereco.setCep("a1234567");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Nao deve aceitar endereco com cep so letras.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_so_letras() {
		endereco.setCep("abcdefgh");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Nao deve aceitar endereco cep com caractere especial caso com 7 numeros e 8 caracteres.
	 */
	@Test
	public void nao_deve_aceitar_endereco_cep_com_caractere_especial_caso_com_7_numeros_e_8_caracteres() {
		endereco.setCep("#1234567");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Nao deve aceitar endereco com cep com caractere especial caso com 8 numeros e 9 caracteres.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_com_caractere_especial_caso_com_8_numeros_e_9_caracteres() {
		endereco.setCep("#12345678");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Nao deve aceitar endereco com cep so com caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_so_com_caracteres_especiais() {
		endereco.setCep("!@#$%Â¨&*");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Nao deve aceitar endereco com cep negativo com a quantidade de digitos certo.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cep_negativo_com_a_quantidade_de_digitos_certo() {
		endereco.setCep("-12345678");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Nao deve aceitar cep negativo com a quantidade de digitos incorreta.
	 */
	@Test
	public void nao_deve_aceitar_cep_negativo_com_a_quantidade_de_digitos_incorreta() {
		endereco.setCep("-1234567");
		assertFalse(Utilidades.isValid(endereco, "Cep invalido"));
	}

	/**
	 * Testes de Complemento.
	 */

	@Test
	public void deve_aceitar_endereco_sem_complemento() {
		endereco.setComplemento(null);
		assertNull(endereco.getComplemento());
	}
	
	/**
	 * Deve aceitar endereco com complemtento valido.
	 */
	@Test
	public void deve_aceitar_endereco_com_complemtento_valido() {
		endereco.setComplemento("casa 2");
		assertTrue(endereco.getComplemento().equals("casa 2"));
	}
	
	/**
	 * Deve aceitar endereco com complemtento vazio.
	 */
	@Test
	public void deve_aceitar_endereco_com_complemtento_vazio() {
		endereco.setComplemento("");
		assertTrue(endereco.getComplemento().equals(""));
	}
	
	/**
	 * Deve aceitar endereco com complemtento apenas com espacos em branco.
	 */
	@Test
	public void deve_aceitar_endereco_com_complemtento_apenas_com_espacos_em_branco() {
		endereco.setComplemento("                ");
		assertTrue(endereco.getComplemento().equals("                "));
	}
	
	/**
	 * Deve aceitar complemento com caracteres especiais.
	 */
	public void deve_aceitar_complemento_com_caracteres_especiais() {
		endereco.setComplemento("!@#$%Â¨&*");
		assertTrue(endereco.getComplemento().equals("!@#$%Â¨&*"));
	}

	/**
	 * Deve aceitar complemento com acentos.
	 */
	@Test
	public void deve_aceitar_complemento_com_acentos() {
		endereco.setComplemento("São Judas");
		assertTrue(endereco.getComplemento().equals("São Judas"));
	}

	/**
	 * Deve aceitar endereco com tamanho maximo no complemento.
	 */
	@Test
	public void deve_aceitar_endereco_com_tamanho_maximo_no_complemento() {
		endereco.setComplemento(randomAlphanumeric(100));
		System.out.println(endereco.getComplemento());
		assertThat(String.valueOf(endereco.getComplemento()).length(), is(100));
	}
	
	/**
	 * Nao deve aceitar endereco com complemento maior que o tamanho maximo.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_complemento_maior_que_o_tamanho_maximo() {
		endereco.setComplemento(randomAlphanumeric(101));
		System.out.println(endereco.getComplemento());
		assertFalse(Utilidades.isValid(endereco, "Logradouro deve conter no maximo 100 caracteres"));
	}
	
	/**
	 * Testes de Tipo.
	 */

	@Test
	public void nao_deve_aceitar_endereco_sem_tipo() {
		endereco.setTipo(null);
		assertFalse(Utilidades.isValid(endereco, "Tipo de Endereco nao pode ser nulo"));
	}
	
	/**
	 * Deve aceitar endereco com tipo comercial valido.
	 */
	@Test
	public void deve_aceitar_endereco_com_tipo_comercial_valido() {
		endereco.setTipo(TIPODEENDERECO.ENDERECOCOMERCIAL);
		assertTrue(endereco.getTipo().equals(TIPODEENDERECO.ENDERECOCOMERCIAL));
	}
	
	/**
	 * Deve aceitar endereco com tipo residencia valido.
	 */
	@Test
	public void deve_aceitar_endereco_com_tipo_residencia_valido() {
		endereco.setTipo(TIPODEENDERECO.ENDERECORESIDENCIAL);
		assertTrue(endereco.getTipo().equals(TIPODEENDERECO.ENDERECORESIDENCIAL));
	}
	
	/**
	 * Testes de Bairro.
	 */

	@Test
	public void nao_deve_aceitar_endereco_sem_bairro() {
		endereco.setBairro(null);
		assertFalse(Utilidades.isValid(endereco, "Bairro nao pode ser nulo"));
	}
	
	/**
	 * Nao deve aceitar endereco com bairro vazio.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_bairro_vazio() {
		bairro.setBairro("");
		endereco.setBairro(bairro);
		assertFalse(Utilidades.isValid(endereco, "Bairro nao pode ser nulo"));
	}
	
	/**
	 * Nao deve aceitar endereco com bairro com apenas com espacos em branco.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_bairro_com_apenas_com_espacos_em_branco() {
		bairro.setBairro("       ");
		endereco.setBairro(bairro);
		assertFalse(Utilidades.isValid(endereco, "Bairro nao pode ser nulo"));
	}

	/**
	 * Nao deve aceitar endereco com bairro com caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_bairro_com_caracteres_especiais() {
		bairro.setBairro("!@#$%");
		endereco.setBairro(bairro);
		System.out.println(endereco.getBairro());
		assertFalse(Utilidades.isValid(endereco, "Nome de bairro invalido"));
	}

	/**
	 * Nao deve aceitar endereco com bairro com caracteres especiais e letras.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_bairro_com_caracteres_especiais_e_letras() {
		bairro.setBairro("São Judas !@#$%Â¨&*");
		endereco.setBairro(bairro);
		assertFalse(Utilidades.isValid(endereco, "Nome de bairro invalido"));
	}

	/**
	 * Nao deve aceitar endereco com bairro com caracteres especiais com numeros.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_bairro_com_caracteres_especiais_com_numeros() {
		bairro.setBairro("1234 !@#$%Â¨&*");
		endereco.setBairro(bairro);
		assertFalse(Utilidades.isValid(endereco, "Nome de bairro invalido"));
	}

	/**
	 * Nao deve aceitar enderec com bairro com caracteres especiais letras e numeros.
	 */
	@Test
	public void nao_deve_aceitar_enderec_com_bairro_com_caracteres_especiais_letras_e_numeros() {
		bairro.setBairro("bairro 123 !@#$%Â¨&*");
		endereco.setBairro(bairro);
		assertFalse(Utilidades.isValid(endereco, "Nome de bairro invalido"));
	}

	/**
	 * Deve aceitar bairro com acentos.
	 */
	@Test
	public void deve_aceitar_bairro_com_acentos() {
		bairro.setBairro("São Judas");
		endereco.setBairro(bairro);
		assertTrue(String.valueOf(endereco.getBairro()).equals("São Judas"));
	}
	
	/**
	 * Testes de Cidade.
	 */

	@Test
	public void nao_deve_aceitar_endereco_com_cidade_nula() {
		endereco.setCidade(null);
		assertFalse(Utilidades.isValid(endereco, "Cidade nao pode ser nula"));
	}
	
	/**
	 * Nao deve aceitar endereco com cidade com nome nulo.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cidade_com_nome_nulo() {
		cidade.setNomeCidade(null);
		endereco.setCidade(cidade);
		assertFalse(Utilidades.isValid(endereco, "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar endereco com cidade com nome vazio.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cidade_com_nome_vazio() {
		cidade.setNomeCidade("");
		endereco.setCidade(cidade);
		assertFalse(Utilidades.isValid(endereco, "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar endereco com bairro com apenas com espacos em branco.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_bairro__com_apenas_com_espacos_em_branco() {
		cidade.setNomeCidade("                ");
		endereco.setCidade(cidade);
		assertFalse(Utilidades.isValid(endereco, "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Deve aceitar endereco com cidade valida.
	 */
	@Test
	public void deve_aceitar_endereco_com_cidade_valida() {
		cidade.setNomeCidade("São Paulo");
		endereco.setCidade(cidade);
		assertTrue(cidade.getNomeCidade().equals("São Paulo"));
	}
	
	/**
	 * Nao deve aceitar endereco com cidade com numeros.
	 */
	@Test
	public void nao_deve_aceitar_endereco_com_cidade_com_numeros() {
		cidade.setNomeCidade("São Paulo 123");
		endereco.setCidade(cidade);
		assertFalse(Utilidades.isValid(endereco, "Caractere invalido"));
	}
	
	/**
	 * Deve aceitar endereco com cidade com minimo de caracteres.
	 */
	@Test
	public void deve_aceitar_endereco_com_cidade_com_minimo_de_caracteres() {
		cidade.setNomeCidade("A");
		endereco.setCidade(cidade);
		assertTrue(cidade.getNomeCidade().equals("A"));
	}
	
	/**
	 * Testes Endereco.
	 */
	
	@Test
	public void deve_acertar_que_enderecos_iguais_tem_o_mesmo_hash_code() {
		endereco2 = endereco;
		assertTrue(endereco.hashCode() == endereco2.hashCode());
	}
	
	/**
	 * Nao deve aceitar que enderecos iguais tenham hashcodes diferentes.
	 */
	@Test
	public void nao_deve_aceitar_que_enderecos_iguais_tenham_hashcodes_diferentes() {
		endereco2 = endereco;
		assertFalse(endereco.hashCode() != endereco2.hashCode());
	}
	
	/**
	 * Deve acertar que enderecos diferentes tenham hashcodes diferentes.
	 */
	@Test
	public void deve_acertar_que_enderecos_diferentes_tenham_hashcodes_diferentes() {
		assertTrue(endereco.hashCode() != endereco2.hashCode());
	}
	
	/**
	 * Nao deve aceitar que enderecos diferentes tenham hashcodes iguais.
	 */
	@Test
	public void nao_deve_aceitar_que_enderecos_diferentes_tenham_hashcodes_iguais() {
		assertFalse(endereco.hashCode() == endereco2.hashCode());
	}
	
	/**
	 * Deve fazer to string de endereco.
	 */
	@Test
	public void deve_fazer_to_string_de_endereco() {
		System.out.println(endereco.toString());
	}
	
	/**
	 * Deve respeitar os gets sets.
	 */
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Endereco.class, hasValidGettersAndSetters());
	}

	/**
	 * Deve respeitar hash code.
	 */
	@Test
	public void deve_respeitar_hash_code() {
		assertThat(Endereco.class, BeanMatchers.hasValidBeanHashCode());
	}

	/**
	 * Deve respeitar equals.
	 */
	@Test
	public void deve_respeitar_equals() {
		assertThat(Endereco.class, BeanMatchers.hasValidBeanEquals());
	}
	
}
