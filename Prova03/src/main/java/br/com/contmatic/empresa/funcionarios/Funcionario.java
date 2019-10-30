package br.com.contmatic.empresa.funcionarios;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.LocalDate;

import br.com.contmatic.empresa.telefone.Telefone;

public class Funcionario{

	@CPF
	@NotBlank
	private String cpf;

	@NotBlank
	@Size
	private String primeiroNome;

	@NotBlank
	@Size
	private String sobrenome;

	// FAZER RESTRIÇÃO DE IDADE
	private LocalDate dataDeNascimento;

	@NotBlank
	@Size
	private String cargo;

	// PENSAR
	private String salario;

	@Valid
	private EnderecoDoFuncionario enderecoFuncionario;

	
	@Valid
	@NotNull
	private Set<Telefone> telefone;

	@Email
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

	public void setEnderecoFuncionario(EnderecoDoFuncionario enderecoFuncionario) {
		this.enderecoFuncionario = enderecoFuncionario;
	}
	
	public EnderecoDoFuncionario getEnderecoFuncionario() {
		return enderecoFuncionario;
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