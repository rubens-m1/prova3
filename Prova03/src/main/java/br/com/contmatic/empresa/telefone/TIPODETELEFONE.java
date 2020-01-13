package br.com.contmatic.empresa.telefone;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;


// TODO: Auto-generated Javadoc
/**
 * The Enum TIPODETELEFONE.
 */
public enum TIPODETELEFONE {
	
	/** The telefonecelular. */
	TELEFONECELULAR("9[0-9]{8}"),
	
	/** The telefonecomercial. */
	TELEFONECOMERCIAL("([1-9]|9[0-9])[0-9]{7}"),
	
	/** The telefonefixo. */
	TELEFONEFIXO("[1-9][0-9]{7}");
	
	/** The numero. */
	@NotBlank(message = "numero de telefone em branco")
	@Size(min = 8, max = 9, message = "numero deve conter 8 ou 9 digitos")
	@Pattern(regexp = "(9[0-9]{8})|([1-9]|9[0-9])[0-9]{7}|[1-9][0-9]{7}", message = "formato de telefone invalido")
	private String numero;
	
	/**
	 * Instantiates a new tipodetelefone.
	 *
	 * @param numero the numero
	 */
	private TIPODETELEFONE(String numero) {
		this.numero = numero;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
