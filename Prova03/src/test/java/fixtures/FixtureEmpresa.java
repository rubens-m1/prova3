package fixtures;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.SitesEmpresa;
import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.endereco.TIPODEENDERECO;
import br.com.contmatic.empresa.endereco.UFBRASIL;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.DDD;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class FixtureEmpresa {
	
	/**
	 * Fake empresa.
	 */
	public static void fakeEmpresa() {
		Fixture.of(Empresa.class).addTemplate("valido", new Rule() {
			{
				add("cnpj", "44247877000157");
				add("razaoSocial","razaoSocial");
				add("nomeFantasia","nomeFantasia");
				add("endereco",has(1).of(Endereco.class, "valido"));
				add("telefone", has(1).of(Telefone.class, "valido"));
				add("funcionario", has(1).of(Funcionario.class, "valido"));
				add("emailEmpresa", has(1).of(Email.class, "valido"));
				add("site", has(1).of(SitesEmpresa.class, "valido"));
				add("dataDeRegistro", new org.joda.time.LocalDate(RandomUtils.nextInt(1900, 2003), RandomUtils.nextInt(1, 12), RandomUtils.nextInt(1, 28)));
			}
		});
		
		Fixture.of(Funcionario.class).addTemplate("valido", new Rule() {
			{
		
			add("cpf",random("90546150012", "73883228095"));
			add("primeiroNome",random("João", "Felipe","Maria","Fernanda"));
			add("sobrenome",random("Silva", "Ferreira","Cruz","Barros"));
			add("dataDeNascimento", new org.joda.time.LocalDate(RandomUtils.nextInt(1900, 2003), RandomUtils.nextInt(1, 12), RandomUtils.nextInt(1, 28)));
			add("cargo","Programador(a)");
			add("salario","5000.00");
			add("endereco",one(Endereco.class, "valido"));
			add("telefone", has(1).of(Telefone.class, "valido"));
			add("email","funcionario@empresa.com");
		}
	
	});
		
		Fixture.of(Endereco.class).addTemplate("valido", new Rule() {
			{
				add("logradouro", regex("[a-zA-Z0-9]{10} [a-zA-Z0-9]{10}"));
				add("numero", regex("[0-9]{6}"));
				add("cep", regex("\\d{5}-\\d{3}"));
				add("complemento", regex("Complemento : [a-zA-Z0-9]{10}"));
				add("tipo", TIPODEENDERECO.ENDERECORESIDENCIAL);
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
		
		Fixture.of(Telefone.class).addTemplate("valido", new Rule() {
			{
				add("ddd", DDD.values()[new Random().nextInt(DDD.values().length - 1)]);
				add("numero", regex("\\d{8,9}"));
				add("ramal", "");
			}
		});
		
		Fixture.of(Email.class).addTemplate("valido", new Rule() {
			{
				add("email", "abc@abc.com");
			}
		});
		
		Fixture.of(SitesEmpresa.class).addTemplate("valido", new Rule() {
			{
				add("url", "seila.com.br");
			}
		});
	}

}
