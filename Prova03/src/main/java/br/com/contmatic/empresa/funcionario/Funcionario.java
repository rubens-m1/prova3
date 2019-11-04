package br.com.contmatic.empresa.funcionario;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
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

	// FAZER RESTRIÇÃO DE IDADE
	//@NotBlank(message = "Data de nascimento nao pode conter apenas espacos, estar vazio ou nulo")
	private LocalDate dataDeNascimento;

	@NotBlank(message = "Cargo nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 2, max = 50, message = "O campo cargo nome deve conter de 2 a 50 caracteres")
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_ESPACO_Ç_E_ACENTOS, message = "O campo cargo deve conter somente letras e espacos")
	private String cargo;

	// PENSAR
	private String salario;

//	@Valid
	private Endereco endereco;

	
//	@Valid
//	@NotNull
	private Set<Telefone> telefone;

//	@Email
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

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
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