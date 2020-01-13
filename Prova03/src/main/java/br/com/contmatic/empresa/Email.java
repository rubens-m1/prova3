package br.com.contmatic.empresa;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.contmatic.empresa.funcionario.Funcionario;

// TODO: Auto-generated Javadoc
/**
 * The Class Email.
 */
public class Email {

	/** The funcionario. */
	@NotNull(message = "Funcionario nao pode ser nulo")
	@Valid
	private Funcionario funcionario;

	/** The email. */
	@org.hibernate.validator.constraints.Email
	@NotBlank(message = "Email nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min=6, max=50, message = "Email deve ter de 6 a 50 caracteres")
	private String email;

	/**
	 * Instantiates a new email.
	 */
	public Email() {
		super();
	}

	/**
	 * Instantiates a new email.
	 *
	 * @param funcionario the funcionario
	 * @param area the area
	 * @param email the email
	 */
	public Email(Funcionario funcionario, String area, String email) {
		super();
		this.funcionario = funcionario;
		this.email = email;
	}

	/**
	 * Gets the funcionario.
	 *
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Sets the funcionario.
	 *
	 * @param funcionario the new funcionario
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

		Email emailsEmpresa = (Email) obj;
		return new EqualsBuilder().append(email, emailsEmpresa.email).isEquals();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(email).hashCode();
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
