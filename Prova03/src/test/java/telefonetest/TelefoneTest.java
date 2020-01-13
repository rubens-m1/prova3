package telefonetest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.telefone.DDD;
import br.com.contmatic.empresa.telefone.FixtureTelefone;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

// TODO: Auto-generated Javadoc
/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

	/** The telefone. */
	private Telefone telefone;
	
	/**
	 * Inits the.
	 */
	@BeforeClass
	public static void init() {
		FixtureTelefone.fakeTelefone();
	}
	
	/**
	 * Inits the 2.
	 */
	@Before
	public void init2() {
		telefone = Fixture.from(Telefone.class).gimme("valido");
	}

	/**
	 * Nao deve aceitar telefone com ddd nulo.
	 */
	@Test
	public void nao_deve_aceitar_telefone_com_ddd_nulo() {
		telefone.setDdd(null);
		assertFalse(Utilidades.isValid(telefone, "ddd nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	/**
	 * Deve aceitar ddd valido esperado.
	 */
	@Test
	public void deve_aceitar_ddd_valido_esperado() {
		telefone.setDdd(DDD.DDD11);
		assertTrue(telefone.getDdd().equals(DDD.DDD11));
	} 

	/**
	 * Nao deve aceitar ddd valido diferente do esperado.
	 */
	@Test
	public void nao_deve_aceitar_ddd_valido_diferente_do_esperado() {
		telefone.setDdd(DDD.DDD11);
		assertFalse(telefone.getDdd().equals(DDD.DDD12));
	}
	
	/**
	 * Nao deve aceitar numero nulo.
	 */
	@Test
	public void nao_deve_aceitar_numero_nulo() {
		telefone.setNumero(null);
		assertFalse(Utilidades.isValid(telefone, "numero nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	/**
	 * Nao deve aceitar numero vazio.
	 */
	@Test
	public void nao_deve_aceitar_numero_vazio() {
		telefone.setNumero("");
		assertFalse(Utilidades.isValid(telefone, "numero nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	/**
	 * Nao deve aceitar numero somente com espacos.
	 */
	@Test
	public void nao_deve_aceitar_numero_somente_com_espacos() {
		telefone.setNumero("          ");
		assertFalse(Utilidades.isValid(telefone, "numero nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	/**
	 * Deve aceitar numero valido de 8 digitos.
	 */
	@Test
	public void deve_aceitar_numero_valido_de_8_digitos() {
		telefone.setNumero("98765432");
		assertTrue(telefone.getNumero().equals("98765432"));
	}
	
	/**
	 * Deve aceitar numero valido de 9 digitos.
	 */
	@Test
	public void deve_aceitar_numero_valido_de_9_digitos() {
		telefone.setNumero("987654321");
		assertTrue(telefone.getNumero().equals("987654321"));
	}

	/**
	 * Numero nao pode ter menos de 8 digitos.
	 */
	@Test
	public void numero_nao_pode_ter_menos_de_8_digitos() {
		telefone.setNumero("1");
		assertFalse(Utilidades.isValid(telefone, "numero deve conter 8 ou 9 digitos"));
	}

	/**
	 * Numero nao pode ter menos de 8 digitos incluindo os 0.
	 */
	@Test
	public void numero_nao_pode_ter_menos_de_8_digitos_incluindo_os_0() {
		telefone.setNumero("01234567");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}

	/**
	 * Deve aceitar valor minimo de 8 digitos.
	 */
	@Test
	public void deve_aceitar_valor_minimo_de_8_digitos() {
		telefone.setNumero("10000000");
		assertTrue(Utilidades.isValid(telefone, "1000000"));
		}

	/**
	 * De aceitar valor maximo de 8 digitos.
	 */
	@Test
	public void de_aceitar_valor_maximo_de_8_digitos() {
		telefone.setNumero("99999999");
		assertTrue(Utilidades.isValid(telefone, "99999999"));
	}

	/**
	 * Numero nao pode ter mais de 9 digitos.
	 */
	@Test
	public void numero_nao_pode_ter_mais_de_9_digitos() {
		telefone.setNumero("1000000000");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}

	/**
	 * Numero nao pode ter mais de 9 digitos incluindo os 0.
	 */
	@Test
	public void numero_nao_pode_ter_mais_de_9_digitos_incluindo_os_0() {
		telefone.setNumero("00100000000");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}
	
	/**
	 * Deve aceitar numero valido com oito digitos comprimento.
	 */
	@Test
	public void deve_aceitar_numero_valido_com_oito_digitos_comprimento() {
		telefone.setNumero("98765432");
		assertThat(String.valueOf(telefone.getNumero()).length(), is(8));
	}
		
	/**
	 * Deve aceitar numero valido com nove digitos comprimento.
	 */
	@Test
	public void deve_aceitar_numero_valido_com_nove_digitos_comprimento() {
		telefone.setNumero("987654321");
		assertThat(String.valueOf(telefone.getNumero()).length(), is(9));
	}
	
	/**
	 * Nao deve aceitar numero invalido com nove digitos.
	 */
	@Test
	public void nao_deve_aceitar_numero_invalido_com_nove_digitos() {
		telefone.setNumero("123456789");
		assertThat(String.valueOf(telefone.getNumero()).length(), is(9));
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}

	/**
	 * Deve aceitar numero maximo com 9 digitos.
	 */
	@Test
	public void deve_aceitar_numero_maximo_com_9_digitos() {
		telefone.setNumero("999999999");
		assertTrue(Utilidades.isValid(telefone, "999999999"));
	}
	
	/**
	 * Nao deve aceitar numero com numeros e letras.
	 */
	@Test
	public void nao_deve_aceitar_numero_com_numeros_e_letras() {
		telefone.setNumero("99999999a");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}
	
	/**
	 * Nao deve aceitar numero somente letras.
	 */
	@Test
	public void nao_deve_aceitar_numero_somente_letras() {
		telefone.setNumero("aaaaaaaaa");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}
	
	
	/**
	 * Deve aceitar ramal pode ser nulo.
	 */
	@Test
	public void deve_aceitar_ramal_pode_ser_nulo() {
		telefone.setRamal(null);
		assertTrue(telefone.getRamal() == null);
	}
	
	/**
	 * Deve aceitar ramal vazio.
	 */
	@Test
	public void deve_aceitar_ramal_vazio() {
		telefone.setRamal("");
		assertTrue(telefone.getRamal().equals(""));
	}

	/**
	 * Deve aceitar ramal 0.
	 */
	@Test
	public void deve_aceitar_ramal_0() {
		telefone.setRamal("0");
		assertTrue(telefone.getRamal().equals("0"));
	}

	/**
	 * Nao deve aceitar ramal maior que 99999999.
	 */
	@Test
	public void nao_deve_aceitar_ramal_maior_que_99999999() {
		telefone.setRamal("10000000");
		assertFalse(Utilidades.isValid(telefone, "ramal nao pode ser maior que 9999999"));
	}

	/**
	 * Nao deve aceitar ramal menor que 0.
	 */
	@Test
	public void nao_deve_aceitar_ramal_menor_que_0() {
		telefone.setRamal("-11");
		assertFalse(Utilidades.isValid(telefone, "ramal nao pode ser menor que 0"));
	}
	
	/**
	 * Test tostring.
	 */
	@Test
	public void test_tostring() {
		telefone.setNumero("987654321");
		assertTrue(telefone.toString().contains("987654321"));
	}
	
	/**
	 * Deve respeitar os gets sets.
	 */
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Telefone.class, hasValidGettersAndSetters());
	}
	
	/**
	 * Deve respeitar equals.
	 */
	@Test
	public void deve_respeitar_equals() {
		fail();
	}

}
