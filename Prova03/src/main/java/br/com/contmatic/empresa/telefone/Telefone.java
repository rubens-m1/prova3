package br.com.contmatic.empresa.telefone;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class Telefone.
 */
public class Telefone {

	/** The ddd. */
	@NotNull(message = "ddd nao pode ser nulo, vazio ou conter somente espaços")
	@Valid
	private DDD ddd;

	/** The numero. */
	@NotBlank(message = "numero nao pode ser nulo, vazio ou conter somente espaços")
	@Size(min = 8, max = 9, message = "numero deve conter 8 ou 9 digitos")
	@Pattern(regexp = "(9[0-9]{8})|([1-9]|9[0-9])[0-9]{7}|[1-9][0-9]{7}", message = "formato de telefone invalido")
	private String numero;

	/** The ramal. */
	@Max(value = 9999999, message = "ramal nao pode ser maior que 9999999")
	@Min(value = 0, message = "ramal nao pode ser menor que 0")
	private String ramal;

	/**
	 * Instantiates a new telefone.
	 *
	 * @param ddd the ddd
	 * @param numero the numero
	 * @param ramal the ramal
	 */
	public Telefone(DDD ddd, String numero, String ramal) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.ramal = ramal;

	}

	/**
	 * Instantiates a new telefone.
	 */
	public Telefone() {
		super();
	}

	/**
	 * Gets the ddd.
	 *
	 * @return the ddd
	 */
	public DDD getDdd() {
		return ddd;
	}

	/**
	 * Sets the ddd.
	 *
	 * @param ddd the new ddd
	 */
	public void setDdd(DDD ddd) {
		this.ddd = ddd;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Gets the ramal.
	 *
	 * @return the ramal
	 */
	public String getRamal() {
		return ramal;
	}

	/**
	 * Sets the ramal.
	 *
	 * @param ramal the new ramal
	 */
	public void setRamal(String ramal) {
		this.ramal = ramal;
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

		Telefone telefone = (Telefone) obj;
		return new EqualsBuilder().append(numero, telefone.getNumero())
				.append(ramal, telefone.getRamal()).isEquals();

	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDdd()).append(getNumero()).append(getRamal()).hashCode();
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
