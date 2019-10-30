package enderecotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.empresa.endereco.UFBRASIL;

public class UfTest {
	
	@Test
	public void nao_deve_aceitar_uf_nula() {
		UFBRASIL ufbrasil = UFBRASIL.AC;
		assertTrue(ufbrasil.getUf() != null);
	}
	
	@Test
	public void nao_deve_aceitar_uf_vazia() {
		UFBRASIL ufbrasil = UFBRASIL.AL;
		assertTrue(ufbrasil.getUf() != "");
	}
	
	@Test
	public void deve_aceitar_uf_esperada() {
		UFBRASIL ufbrasil = UFBRASIL.AM;
		assertThat(ufbrasil.getUf(), is("AM"));
	}
	
	//ARRUMAR
	@Test
	public void nao_deve_aceitar_uf_diferente_da_esperada() {
		UFBRASIL ufbrasil = UFBRASIL.AP;
		assertTrue(ufbrasil.getUf()!="SP");
	}
	
	@Test
	public void deve_acertar_comprimento_2_de_uf() {
		UFBRASIL ufbrasil = UFBRASIL.BA;
		assertThat(String.valueOf(ufbrasil.getUf()).length(), is(2));
	}
	
	@Test
	public void nao_deve_aceitar_comprimento_menor_que_2_em_uf() {
		UFBRASIL ufbrasil = UFBRASIL.CE;
		assertFalse(String.valueOf(ufbrasil.getUf()).length()<2);
	}
	
	@Test
	public void nao_deve_aceitar_comprimento_maior_que_2_em_uf() {
		UFBRASIL ufbrasil = UFBRASIL.DF;
		assertFalse(String.valueOf(ufbrasil.getUf()).length()>2);
	}
	
	@Test
	public void nao_deve_aceitar_regiao_nula() {
		UFBRASIL ufbrasil = UFBRASIL.ES;
		assertTrue(ufbrasil.getRegiao() != null);
	}
	
	@Test
	public void nao_deve_regiao_vazia() {
		UFBRASIL ufbrasil = UFBRASIL.GO;
		assertTrue(ufbrasil.getRegiao() != "");
	}
	
	@Test
	public void deve_aceitar_regiao_esperada() {
		UFBRASIL ufbrasil = UFBRASIL.MA;
		assertThat(ufbrasil.getRegiao(), is("Maranhão"));
	}
	
	//ARRUMAR
	@Test
	public void nao_deve_aceitar_regiao_diferente_da_esperada() {
		UFBRASIL ufbrasil = UFBRASIL.MG;
		assertTrue(ufbrasil.getRegiao() != "Maranhão");
	}
	
	@Test
	public void deve_acertar_comprimento_maximo_de_19_caracteres_em_regiao_rio_grande_do_norte() {
		UFBRASIL ufbrasil = UFBRASIL.RN;
		assertThat(String.valueOf(ufbrasil.getRegiao()).length(), is(19));
	}
	
	@Test
	public void nao_deve_acertar_comprimento_com_mais_de_19_caracteres_em_regiao() {
		UFBRASIL ufbrasil = UFBRASIL.RN;
		assertFalse(String.valueOf(ufbrasil.getRegiao()).length()>19);
	}
	
	@Test
	public void deve_acertar_comprimento_minimo_de_4_caracteres_em_regiao_acre_para() {
		UFBRASIL ufbrasil = UFBRASIL.PA;
		assertThat(String.valueOf(ufbrasil.getRegiao()).length(), is(4));
	}
	
	@Test
	public void nao_deve_acertar_comprimento_menor_que_4_caracteres_em_regiao() {
		UFBRASIL ufbrasil = UFBRASIL.PA;
		assertFalse(ufbrasil.getRegiao().length()<4);
	}
	
	@Test
	public void deve_imprimir_test_de_to_string() {
		UFBRASIL ufbrasil = UFBRASIL.SP;
		System.out.println(ufbrasil.toString());
	}

}
