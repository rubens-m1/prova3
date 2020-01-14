package telefonetest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static util.Utilidades.isValid;

import org.junit.Test;

import br.com.contmatic.empresa.telefone.DDD;

/**
 * The Class DddTest.
 */
public class DddTest {

	/**
	 * Deve imprimir to string.
	 */
	@Test
	public void deve_conter_to_string() {
		DDD ddd = DDD.DDD11;
		assertThat(ddd.toString(), containsString("São Paulo – SP,11,DDD11,0"));
	}
	
	/**
	 * Deve acertar o valor esperado do ddd.
	 */
	@Test
	public void deve_acertar_o_valor_esperado_do_ddd() {		
		DDD ddd = DDD.DDD12;
		assertThat(ddd.getDdd(), is("12"));
	}

	/**
	 * Nao deve aceitar valor diferente do valor esperao.
	 */
	@Test
	public void nao_deve_aceitar_valor_diferente_do_valor_esperao() {
		DDD ddd = DDD.DDD13;
		assertTrue(ddd.getDdd() != ("14"));
	}
	
	/**
	 * Deve aceitar valor esperado da regiao.
	 */
	@Test
	public void deve_aceitar_valor_esperado_da_regiao() {
		DDD ddd = DDD.DDD14;
		assertThat(ddd.getRegiao(), is("Bauru – SP"));
	}
	
	/**
	 * Nao deve aceitar valor diferente do esperado da regiao.
	 */
	@Test
	public void nao_deve_aceitar_valor_diferente_do_esperado_da_regiao() {
		DDD ddd = DDD.DDD15;
		assertTrue(ddd.getRegiao() != ("Bauru – SP"));
	}

	/**
	 * Nao deve aceitar ddd nulo.
	 */
	@Test
	public void nao_deve_aceitar_ddd_nulo() {
		DDD ddd = DDD.DDD16;
		assertTrue(ddd.getDdd() != null);
	}
	
	/**
	 * Nao deve aceitar regiao nula.
	 */
	@Test
	public void nao_deve_aceitar_regiao_nula() {
		DDD ddd = DDD.DDD17;
		assertTrue(ddd.getRegiao() != null);
	}
	
	/**
	 * Deve acertar o comprimento de dois digitos no ddd.
	 */
	@Test
	public void deve_acertar_o_comprimento_de_dois_digitos_no_ddd() {
		DDD ddd = DDD.DDD45;
		assertThat(String.valueOf(ddd.getDdd()).length(), is(2));
	}
	
	/**
	 * Nao deve aceitar comprimento menor que 2 em ddd.
	 */
	@Test
	public void nao_deve_aceitar_comprimento_menor_que_2_em_ddd() {
		DDD ddd = DDD.DDD19;
		assertFalse(String.valueOf(ddd.getDdd()).length()<2);
	}
	
	/**
	 * Nao deve aceitar comprimento maior que 2 em ddd.
	 */
	@Test
	public void nao_deve_aceitar_comprimento_maior_que_2_em_ddd() {
		DDD ddd = DDD.DDD21;
		assertFalse(String.valueOf(ddd.getDdd()).length()>2);
	}
	
	/**
	 * Nao deve aceitar ddd vazio.
	 */
	@Test
	public void nao_deve_aceitar_ddd_vazio() {
		DDD ddd = DDD.DDD22;
		ddd.setDdd("");
        assertFalse(isValid(ddd, "ddd nao pode ser nulo, vazio ou conter somente espaços"));
	}

	/**
	 * Nao deve aceitar regiao vazia.
	 */
	@Test 
	public void nao_deve_aceitar_regiao_vazia() {
		DDD ddd = DDD.DDD24;
		ddd.setRegiao("");
		assertFalse(isValid(ddd, "regiao nao pode ser nulo, vazio ou conter somente espaços"));
	}

}
