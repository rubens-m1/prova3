package br.com.contmatic.empresa.telefone;

import java.util.Random;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class FixtureTelefone {

	public static void fakeTelefone() {

		Fixture.of(Telefone.class).addTemplate("valido", new Rule() {{
			add("tipo", TIPODETELEFONE.values()[new Random().nextInt(TIPODETELEFONE.values().length -1)]);
			add("ddd", DDD.values()[new Random().nextInt(DDD.values().length - 1)]);
			add("numero", regex("([1-9][0-9]{8})"));
			add("ramal", regex("\\d{7}"));
		}});
		
		Telefone telefone = Fixture.from(Telefone.class).gimme("valido");
		System.out.println(telefone);
		System.out.println("");

	}
}
