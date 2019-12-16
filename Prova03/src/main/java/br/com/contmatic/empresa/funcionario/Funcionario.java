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

public class Funcionario{

	@CPF(message = "CPF invalido")
	@NotBlank(message = "CPF nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 digitos")
	private String cpf;

	@NotBlank(message = "Primeiro Nome nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 1, max = 50, message = "O campo primeiro nome deve conter de 1 a 50 caracteres")
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_Ç_E_ACENTOS, message = "O campo deve conter somente letras")
	private String primeiroNome;

	@NotBlank(message = "Sobrenome nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 1, max = 50, message = "O campo sobrenome nome deve conter de 1 a 50 caracteres")
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_ESPACO_Ç_E_ACENTOS, message = "O campo sobrenome deve conter somente letras e espacos")
	private String sobrenome;

	@NotNull(message = "Data de nascimento não pode ser nula")
	@Past(message = "Data de nascimento não pode ser no futuro")
	private LocalDate dataDeNascimento;

	@NotBlank(message = "Cargo nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 2, max = 50, message = "O campo cargo nome deve conter de 2 a 50 caracteres")
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_ESPACO_Ç_E_ACENTOS, message = "O campo cargo deve conter somente letras e espacos")
	private String cargo;

	@NotNull(message = "Salario nao pode ser nulo")
	@Min(value = 998, message = "O valor do salario deve ser maior ou igual a 998")
	@Max(value = 999999999, message = "O valor do salario deve ser menor ou igual a 999999999")
	private Double salario;

	@Valid
	@NotNull(message = "Endereco nao pode ser nulo")
	private Endereco endereco;

	
	@Valid
	@NotNull(message = "Telefone nao pode ser nulo")
	private Set<Telefone> telefone;

	@NotBlank(message = "E-mail nao pode conter apenas espacos, estar vazio ou nulo")
	@Pattern(regexp = ExpressoesRegulares.FORMATACAO_EMAIL_SIMPLES, message = "E-mail invalido")
	private String email;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
		return new EqualsBuilder().append(cpf, funcionario.cpf).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(cpf).hashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}