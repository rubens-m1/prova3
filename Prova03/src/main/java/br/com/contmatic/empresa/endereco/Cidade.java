package br.com.contmatic.empresa.endereco;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import br.com.contmatic.empresa.util.ExpressoesRegulares;

// TODO: Auto-generated Javadoc
/**
 * The Class Cidade.
 */
public class Cidade {

	/** The bairro. */
	@Valid
	@NotNull(message = "A lista de bairros nao pode ser nula")
	private Set<Bairro> bairro;
	
	/** The nome cidade. */
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_ESPACO_Ç_E_ACENTOS, message = "Caractere invalido")
	@NotBlank(message = "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 1, max = 100, message = "Quantidade de caracteres no nome da cidade deve estar entre 1 e 100")
	private String nomeCidade;

	/** The uf. */
	@Valid
	@NotNull(message = "UF da cidade nao pode ser nulo")
	private UFBRASIL uf;

	/**
	 * Instantiates a new cidade.
	 */
	public Cidade() {
		super();
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public Set<Bairro> getBairro() {
		return bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(Set<Bairro> bairro) {
		this.bairro = bairro;
	}

	/**
	 * Gets the uf.
	 *
	 * @return the uf
	 */
	public UFBRASIL getUf() {
		return uf;
	}

	/**
	 * Sets the uf.
	 *
	 * @param uf the new uf
	 */
	public void setUf(UFBRASIL uf) {
		this.uf = uf;
	}

	/**
	 * Gets the nome cidade.
	 *
	 * @return the nome cidade
	 */
	public String getNomeCidade() {
		return nomeCidade;
	}

	/**
	 * Sets the nome cidade.
	 *
	 * @param nomeCidade the new nome cidade
	 */
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
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
		
		if (obj.getClass() != getClass()){
			return false;
		}
		
		Cidade cidade = (Cidade) obj;
		return new EqualsBuilder().append(nomeCidade, cidade.nomeCidade).isEquals();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nomeCidade).append(uf).append(bairro).hashCode();
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
