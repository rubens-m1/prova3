package util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.google.code.beanmatchers.BeanMatchers;
import com.google.code.beanmatchers.ValueGenerator;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.SitesEmpresa;
import br.com.contmatic.empresa.endereco.Bairro;
import br.com.contmatic.empresa.endereco.Cidade;
import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.Telefone;

// TODO: Auto-generated Javadoc
/**
 * The Class Utilidades.
 */
public class Utilidades {
	
	/** The validator. */
	private static Validator validator;

	/** The factory. */
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	/**
	 * Checks if is valid.
	 *
	 * @param endereco the endereco
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(Endereco endereco, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Endereco>> restricoes = validator.validate(endereco);
		for (ConstraintViolation<Endereco> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param bairro the bairro
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(Bairro bairro, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Bairro>> restricoes = validator.validate(bairro);
		for (ConstraintViolation<Bairro> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param cidade the cidade
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(Cidade cidade, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Cidade>> restricoes = validator.validate(cidade);
		for (ConstraintViolation<Cidade> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param funcionario the funcionario
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(Funcionario funcionario, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Funcionario>> restricoes = validator.validate(funcionario);
		for (ConstraintViolation<Funcionario> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param telefone the telefone
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(Telefone telefone, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Telefone>> restricoes = validator.validate(telefone);
		for (ConstraintViolation<Telefone> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param site the site
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(SitesEmpresa site, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<SitesEmpresa>> restricoes = validator.validate(site);
		for (ConstraintViolation<SitesEmpresa> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param emailFunc the email func
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(Email emailFunc, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Email>> restricoes = validator.validate(emailFunc);
		for (ConstraintViolation<Email> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param empresa the empresa
	 * @param mensagem the mensagem
	 * @return true, if is valid
	 */
	public static boolean isValid(Empresa empresa, String mensagem) {
		validator = factory.getValidator();
		boolean valido = true;
		Set<ConstraintViolation<Empresa>> restricoes = validator.validate(empresa);
		for (ConstraintViolation<Empresa> constraintViolation : restricoes)
			if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
				valido = false;
		return valido;
	}
	
	/**
	 * Reconhecer joda time.
	 */
	public static void reconhecerJodaTime() {
		BeanMatchers.registerValueGenerator(new ValueGenerator<LocalTime>() {
			public LocalTime generate() {
				return LocalTime.now();
			}
		}, LocalTime.class);

		BeanMatchers.registerValueGenerator(new ValueGenerator<LocalDate>() {
			public LocalDate generate() {
				return LocalDate.now();
			}
		}, LocalDate.class);
	}
	
//	boolean Utilidades.isValidDate(String dateToValidate){
//	    String pattern = "yyyy-MM-dd";
//
//	    try {
//	        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
//	        fmt.parseDateTime(dateToValidate);
//	    } catch (Exception e) {
//	        return false;
//	    }
//	    return true;
//	}
	
//	public void gerarData() {
//	registerValueGenerator(new ValueGenerator<DateTime>() {
//		public DateTime generate() {
//			return new DateTime(new Random().nextLong()).withMillisOfSecond(0);
//		}
//	}, DateTime.class);
//}

}
