package br.com.contmatic.empresatest;

import static br.com.contmatic.empresa.utiltest.Utilidades.isValid;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.google.code.beanmatchers.ValueGenerator;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.fixtures.FixtureFuncionario;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.utiltest.Utilidades;
import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import static com.google.code.beanmatchers.BeanMatchers.registerValueGenerator;

/**
 * The Class EmailTest.
 */
public class EmailTest {

    /** The email func. */
    private Email emailFunc;

    /** The funcionario. */
    private Funcionario funcionario;

    @Mock
    private ValueGenerator<Funcionario> funcionarioMock;

    /**
     * Inits the.
     */
    @BeforeClass
    public static void init() {
		Utilidades.reconhecerJodaTime();
		FixtureFuncionario.fakeFuncionario();
	}
	
	/**
	 * Inits the 2.
	 */
	@Before
	public void init2() {
		emailFunc = new Email();
		funcionario = Fixture.from(Funcionario.class).gimme("valido");
	}

	/**
	 * Nao deve aceitar email nulo.
	 */
	@Test
	public void nao_deve_aceitar_email_nulo() {
		emailFunc.setEmail(null);
		assertFalse(isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar email vazio.
	 */
	@Test
	public void nao_deve_aceitar_email_vazio() {
		emailFunc.setEmail("");
		assertFalse(isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	 
	/**
	 * Nao deve aceitar email somente com espaços em branco.
	 */
	@Test
	public void nao_deve_aceitar_email_somente_com_espaços_em_branco() {
		emailFunc.setEmail("            ");
		assertFalse(isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	/**
	 * Nao deve aceitar email com funcionario nulo.
	 */
	@Test
	public void nao_deve_aceitar_email_com_funcionario_nulo() {
		funcionario = null;
		emailFunc.setFuncionario(funcionario);
		assertFalse(isValid(emailFunc, "Funcionario nao pode ser nulo"));
	}
	
	/**
	 * Deve aceitar email correto com funcionario valido.
	 */
	@Test
	public void deve_aceitar_email_correto_com_funcionario_valido() {
		emailFunc.setEmail("seila@seila.com.br");
		assertTrue(isValid(emailFunc, "seila@123.com.br"));
	}
	
	/**
	 * Deve aceitar email valido com numeros.
	 */
	@Test
	public void deve_aceitar_email_valido_com_numeros() {
		emailFunc.setEmail("123@123.com.br");
		assertTrue(isValid(emailFunc, "123@123.com.br"));
	}
	
	/**
	 * Deve aceitar email valido com caracteres especiais.
	 */
	@Test
	public void deve_aceitar_email_valido_com_caracteres_especiais() {
		emailFunc.setEmail("!#$%¨&*()_@123.com.br");
		assertTrue(isValid(emailFunc, "!#$%¨&*()_@123.com.br"));
	}
	
	/**
	 * Deve aceitar email valido com quantidade min de 6 caracteres.
	 */
	@Test
	public void deve_aceitar_email_valido_com_quantidade_min_de_6_caracteres() {
		emailFunc.setEmail("a@a.br");
		assertTrue(isValid(emailFunc, "a@a.br"));
	}	
	
	/**
	 * Nao deve aceitar email com menos de 6 caracteres.
	 */
	@Test
	public void nao_deve_aceitar_email_com_menos_de_6_caracteres() {
		emailFunc.setEmail("a@a.b");
		assertFalse(isValid(emailFunc, "Email deve ter de 6 a 50 caracteres"));
	}
	
	/**
	 * Deve aceitar email com quantidade max de 50 caracteres.
	 */
	@Test
	public void deve_aceitar_email_com_quantidade_max_de_50_caracteres() {
		emailFunc.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@seila.com");
		assertTrue(isValid(emailFunc, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@seila.com"));
	}
	
	/**
	 * Nao deve aceitar email com mais de 50 caracteres.
	 */
	@Test
	public void nao_deve_aceitar_email_com_mais_de_50_caracteres() {
		emailFunc.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@seila.com");
		assertFalse(isValid(emailFunc, "Email deve ter de 6 a 50 caracteres"));
	}
	
	/**
	 * Deve fazer tostring de email valido.
	 */
	@Test
	public void deve_fazer_tostring_de_email_valido() {
		emailFunc.setEmail("a@a.br");
		assertThat(emailFunc.toString(), containsString("a@a.br"));
	}
	
	/**
	 * Deve respeitar os gets sets.
	 */
	@Test
	public void deve_respeitar_os_gets_sets() {
	    gerarFuncionario();
		assertThat(Email.class, hasValidGettersAndSetters());
	}
	
	/**
	 * Deve respeitar equals hash code.
	 */
	@Test
	public void deve_respeitar_equals_hashCode() {
	    EqualsVerifier.forClass(Email.class).withOnlyTheseFields("email").suppress(Warning.NONFINAL_FIELDS).verify();
	}
	
	public void gerarFuncionario() {
        registerValueGenerator(new ValueGenerator<Funcionario>() {
            public Funcionario generate() {
                return new Funcionario();
            }
        }, Funcionario.class);
    }

}
