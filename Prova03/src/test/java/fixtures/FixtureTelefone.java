package fixtures;

import java.util.Random;

import br.com.contmatic.empresa.telefone.DDD;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

/**
 * The Class FixtureTelefone.
 */
public class FixtureTelefone {

	/**
	 * Fake telefone.
	 */
	public static void fakeTelefone() {

		Fixture.of(Telefone.class).addTemplate("valido", new Rule() {{
			add("ddd", DDD.values()[new Random().nextInt(DDD.values().length - 1)]);
			add("numero", regex("([1-9][0-9]{8})"));
			add("ramal", regex("\\d{7}"));
		}});
		
	}
	
}
