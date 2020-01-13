package br.com.contmatic.empresa;

import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.URL;

// TODO: Auto-generated Javadoc
/**
 * The Class SitesEmpresa.
 */
public class SitesEmpresa {


	/** The url. */
	@URL(message = "URL invalida")
	@Size(min = 4,  max =255, message = "Url deve ter número de caracteres entre 1 a 255") 
	private String url;
	
	/**
	 * Instantiates a new sites empresa.
	 */
	public SitesEmpresa() {
		super();
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

		SitesEmpresa siteEmpresa = (SitesEmpresa) obj;
		return new EqualsBuilder().append(url, siteEmpresa.getUrl()).isEquals();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
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
