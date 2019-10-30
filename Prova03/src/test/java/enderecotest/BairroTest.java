package enderecotest;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.google.code.beanmatchers.BeanMatchers;

import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.telefone.Telefone;

public class BairroTest {
	
	private Bairro bairro;
	
	private Bairro bairro1;
	
	private Validator validator;
	
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	@Before
	public void init() {
		bairro = new Bairro();
		
		bairro1 = new Bairro();
	}
	
	public boolean isValid(Bairro bairro, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Bairro>> restricoes = validator.validate(bairro);
		for (ConstraintViolation<Bairro> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	@Test
	public void nao_deve_aceitar_bairro_com_nulo() {
		bairro.setBairro(null);
		assertFalse(isValid(bairro, "Bairro nao pode ser nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_bairro_com_vazio() {
		bairro.setBairro("");
		assertFalse(isValid(bairro, "Bairro nao pode ser nulo"));
	}
	
	@Test
	public void nao_deve_aceitar_bairro_com_apenas_com_espaços() {
		bairro.setBairro("       ");
		assertFalse(isValid(bairro, "Bairro nao pode ser nulo"));
	}

	@Test
	public void deve_aceitar_bairro_correto() {
		bairro.setBairro("Tatuapé");
		assertTrue(bairro.getBairro().equals("Tatuapé"));
	}
	
	@Test
	public void nao_deve_aceitar_bairro_com_caracteres_especiais() {
		bairro.setBairro("!@#$%");
		assertFalse(isValid(bairro, "Nome de bairro invalido"));
	}
	
	@Test
	public void deve_imprimir_tostring_de_bairro() {
		bairro.setBairro("Tatuapé");
		System.out.println(bairro.toString());
	}
	
	@Test
	public void deve_aceitar_mesmo_objeto_com_hashcodes_iguais() {
		bairro.setBairro("Tatuapé");
		bairro1.setBairro("Tatuapé");
		assertTrue(bairro.hashCode() == bairro1.hashCode());
	}
	
	@Test
	public void nao_deve_aceitar_objetos_diferentes_com_hashcodes_iguais() {
		bairro.setBairro("Tatuapé");
		bairro1.setBairro("Saúde");
		assertFalse(bairro.hashCode() == bairro1.hashCode());
	}
	
	@Test
	public void nao_deve_aceitar_mesmo_objeto_com_hashcodes_diferentes() {
		bairro.setBairro("Tatuapé");
		bairro1.setBairro("Tatuapé");
		assertFalse(bairro.hashCode() != bairro1.hashCode());
	}
	
	@Test
	public void deve_aceitar_objetos_diferentes_com_hashcodes_diferentes() {
		bairro.setBairro("Tatuapé");
		bairro1.setBairro("Saúde");
		assertTrue(bairro.hashCode() != bairro1.hashCode());
	}
	
	@Test
	public void deve_aceitar_dois_bairros_com_o_mesmo_nome_equals() {
		 bairro.setBairro("Tatuapé");
		 bairro1.setBairro("Tatuapé");
		 assertTrue(bairro.getBairro().equals(bairro1.getBairro()));
	}
	
	@Test
	public void nao_deve_aceitar_dois_bairros_com_nomes_diferentes() {
		 bairro.setBairro("Tatuapé");
		 bairro1.setBairro("Saúde");
		 assertFalse(bairro.getBairro().equals(bairro1.getBairro()));
	}
	
	@Test
	public void deve_aceitar_tamanho_minimo_de_caracteres_em_bairro() {
		bairro.setBairro("1");
		assertTrue(isValid(bairro, "1"));
	}
	
	@Test
	public void nao_deve_aceitar_tamanho_menor_que_o_minimo_de_caracteres_em_bairro() {
		bairro.setBairro("");
		assertFalse(isValid(bairro, "Bairro nao pode ser nulo"));
	}
	
	@Test
	public void deve_aceitar_tamanho_maximo_de_caracteres_em_bairro() {
		bairro.setBairro("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertTrue(isValid(bairro, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	@Test
	public void nao_deve_aceitar_tamanho__maior_que_o_maximo_de_caracteres_em_bairro() {
		bairro.setBairro("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1");
		assertFalse(isValid(bairro, "Quantidade de caracteres no bairro deve estar entre 1 e 100"));
	}
	
	@Test
	public void deve_respeitar_os_gets_sets() {
		assertThat(Bairro.class, hasValidGettersAndSetters());
	}
	
	@Test
	public void deve_respeitar_hash_code() {
		assertThat(Bairro.class, BeanMatchers.hasValidBeanHashCode());
	}

	@Test
	public void deve_respeitar_equals() {
		assertThat(Bairro.class, BeanMatchers.hasValidBeanEquals());
	}

}
