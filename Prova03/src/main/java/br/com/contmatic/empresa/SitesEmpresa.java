package br.com.contmatic.empresa;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.URL;

public class SitesEmpresa {

	@URL
	private String url;

	public SitesEmpresa(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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
		return new EqualsBuilder().append(siteEmpresa, siteEmpresa.url).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(url).hashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
