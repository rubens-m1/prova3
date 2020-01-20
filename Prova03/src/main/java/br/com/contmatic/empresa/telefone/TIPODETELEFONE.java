package br.com.contmatic.empresa.telefone;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;


/**
 * The Enum TIPODETELEFONE.
 */
public enum TIPODETELEFONE {
	
	/** The telefonecelular. */
	TELEFONECELULAR("9[0-9]{8}"),
	
	/** The telefonefixo. */
	TELEFONEFIXO("[1-9][0-9]{7}");
	
	/** The numero. */
	@NotBlank(message = "numero de telefone em branco")
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
