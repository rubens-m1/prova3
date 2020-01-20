package enderecotest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.empresa.endereco.UFBRASIL;

/**
 * The Class UfTest.
 */
public class UfTest {
	
	/**
	 * Nao deve aceitar uf nula.
	 */
	@Test
	public void nao_deve_aceitar_uf_nula() {
		UFBRASIL ufBrasil = UFBRASIL.AC;
		assertTrue(ufBrasil.getUf() != null);
	}
	
	/**
	 * Nao deve aceitar uf vazia.
	 */
	@Test
	public void nao_deve_aceitar_uf_vazia() {
		UFBRASIL ufBrasil = UFBRASIL.AL;
		assertTrue(ufBrasil.getUf() != "");
	}

	/**
	 * Deve aceitar uf esperada.
	 */
	@Test
	public void deve_aceitar_uf_esperada() {
		UFBRASIL ufBrasil = UFBRASIL.AM;
		assertThat(ufBrasil.getUf(), is("AM"));
	}
	
	/**
	 * Nao deve aceitar uf diferente da esperada.
	 */
	@Test
	public void nao_deve_aceitar_uf_diferente_da_esperada() {
		UFBRASIL ufBrasil = UFBRASIL.AP;
		assertTrue(ufBrasil.getUf().toString() != "SP");
	}
	
	/**
	 * Deve acertar comprimento 2 de uf.
	 */
	@Test
	public void deve_acertar_comprimento_2_de_uf() {
		UFBRASIL ufBrasil = UFBRASIL.BA;
		assertThat(String.valueOf(ufBrasil.getUf()).length(), is(2));
	}
	
	/**
	 * Nao deve aceitar comprimento menor que 2 em uf.
	 */
	@Test
	public void nao_deve_aceitar_comprimento_menor_que_2_em_uf() {
		UFBRASIL ufBrasil = UFBRASIL.CE;
		assertFalse(String.valueOf(ufBrasil.getUf()).length()<2);
	}
	
	/**
	 * Nao deve aceitar comprimento maior que 2 em uf.
	 */
	@Test
	public void nao_deve_aceitar_comprimento_maior_que_2_em_uf() {
		UFBRASIL ufBrasil = UFBRASIL.DF;
		assertFalse(String.valueOf(ufBrasil.getUf()).length()>2);
	}
	
	/**
	 * Nao deve aceitar regiao nula.
	 */
	@Test
	public void nao_deve_aceitar_regiao_nula() {
		UFBRASIL ufBrasil = UFBRASIL.ES;
		assertTrue(ufBrasil.getRegiao() != null);
	}
	
	/**
	 * Nao deve regiao vazia.
	 */
	@Test
	public void nao_deve_regiao_vazia() {
		UFBRASIL ufBrasil = UFBRASIL.GO;
		assertTrue(ufBrasil.getRegiao() != "");
	}
	
	/**
	 * Deve aceitar regiao esperada.
	 */
	@Test
	public void deve_aceitar_regiao_esperada() {
		UFBRASIL ufBrasil = UFBRASIL.MA;
		assertThat(ufBrasil.getRegiao(), is("Maranhão"));
	}
	
	/**
	 * Nao deve aceitar regiao diferente da esperada.
	 */
	//ARRUMAR
	@Test
	public void nao_deve_aceitar_regiao_diferente_da_esperada() {
		UFBRASIL ufBrasil = UFBRASIL.MG;
		assertTrue(ufBrasil.getRegiao().toString() != "Maranhão");
	}
	
	/**
	 * Deve acertar comprimento maximo de 19 caracteres em regiao rio grande do norte.
	 */
	@Test
	public void deve_acertar_comprimento_maximo_de_19_caracteres_em_regiao_rio_grande_do_norte() {
		UFBRASIL ufBrasil = UFBRASIL.RN;
		assertThat(String.valueOf(ufBrasil.getRegiao()).length(), is(19));
	}
	
	/**
	 * Nao deve acertar comprimento com mais de 19 caracteres em regiao.
	 */
	@Test
	public void nao_deve_acertar_comprimento_com_mais_de_19_caracteres_em_regiao() {
		UFBRASIL ufBrasil = UFBRASIL.RN;
		assertFalse(String.valueOf(ufBrasil.getRegiao()).length()>19);
	}
	
	/**
	 * Deve acertar comprimento minimo de 4 caracteres em regiao acre para.
	 */
	@Test
	public void deve_acertar_comprimento_minimo_de_4_caracteres_em_regiao_acre_para() {
		UFBRASIL ufBrasil = UFBRASIL.PA;
		assertThat(String.valueOf(ufBrasil.getRegiao()).length(), is(4));
	}
	
	/**
	 * Nao deve acertar comprimento menor que 4 caracteres em regiao.
	 */
	@Test
	public void nao_deve_acertar_comprimento_menor_que_4_caracteres_em_regiao() {
		UFBRASIL ufBrasil = UFBRASIL.PA;
		assertFalse(ufBrasil.getRegiao().length()<4);
	}
	
	/**
	 * Deve imprimir test de to string.
	 */
	@Test
	public void deve_imprimir_test_de_to_string() {
		UFBRASIL ufBrasil = UFBRASIL.SP;
		assertThat(ufBrasil.toString(), containsString("SP,São Paulo,SP,24"));
	}

}
