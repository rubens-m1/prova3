package br.com.contmatic.empresa.funcionario;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.LocalDate;

import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.telefone.Telefone;
import br.com.contmatic.empresa.util.ExpressoesRegulares;

// TODO: Auto-generated Javadoc
/**
 * The Class Funcionario.
 */
public class Funcionario{

	/** The cpf. */
	@CPF(message = "CPF invalido")
	@NotBlank(message = "CPF nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 digitos")
	private String cpf;

	/** The primeiro nome. */
	@NotBlank(message = "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 1, max = 50, message = "O campo primeiro nome deve conter de 1 a 50 caracteres")
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_Ç_E_ACENTOS, message = "O campo deve conter somente letras")
	private String primeiroNome;

	/** The sobrenome. */
	@NotBlank(message = "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 1, max = 50, message = "O campo sobrenome nome deve conter de 1 a 50 caracteres")
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_ESPACO_Ç_E_ACENTOS, message = "O campo sobrenome deve conter somente letras e espacos")
	private String sobrenome;

	/** The data de nascimento. */
	@NotNull(message = "Data de nascimento não pode ser nula")
	@Past(message = "Data de nascimento não pode ser no futuro")
	private LocalDate dataDeNascimento;

	/** The cargo. */
	@NotBlank(message = "Cargo nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 2, max = 50, message = "O campo cargo nome deve conter de 2 a 50 caracteres")
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_ESPACO_Ç_E_ACENTOS, message = "O campo cargo deve conter somente letras e espacos")
	private String cargo;

	/** The salario. */
	@NotNull(message = "Salario nao pode ser nulo")
	@Min(value = 998, message = "O valor do salario deve ser maior ou igual a 998")
	@Max(value = 999999999, message = "O valor do salario deve ser menor ou igual a 999999999")
	private Double salario;

	/** The endereco. */
	@Valid
	@NotNull(message = "Endereco nao pode ser nulo")
	private Endereco endereco;

	
	/** The telefone. */
	@Valid
	@NotNull(message = "Telefone nao pode ser nulo")
	private Set<Telefone> telefone;

	/** The email. */
	@NotBlank(message = "E-mail nao pode conter apenas espacos, estar vazio ou nulo")
	@Pattern(regexp = ExpressoesRegulares.FORMATACAO_EMAIL_SIMPLES, message = "E-mail invalido")
	private String email;

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the primeiro nome.
	 *
	 * @return the primeiro nome
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	/**
	 * Sets the primeiro nome.
	 *
	 * @param primeiroNome the new primeiro nome
	 */
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	/**
	 * Gets the sobrenome.
	 *
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Sets the sobrenome.
	 *
	 * @param sobrenome the new sobrenome
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * Gets the data de nascimento.
	 *
	 * @return the data de nascimento
	 */
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	/**
	 * Sets the data de nascimento.
	 *
	 * @param dataDeNascimento the new data de nascimento
	 */
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	/**
	 * Gets the cargo.
	 *
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Sets the cargo.
	 *
	 * @param cargo the new cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Gets the salario.
	 *
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * Sets the salario.
	 *
	 * @param salario the new salario
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public Set<Telefone> getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (obj.getClass() != getClass()) {
			return false;
		}

		Funcionario funcionario = (Funcionario) obj;
		return new EqualsBuilder().append(cpf, funcionario.getCpf()).isEquals();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(cpf).hashCode();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}