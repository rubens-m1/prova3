package br.com.contmatic.empresa;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

import br.com.contmatic.empresa.funcionario.Funcionario;

public class EmailsEmpresa {

	@NotNull
	@Valid
	private Funcionario funcionario;

	// CRIAR UM ENUM PARA TIPOS DE AREA
	@NotNull
	@Pattern(regexp = "")
	@Size
	private String area;

	@Email
	@NotNull
	private String email;

	public String getArea() {
		return area;
	}

	public EmailsEmpresa(Funcionario funcionario, String area, String email) {
		super();
		this.funcionario = funcionario;
		this.area = area;
		this.email = email;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setArea(String area) {
		this.area = area;
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

		EmailsEmpresa emailsEmpresa = (EmailsEmpresa) obj;
		return new EqualsBuilder().append(email, emailsEmpresa.email).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(email).hashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
