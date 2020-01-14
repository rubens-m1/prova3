package fixtures;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomAscii;

import java.util.Random;

import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.endereco.TIPODEENDERECO;
import br.com.contmatic.empresa.endereco.UFBRASIL;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

/**
 * The Class FixtureEndereco.
 */
public class FixtureEndereco {

	/**
	 * Fake endereco.
	 */
	public static void fakeEndereco() {
		Fixture.of(Endereco.class).addTemplate("valido", new Rule() {
			{
				add("logradouro", regex("[a-zA-Z0-9]{10} [a-zA-Z0-9]{10}"));
				add("numero", regex("[0-9]{6}"));
				add("cep", regex("\\d{5}-\\d{3}"));
				add("complemento", randomAscii(10));
				add("tipo", TIPODEENDERECO.values()[new Random().nextInt(TIPODEENDERECO.values().length - 1)]);
				add("bairro", one(Bairro.class, "valido"));
				add("cidade", one(Cidade.class, "valido"));
			}
		});

		Fixture.of(Bairro.class).addTemplate("valido", new Rule() {
			{
				add("bairro", randomAlphanumeric(10));
			}
		});

		Fixture.of(Cidade.class).addTemplate("valido", new Rule() {
			{
				add("bairro", has(1).of(Bairro.class, "valido"));
				add("nomeCidade", "São José");
				add("uf", UFBRASIL.values()[new Random().nextInt(UFBRASIL.values().length - 1)]);
			}
		});

	}
	
}
