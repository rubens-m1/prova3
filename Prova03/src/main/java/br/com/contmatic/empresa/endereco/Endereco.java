package br.com.contmatic.empresa.endereco;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Endereco {

	@NotBlank
	@Length
	private String logradouro;

	@NotNull(message = "numero nao pode ser nulo")
	@Min(value = 0, message = "numero nao pode ser menor que 0")
	@Max(value = 999999, message = "numero nao pode ser maior que 999999")
	private String numero;

	@NotBlank(message = "cep nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 8, max = 8, message = "cep fora do tamanho")
	// @Pattern(regexp = ExpressoesRegulares.CEP, message = "cep invalido")
	private String cep;

	@Size
	private String complemento;

	@Valid
	private TIPODEENDERECO tipo;
	
	private Bairro bairro;
	
	private Cidade cidade;
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public TIPODEENDERECO getTipo() {
		return tipo;
	}

	public void setTipo(TIPODEENDERECO tipo) {
		this.tipo = tipo;
	}
	
	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

		Endereco endereco = (Endereco) obj;
		return new EqualsBuilder().append(numero, endereco.getNumero()).append(cep, endereco.getCep())
				.append(complemento, endereco.getComplemento()).append(tipo, endereco.getComplemento()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getNumero()).append(getCep()).append(getComplemento()).append(getTipo())
				.hashCode();
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
