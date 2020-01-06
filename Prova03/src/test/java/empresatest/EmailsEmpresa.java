package empresatest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.funcionario.FixtureFuncionario;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.six2six.fixturefactory.Fixture;
import util.Utilidades;

public class EmailsEmpresa {
	
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
		assertFalse(Utilidades.isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_email_vazio() {
		emailFunc.setEmail("");
		assertFalse(Utilidades.isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	 
	@Test
	public void nao_deve_aceitar_email_somente_com_espaços_em_branco() {
		emailFunc.setEmail("            ");
		assertFalse(Utilidades.isValid(emailFunc, "Email nao pode conter apenas espacos, estar vazio ou nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_email_com_funcionario_nulo() {
		emailFunc.setFuncionario(null);
		assertFalse(Utilidades.isValid(emailFunc, "Funcionario nao pode ser nulo"));
	}
	
	@Test
	public void deve_aceitar_email_correto_com_funcionario_valido() {
		
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
