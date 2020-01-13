package br.com.contmatic.empresa.endereco;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

// TODO: Auto-generated Javadoc
/**
 * The Enum TIPODEENDERECO.
 */
public enum TIPODEENDERECO {
	
	/** The enderecoresidencial. */
	ENDERECORESIDENCIAL("Endereco Residencial"),
	
	/** The enderecocomercial. */
	ENDERECOCOMERCIAL("Endereci Comercial");
	
	/** The tipo. */
	private String tipo;
	
	/**
	 * Instantiates a new tipodeendereco.
	 *
	 * @param tipo the tipo
	 */
	private TIPODEENDERECO(String tipo) {
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
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
