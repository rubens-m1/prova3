package br.com.contmatic.empresa;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.URL;

import br.com.contmatic.empresa.util.ExpressoesRegulares;

public class SitesEmpresa {


	@Pattern(regexp = ExpressoesRegulares.FORMATACAO_URL, message = "site invalido")
	@Size(min = 1,  max =255, message = "Url deve ter número de caracteres entre 1 a 255") 
	
	private String url;
	
	public SitesEmpresa() {
		super();
	}

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
