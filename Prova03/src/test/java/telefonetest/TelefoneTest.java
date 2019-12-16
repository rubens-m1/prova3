package telefonetest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.telefone.DDD;
import br.com.contmatic.empresa.telefone.FixtureTelefone;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

public class TelefoneTest {

	private Telefone telefone;
	
	@BeforeClass
	public static void init() {
		FixtureTelefone.fakeTelefone();
	}
	
	@Before
	public void init2() {
		telefone = Fixture.from(Telefone.class).gimme("valido");
	}
	


	@Test
	public void nao_deve_aceitar_telefone_com_ddd_nulo() {
		telefone.setDdd(null);
		assertFalse(Utilidades.isValid(telefone, "ddd nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	@Test
	public void deve_aceitar_ddd_valido_esperado() {
		telefone.setDdd(DDD.DDD11);
		assertTrue(telefone.getDdd().equals(DDD.DDD11));
	} 

	@Test
	public void nao_deve_aceitar_ddd_valido_diferente_do_esperado() {
		telefone.setDdd(DDD.DDD11);
		assertFalse(telefone.getDdd().equals(DDD.DDD12));
	}
	
	@Test
	public void nao_deve_aceitar_numero_nulo() {
		telefone.setNumero(null);
		assertFalse(Utilidades.isValid(telefone, "numero nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	@Test
	public void nao_deve_aceitar_numero_vazio() {
		telefone.setNumero("");
		assertFalse(Utilidades.isValid(telefone, "numero nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	@Test
	public void nao_deve_aceitar_numero_somente_com_espacos() {
		telefone.setNumero("          ");
		assertFalse(Utilidades.isValid(telefone, "numero nao pode ser nulo, vazio ou conter somente espaços"));
	}
	
	@Test
	public void deve_aceitar_numero_valido_de_8_digitos() {
		telefone.setNumero("98765432");
		assertTrue(telefone.getNumero().equals("98765432"));
	}
	
	@Test
	public void deve_aceitar_numero_valido_de_9_digitos() {
		telefone.setNumero("987654321");
		assertTrue(telefone.getNumero().equals("987654321"));
	}

	@Test
	public void numero_nao_pode_ter_menos_de_8_digitos() {
		telefone.setNumero("1");
		assertFalse(Utilidades.isValid(telefone, "numero deve conter 8 ou 9 digitos"));
	}

	@Test
	public void numero_nao_pode_ter_menos_de_8_digitos_incluindo_os_0() {
		telefone.setNumero("01234567");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}

	@Test
	public void deve_aceitar_valor_minimo_de_8_digitos() {
		telefone.setNumero("10000000");
		assertTrue(Utilidades.isValid(telefone, "1000000"));
		}

	@Test
	public void de_aceitar_valor_maximo_de_8_digitos() {
		telefone.setNumero("99999999");
		assertTrue(Utilidades.isValid(telefone, "99999999"));
	}

	@Test
	public void numero_nao_pode_ter_mais_de_9_digitos() {
		telefone.setNumero("1000000000");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}

	@Test
	public void numero_nao_pode_ter_mais_de_9_digitos_incluindo_os_0() {
		telefone.setNumero("00100000000");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}
	
	@Test
	public void deve_aceitar_numero_valido_com_oito_digitos_comprimento() {
		telefone.setNumero("98765432");
		assertThat(String.valueOf(telefone.getNumero()).length(), is(8));
	}
		
	@Test
	public void deve_aceitar_numero_valido_com_nove_digitos_comprimento() {
		telefone.setNumero("987654321");
		assertThat(String.valueOf(telefone.getNumero()).length(), is(9));
	}
	
	@Test
	public void nao_deve_aceitar_numero_invalido_com_nove_digitos() {
		telefone.setNumero("123456789");
		assertThat(String.valueOf(telefone.getNumero()).length(), is(9));
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}

	@Test
	public void deve_aceitar_numero_maximo_com_9_digitos() {
		telefone.setNumero("999999999");
		assertTrue(Utilidades.isValid(telefone, "999999999"));
	}
	
	@Test
	public void nao_deve_aceitar_numero_com_numeros_e_letras() {
		telefone.setNumero("99999999a");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}
	
	@Test
	public void nao_deve_aceitar_numero_somente_letras() {
		telefone.setNumero("aaaaaaaaa");
		assertFalse(Utilidades.isValid(telefone, "formato de telefone invalido"));
	}
	
	
	@Test
	public void deve_aceitar_ramal_pode_ser_nulo() {
		telefone.setRamal(null);
		assertTrue(telefone.getRamal() == null);
	}
	
	@Test
	public void deve_aceitar_ramal_vazio() {
		telefone.setRamal("");
		assertTrue(telefone.getRamal().equals(""));
	}

	@Test
	public void deve_aceitar_ramal_0() {
		telefone.setRamal("0");
		assertTrue(telefone.getRamal().equals("0"));
	}

	@Test
	public void nao_deve_aceitar_ramal_maior_que_99999999() {
		telefone.setRamal("10000000");
		assertFalse(Utilidades.isValid(telefone, "ramal nao pode ser maior que 9999999"));
	}

	@Test
	public void nao_deve_aceitar_ramal_menor_que_0() {
		telefone.setRamal("-11");
		assertFalse(Utilidades.isValid(telefone, "ramal nao pode ser menor que 0"));
	}
	
	
//	@Test
//	public void deve_imprimir_tostring() {
//		System.out.println(telefone.toString());
//	}
	
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Telefone.class, hasValidGettersAndSetters());
	}

}
