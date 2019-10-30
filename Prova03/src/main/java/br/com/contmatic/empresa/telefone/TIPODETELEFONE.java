package br.com.contmatic.empresa.telefone;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;


public enum TIPODETELEFONE {
	
	TELEFONECELULAR("9[0-9]{8}"),
	TELEFONECOMERCIAL("([1-9]|9[0-9])[0-9]{7}"),
	TELEFONEFIXO("[1-9][0-9]{7}");
	
	@NotBlank(message = "numero de telefone em branco")
	@Size(min = 8, max = 9, message = "numero deve conter 8 ou 9 digitos")
	@Pattern(regexp = "(9[0-9]{8})|([1-9]|9[0-9])[0-9]{7}|[1-9][0-9]{7}", message = "formato de telefone invalido")
	private String numero;
	
	private TIPODETELEFONE(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
