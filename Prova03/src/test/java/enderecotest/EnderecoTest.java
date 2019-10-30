package enderecotest;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.FixtureEndereco;
import br.com.six2six.fixturefactory.Fixture;

public class EnderecoTest {

	private FixtureEndereco fakeEndereco;
	
	private Bairro bairro;
	
	@Before
	public void init() {
		Fixture.from(FixtureEndereco.class);
	}
	
	@Test
	public void test() {
		//fakeEndereco.toString();
		System.out.println(fakeEndereco);
		//System.out.println(bairro);
		//System.out.println(fakeEndereco.toString());
	}
}
