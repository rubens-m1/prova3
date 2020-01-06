package br.com.contmatic.empresa.endereco;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

public class Bairro {

	@NotBlank(message = "Bairro nao pode ser nulo")
	@Size(min = 1, max = 100, message = "Quantidade de caracteres no bairro deve estar entre 1 e 100")
	@Pattern(regexp = "([a-zA-Z][0-9][ç][ ][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*", message = "Nome de bairro invalido")
	private String bairro;

	public Bairro() {
		super();
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

		Bairro bairro1 = (Bairro) obj;
		return new EqualsBuilder().append(bairro, bairro1.getBairro()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(bairro).hashCode();
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
