package br.com.contmatic.empresa;

import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.URL;

/**
 * The Class SitesEmpresa.
 */
public final class SitesEmpresa {


	/** The url. */
	@URL(message = "URL invalida")
	@Size(min = 4,  max =255, message = "Url deve ter número de caracteres entre 1 a 255") 
	private String url;
	
	/**
	 * Instantiates a new sites empresa.
	 */
	public SitesEmpresa() {
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
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

		SitesEmpresa siteEmpresa = (SitesEmpresa) obj;
		return new EqualsBuilder().append(url, siteEmpresa.url).isEquals();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(url).hashCode();
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
