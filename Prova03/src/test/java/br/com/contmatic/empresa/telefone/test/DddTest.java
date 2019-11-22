package br.com.contmatic.empresa.telefone.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.telefone.DDD;

public class DddTest {
	
	@Before
	public void init() {
		//DDD ddd = DDD.DDD11;
	}

	@Test
	public void deve_imprimir_to_string() {
		DDD ddd = DDD.DDD11;
		System.out.println(ddd.toString());
	}
	
	@Test
	public void deve_acertar_o_valor_esperado_do_ddd() {		
		DDD ddd = DDD.DDD12;
		assertThat(ddd.getDdd(), is("12"));
	}

	@Test
	public void nao_deve_aceitar_valor_diferente_do_valor_esperao() {
		DDD ddd = DDD.DDD13;
		assertTrue(ddd.getDdd() != ("14"));
	}
	
	@Test
	public void deve_aceitar_valor_esperado_da_regiao() {
		DDD ddd = DDD.DDD14;
		assertThat(ddd.getRegiao(), is("Bauru – SP"));
	}
	
	@Test
	public void nao_deve_aceitar_valor_diferente_do_esperado_da_regiao() {
		DDD ddd = DDD.DDD15;
		assertTrue(ddd.getRegiao() != ("Bauru – SP"));
	}

	@Test
	public void nao_deve_aceitar_ddd_nulo() {
		DDD ddd = DDD.DDD16;
		assertTrue(ddd.getDdd() != null);
	}
	
	@Test
	public void nao_deve_aceitar_regiao_nula() {
		DDD ddd = DDD.DDD17;
		assertTrue(ddd.getRegiao() != null);
	}
	
	@Test
	public void deve_acertar_o_comprimento_de_dois_digitos_no_ddd() {
		DDD ddd = DDD.DDD45;
		assertThat(String.valueOf(ddd.getDdd()).length(), is(2));
	}
	
	@Test
	public void nao_deve_aceitar_comprimento_menor_que_2_em_ddd() {
		DDD ddd = DDD.DDD19;
		assertFalse(String.valueOf(ddd.getDdd()).length()<2);
	}
	
	@Test
	public void nao_deve_aceitar_comprimento_maior_que_2_em_ddd() {
		DDD ddd = DDD.DDD21;
		assertFalse(String.valueOf(ddd.getDdd()).length()>2);
	}
	
	@Test
	public void nao_deve_aceitar_ddd_vazio() {
		DDD ddd = DDD.DDD22;
		assertTrue(ddd.getDdd() != "");
	}

	@Test 
	public void nao_deve_aceitar_regiao_vazia() {
		DDD ddd = DDD.DDD24;
		assertTrue(ddd.getRegiao() != "");
	}

}
