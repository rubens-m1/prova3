package br.com.contmatic.empresa.endereco;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.contmatic.empresa.util.ExpressoesRegulares;

/**
 * The Class Endereco.
 */
public final class Endereco {

	/** The logradouro. */
	@Pattern(regexp = ExpressoesRegulares.ALFANUMERICO_COM_ESPAÇO_Ç_E_ACENTOS, message = "Caractere invalido")
	@NotBlank(message = "Logradouro nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 4, max = 200, message = "Logradouro deve conter de 5 a 200 caracteres")
	private String logradouro;

	/** The numero. */
	@NotBlank(message = "Numero nao pode conter apenas espacos, estar vazio ou nulo")
	@Min(value = 0, message = "Numero nao pode ser menor que 0")
	@Max(value = 999999, message = "Numero nao pode ser maior que 999999")
	private String numero;

	/** The cep. */
	@NotBlank(message = "Cep nao pode conter apenas espacos, estar vazio ou nulo")
	@Min(value = 01001000, message = "Cep invalido")
	@Max(value = 99999999, message = "Cep invalido")
	@Size(min = 8, max = 8, message = "Cep deve conter 8 digitos")
	@Pattern(regexp = ExpressoesRegulares.CEP, message = "Formato de cep invalido")
	private String cep;

	/** The complemento. */
	@Size(max = 100, message = "Logradouro deve conter no maximo 100 caracteres")
	private String complemento;

	/** The tipo. */
	@Valid
	@NotNull(message = "Tipo de Endereco nao pode ser nulo")
	private TIPODEENDERECO tipo;

	/** The bairro. */
	@Valid
	@NotNull(message = "Bairro nao pode ser nulo")
	private Bairro bairro;

	/** The cidade. */
	@Valid
	@NotNull(message = "Cidade nao pode ser nula")
	private Cidade cidade;

	/**
	 * Gets the logradouro.
	 *
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Sets the logradouro.
	 *
	 * @param logradouro the new logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	 * Gets the cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Sets the cep.
	 *
	 * @param cep the new cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Gets the complemento.
	 *
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Sets the complemento.
	 *
	 * @param complemento the new complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public TIPODEENDERECO getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(TIPODEENDERECO tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public Bairro getBairro() {
		return bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	/**
	 * Gets the cidade.
	 *
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * Sets the cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

		Endereco endereco = (Endereco) obj;
		return new EqualsBuilder().append(numero, endereco.numero).append(cep, endereco.cep).isEquals();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(numero).append(cep).hashCode();
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
