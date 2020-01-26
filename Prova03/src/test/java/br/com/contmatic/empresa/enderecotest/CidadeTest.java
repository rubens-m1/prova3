package br.com.contmatic.empresa.enderecotest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.endereco.UFBRASIL;
import br.com.contmatic.empresa.fixtures.FixtureCidade;
import br.com.contmatic.empresa.utiltest.Utilidades;
import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class CidadeTest.
 */
public class CidadeTest {

	/** The cidade. */
	private Cidade cidade;

	/** The cidade 2. */
	private Cidade cidade2;

	/** The bairros. */
	private Set<Bairro> bairros;

	/** The bairro. */
	private Bairro bairro;
	
	/**
	 * Inits the.
	 */
	@BeforeClass
	public static void init() {
		FixtureCidade.criarCidade();
	}

	/**
	 * Inits the 2.
	 */
	@Before
	public void init2() {
		cidade = Fixture.from(Cidade.class).gimme("valido");
		cidade2 = Fixture.from(Cidade.class).gimme("valido");
		bairro = new Bairro();
		bairros = new HashSet<>();
	}

	/**
	 * Nao deve aceitar cidade sem bairros.
	 */
	@Test
	public void nao_deve_aceitar_cidade_sem_bairros() {
		cidade.setBairro(null);
		assertFalse(Utilidades.isValid(cidade, "A lista de bairros nao pode ser nula"));
	}

	/**
	 * Nao deve aceitar cidade com nome nulo.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_nome_nulo() {
		cidade.setNomeCidade(null);
		assertFalse(Utilidades.isValid(cidade, "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Nao deve aceitar cidade com com uf nulo.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_com_uf_nulo() {
		cidade.setUf(null);
		assertFalse(Utilidades.isValid(cidade, "UF da cidade nao pode ser nulo"));
	}

	/**
	 * Deve aceitar cidade com apenas um bairro.
	 */
	@Test
	public void deve_aceitar_cidade_com_apenas_um_bairro() {
		bairro.setBairro("Tatuapé");
		bairros.add(bairro);
		cidade.setBairro(bairros);
		assertTrue(cidade.getBairro().size() == 1);
	}

	/**
	 * Deve aceitar cidade com mais de um bairro.
	 */
	@Test
	public void deve_aceitar_cidade_com_mais_de_um_bairro() {
		assertTrue(cidade.getBairro().size() > 1);
	}

	/**
	 * Deve aceitar cidade cidade valida.
	 */
	@Test
	public void deve_aceitar_cidade_cidade_valida() {
		cidade.setNomeCidade("Fortaleza");
		assertThat(cidade.toString(), containsString("Fortaleza"));
	}

	/**
	 * Deve aceitar cidade com acentos valida.
	 */
	@Test
	public void deve_aceitar_cidade_com_acentos_valida() {
		cidade.setNomeCidade("São Paulo");
		assertTrue(cidade.getNomeCidade().equals("São Paulo"));
	}

