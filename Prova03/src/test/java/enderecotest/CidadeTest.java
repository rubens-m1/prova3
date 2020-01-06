package enderecotest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.endereco.FixtureCidade;
import br.com.contmatic.empresa.endereco.UFBRASIL;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

public class CidadeTest {

	private Cidade cidade;

	private Cidade cidade2;

	private Set<Bairro> bairros;

	private Bairro bairro;
	
	@BeforeClass
	public static void init() {
		FixtureCidade.criarCidade();
	}

	@Before
	public void init2() {
		cidade = Fixture.from(Cidade.class).gimme("valido");
		cidade2 = Fixture.from(Cidade.class).gimme("valido");
		bairro = new Bairro();
		bairros = new HashSet<>();
	}

	@Test
	public void nao_deve_aceitar_cidade_sem_bairros() {
		cidade.setBairro(null);
		assertFalse(Utilidades.isValid(cidade, "A lista de bairros nao pode ser nula"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_nome_nulo() {
		cidade.setNomeCidade(null);
		assertFalse(Utilidades.isValid(cidade, "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_com_uf_nulo() {
		cidade.setUf(null);
		assertFalse(Utilidades.isValid(cidade, "UF da cidade nao pode ser nulo"));
	}

	@Test
	public void deve_aceitar_cidade_com_apenas_um_bairro() {
		bairro.setBairro("Tatuapé");
		bairros.add(bairro);
		cidade.setBairro(bairros);
		assertTrue(cidade.getBairro().size() == 1);
	}

	@Test
	public void deve_aceitar_cidade_com_mais_de_um_bairro() {
		assertTrue(cidade.getBairro().size() > 1);
	}

	@Test
	public void deve_aceitar_cidade_cidade_valida() {
		FixtureCidade.criarCidade();
		cidade.setNomeCidade("Fortaleza");
		assertTrue(cidade.getNomeCidade().equals("Fortaleza"));
	}

	@Test
	public void deve_aceitar_cidade_com_acentos_valida() {
		cidade.setNomeCidade("São Paulo");
		assertTrue(cidade.getNomeCidade().equals("São Paulo"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_letras_e_numero() {
		cidade.setNomeCidade("São Paulo 123");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_conter_caracteres_especiais() {
		cidade.setNomeCidade("!@#$%Â¨&*");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_caracteres_especiais_com_letras() {
		cidade.setNomeCidade("São Paulo !@#$");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_caracteres_especiais_com_numeros() {
		cidade.setNomeCidade("1234 !@#$%Â¨&*");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_caracteres_especiais_com_letras_e_numeros() {
		cidade.setNomeCidade("São Paulo 123 !@#$%");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	@Test
	public void deve_aceitar_cidade_com_quantidade_maxima_de_caracteres() {
		cidade.setNomeCidade(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertTrue(cidade.getNomeCidade().equals(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	@Test
	public void nao_deve_aceitar_cidade_com_mais_de_100_caracteres() {
		cidade.setNomeCidade(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1");
		assertFalse(Utilidades.isValid(cidade, "Quantidade de caracteres no nome da cidade deve estar entre 1 e 100"));
	}

	@Test
	public void deve_aceitar_cidade_com_quantidade_minima_de_caracteres() {
		cidade.setNomeCidade("A");
		assertTrue(cidade.getNomeCidade().equals("A"));
	}

	@Test
	public void nao_deve_aceitar_cidade_vazia() {
		cidade.setNomeCidade("");
		assertFalse(Utilidades.isValid(cidade, "Quantidade de caracteres no nome da cidade deve estar entre 1 e 100"));
	}

	@Test
	public void nao_deve_aceitar_cidade_apenas_com_espacos_em_branco() {
		cidade.setNomeCidade("                  ");
		assertFalse(Utilidades.isValid(cidade, "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	@Test
	public void deve_acertar_que_duas_cidades_são_iguais() {
		cidade2 = cidade;
		assertTrue(cidade.equals(cidade2));
	}
	
	@Test
	public void deve_acertar_que_duas_cidades_iguais_tenham_o_mesmo_hashcode() {
		cidade2 = cidade;
		assertTrue(cidade.hashCode() == cidade2.hashCode());
	}

	@Test
	public void deve_acertar_que_duas_cidades_diferentes_com_nomes_iguais_tenham_hashcodes_diferentes() {
		cidade.setUf(UFBRASIL.CE);
		cidade2.setUf(UFBRASIL.SP);
		assertTrue(cidade.hashCode() != cidade2.hashCode());
	}

	@Test
	public void deve_acertar_que_duas_cidades_diferentes_tenham_hashcodes_diferentes() {
		cidade.setNomeCidade("São Paulo");
		assertTrue(cidade.hashCode() != cidade2.hashCode());
	}

	@Test
	public void nao_deve_aceitar_que_duas_cidades_diferentes_tenham_hashcodes_iguais() {
		cidade.setUf(UFBRASIL.AC);
		cidade.setUf(UFBRASIL.AL);
		assertFalse(cidade.hashCode() == cidade2.hashCode());
	}

	@Test
	public void deve_fazer_to_string_de_cidade() {
		cidade.toString();
		System.out.println(cidade.toString());
	}

	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Cidade.class, hasValidGettersAndSetters());
	}

	@Test
	public void deve_respeitar_hash_code() {
		assertThat(Cidade.class, BeanMatchers.hasValidBeanHashCode());
	}

	@Test
	public void deve_respeitar_equals() {
		assertThat(Cidade.class, BeanMatchers.hasValidBeanEquals());
	}

}

