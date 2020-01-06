package br.com.contmatic.empresa;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.contmatic.empresa.funcionario.Funcionario;

public class Email {

	@NotNull(message = "Funcionario nao pode ser nulo")
	@Valid
	private Funcionario funcionario;


	@org.hibernate.validator.constraints.Email
	@NotBlank(message = "Email nao pode conter apenas espacos, estar vazio ou nulo")
	private String email;


	public Email() {
		super();
	}

	public Email(Funcionario funcionario, String area, String email) {
		super();
		this.funcionario = funcionario;
		this.email = email;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

		Email emailsEmpresa = (Email) obj;
		return new EqualsBuilder().append(email, emailsEmpresa.email).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(email).hashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
