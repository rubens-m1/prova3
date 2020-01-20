package br.com.contmatic.empresa.endereco;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Bairro.
 */
public final class Bairro {

	/** The bairro. */
	@NotBlank(message = "Bairro nao pode ser nulo")
	@Size(min = 1, max = 100, message = "Quantidade de caracteres no bairro deve estar entre 1 e 100")
	@Pattern(regexp = "([a-zA-Z][0-9][ç][ ][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*", message = "Nome de bairro invalido")
	private String bairro;

	/**
	 * Instantiates a new bairro.
	 */
	public Bairro() {
		super();
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public final boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (obj.getClass() != getClass()) {
			return false;
		}

		Bairro bairro1 = (Bairro) obj;
		return new EqualsBuilder().append(bairro, bairro1.getBairro()).isEquals();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(bairro).hashCode();
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
