package empresatest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static util.Utilidades.isValid;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.funcionario.FixtureFuncionario;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

public class EmailTest {
	
	private Email emailFunc;
	
	private Funcionario funcionario;
		
	@BeforeClass
	public static void init() {
		Utilidades.reconhecerJodaTime();
		FixtureFuncionario.fakeFuncionario();
	}
	
	@Before
	public void init2() {
		emailFunc = new Email();
		funcionario = Fixture.from(Funcionario.class).gimme("valido");
	}

	@Test
	public void nao_deve_aceitar_email_nulo() {
		emailFunc.setEmail(null);
		assertFalse(isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_email_vazio() {
		emailFunc.setEmail("");
		assertFalse(isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	 
	@Test
	public void nao_deve_aceitar_email_somente_com_espaços_em_branco() {
		emailFunc.setEmail("            ");
		assertFalse(isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_email_com_funcionario_nulo() {
		emailFunc.setFuncionario(null);
		assertFalse(isValid(emailFunc, "Funcionario nao pode ser nulo"));
	}
	
	@Test
	public void deve_aceitar_email_correto_com_funcionario_valido() {
		emailFunc.setEmail("seila@seila.com.br");
		assertTrue(isValid(emailFunc, "seila@123.com.br"));
	}
	
	@Test
	public void deve_aceitar_email_valido_com_numeros() {
		emailFunc.setEmail("123@123.com.br");
		assertTrue(isValid(emailFunc, "123@123.com.br"));
	}
	
	@Test
	public void deve_aceitar_email_valido_com_caracteres_especiais() {
		emailFunc.setEmail("!#$%¨&*()_@123.com.br");
		assertTrue(isValid(emailFunc, "!#$%¨&*()_@123.com.br"));
	}
	
	@Test
	public void deve_aceitar_email_valido_com_quantidade_min_de_6_caracteres() {
		emailFunc.setEmail("a@a.br");
		assertTrue(isValid(emailFunc, "a@a.br"));
	}	
	
	@Test
	public void nao_deve_aceitar_email_com_menos_de_6_caracteres() {
		emailFunc.setEmail("a@a.b");
		assertFalse(isValid(emailFunc, "Email deve ter de 6 a 50 caracteres"));
	}
	
	@Test
	public void deve_aceitar_email_com_quantidade_max_de_50_caracteres() {
		emailFunc.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@seila.com");
		assertTrue(isValid(emailFunc, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@seila.com"));
	}
	
	@Test
	public void nao_deve_aceitar_email_com_mais_de_50_caracteres() {
		emailFunc.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@seila.com");
		assertFalse(isValid(emailFunc, "Email deve ter de 6 a 50 caracteres"));
	}
	
	@Test
	public void deve_fazer_tostring_de_email_valido() {
		emailFunc.setEmail("a@a.br");
		assertThat(emailFunc.toString(), containsString("a@a.br"));
	}
	
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Email.class, hasValidGettersAndSetters());
	}
	
	@Test
	public void deve_respeitar_hash_code() {
		assertThat(Email.class, BeanMatchers.hasValidBeanHashCode());
	}

	@Test
	public void deve_respeitar_equals() {
		assertThat(Email.class, BeanMatchers.hasValidBeanEquals());
	}
	
	

}