	/**
	 * Nao deve aceitar cidade com letras e numero.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_letras_e_numero() {
		cidade.setNomeCidade("São Paulo 123");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	/**
	 * Nao deve aceitar cidade com conter caracteres especiais.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_conter_caracteres_especiais() {
		cidade.setNomeCidade("!@#$%Â¨&*");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	/**
	 * Nao deve aceitar cidade com caracteres especiais com letras.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_caracteres_especiais_com_letras() {
		cidade.setNomeCidade("São Paulo !@#$");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	/**
	 * Nao deve aceitar cidade com caracteres especiais com numeros.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_caracteres_especiais_com_numeros() {
		cidade.setNomeCidade("1234 !@#$%Â¨&*");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	/**
	 * Nao deve aceitar cidade com caracteres especiais com letras e numeros.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_caracteres_especiais_com_letras_e_numeros() {
		cidade.setNomeCidade("São Paulo 123 !@#$%");
		assertFalse(Utilidades.isValid(cidade, "Caractere invalido"));
	}

	/**
	 * Deve aceitar cidade com quantidade maxima de caracteres.
	 */
	@Test
	public void deve_aceitar_cidade_com_quantidade_maxima_de_caracteres() {
		cidade.setNomeCidade(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertTrue(cidade.getNomeCidade().equals(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	/**
	 * Nao deve aceitar cidade com mais de 100 caracteres.
	 */
	@Test
	public void nao_deve_aceitar_cidade_com_mais_de_100_caracteres() {
		cidade.setNomeCidade(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1");
		assertFalse(Utilidades.isValid(cidade, "Quantidade de caracteres no nome da cidade deve estar entre 1 e 100"));
	}

	/**
	 * Deve aceitar cidade com quantidade minima de caracteres.
	 */
	@Test
	public void deve_aceitar_cidade_com_quantidade_minima_de_caracteres() {
		cidade.setNomeCidade("A");
		assertTrue(cidade.getNomeCidade().equals("A"));
	}

	/**
	 * Nao deve aceitar cidade vazia.
	 */
	@Test
	public void nao_deve_aceitar_cidade_vazia() {
		cidade.setNomeCidade("");
		assertFalse(Utilidades.isValid(cidade, "Quantidade de caracteres no nome da cidade deve estar entre 1 e 100"));
	}

	/**
	 * Nao deve aceitar cidade apenas com espacos em branco.
	 */
	@Test
	public void nao_deve_aceitar_cidade_apenas_com_espacos_em_branco() {
		cidade.setNomeCidade("                  ");
		assertFalse(Utilidades.isValid(cidade, "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo"));
	}

	/**
	 * Deve acertar que duas cidades são iguais.
	 */
	@Test
	public void deve_acertar_que_duas_cidades_são_iguais() {
		cidade2 = cidade;
		assertTrue(cidade.equals(cidade2));
	}
	
	/**
	 * Deve acertar que duas cidades iguais tenham o mesmo hashcode.
	 */
	@Test
	public void deve_acertar_que_duas_cidades_iguais_tenham_o_mesmo_hashcode() {
		cidade2 = cidade;
		assertTrue(cidade.hashCode() == cidade2.hashCode());
	}

	/**
	 * Deve acertar que duas cidades diferentes com nomes iguais tenham hashcodes diferentes.
	 */
	@Test
	public void deve_acertar_que_duas_cidades_diferentes_com_nomes_iguais_tenham_hashcodes_diferentes() {
		cidade.setUf(UFBRASIL.CE);
		cidade2.setUf(UFBRASIL.SP);
		assertTrue(cidade.hashCode() != cidade2.hashCode());
	}

	/**
	 * Deve acertar que duas cidades diferentes tenham hashcodes diferentes.
	 */
	@Test
	public void deve_acertar_que_duas_cidades_diferentes_tenham_hashcodes_diferentes() {
		cidade.setNomeCidade("São Paulo");
		assertTrue(cidade.hashCode() != cidade2.hashCode());
	}

	/**
	 * Nao deve aceitar que duas cidades diferentes tenham hashcodes iguais.
	 */
	@Test
	public void nao_deve_aceitar_que_duas_cidades_diferentes_tenham_hashcodes_iguais() {
		cidade.setUf(UFBRASIL.AC);
		cidade.setUf(UFBRASIL.AL);
		assertFalse(cidade.hashCode() == cidade2.hashCode());
	}

	/**
	 * Deve fazer to string de cidade.
	 */
	@Test
	public void deve_fazer_to_string_de_cidade() {
	    cidade.setNomeCidade("São José");
		assertThat(cidade.toString(), containsString("São José"));
	}

	/**
	 * Deve respeitar os gets sets.
	 */
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Cidade.class, hasValidGettersAndSetters());
	}

    /**
     * Deve respeitar equals hash code.
     */
    @Test
    public void deve_respeitar_equals_hashCode() {
        EqualsVerifier.forClass(Cidade.class).withOnlyTheseFields("bairro","uf","nomeCidade").suppress(Warning.NONFINAL_FIELDS).verify();
    }

}

