package br.com.contmatic.empresa.endereco;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import java.util.Random;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class FixtureCidade {
	
	public static void criarCidade() {
		Fixture.of(Cidade.class).addTemplate("valido", new Rule() {
			{
				add("bairro", has(5).of(Bairro.class, "valido"));
				add("nomeCidade", "São José");
				add("uf", UFBRASIL.values()[new Random().nextInt(UFBRASIL.values().length -1)]);
			}
		});
		
		Fixture.of(Bairro.class).addTemplate("valido", new Rule() {
			{
				add("bairro", random(randomAlphanumeric(10), randomAlphanumeric(10), randomAlphanumeric(10), randomAlphanumeric(10), "Bairro 1", "Bairro 2", "Bairro 3", "Bairro 4", "Bairro 5"));
			}
		});
		
		Cidade cidade = Fixture.from(Cidade.class).gimme("valido");
		System.out.println(cidade);
		System.out.println("");
		
	}
}
