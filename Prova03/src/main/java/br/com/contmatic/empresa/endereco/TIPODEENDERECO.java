package br.com.contmatic.empresa.endereco;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public enum TIPODEENDERECO {
	
	ENDERECORESIDENCIAL("Endereco Residencial"),
	ENDERECOCOMERCIAL("Endereci Comercial");
	
	private String tipo;
	
	private TIPODEENDERECO(String tipo) {
	}
	
	private TIPODEENDERECO() {
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}


}
