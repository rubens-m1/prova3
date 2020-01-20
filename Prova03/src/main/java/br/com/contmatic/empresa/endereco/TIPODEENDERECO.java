package br.com.contmatic.empresa.endereco;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Enum TIPODEENDERECO.
 */
public enum TIPODEENDERECO {
	
	/** The enderecoresidencial. */
	ENDERECORESIDENCIAL("Endereco Residencial"),
	
	/** The enderecocomercial. */
	ENDERECOCOMERCIAL("Endereco Comercial");
	
	/** The tipo. */
    @NotBlank(message = "Tipo de Endereco nao pode ser nulo")
	private String tipo;
	
	/**
	 * Instantiates a new tipodeendereco.
	 *
	 * @param tipo the tipo
	 */
	private TIPODEENDERECO(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Instantiates a new tipodeendereco.
	 */
	private TIPODEENDERECO() {
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
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
