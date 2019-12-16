package br.com.contmatic.empresa.endereco;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.contmatic.empresa.util.ExpressoesRegulares;

public class Endereco {

	@Pattern(regexp = ExpressoesRegulares.ALFANUMERICO_COM_ESPAÇO_Ç_E_ACENTOS, message = "Caractere invalido")
	@NotBlank(message = "Logradouro nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 4, max = 200, message = "Logradouro deve conter de 5 a 200 caracteres")
	private String logradouro;

	@NotBlank(message = "Numero nao pode conter apenas espacos, estar vazio ou nulo")
	@Min(value = 0, message = "Numero nao pode ser menor que 0")
	@Max(value = 999999, message = "Numero nao pode ser maior que 999999")
	private String numero;

	@NotBlank(message = "Cep nao pode conter apenas espacos, estar vazio ou nulo")
	@Min(value = 01001000, message = "Cep invalido")
	@Max(value = 99999999, message = "Cep invalido")
	@Size(min = 8, max = 8, message = "Cep deve conter 8 digitos")
	@Pattern(regexp = ExpressoesRegulares.CEP, message = "Formato de cep invalido")
	private String cep;

	@Size(max = 100, message = "Logradouro deve conter no maximo 100 caracteres")
	private String complemento;

	@Valid
	@NotNull(message = "Tipo de Endereco nao pode ser nulo")
	private TIPODEENDERECO tipo;

	// @NotBlank(message = "Bairro nao pode conter apenas espacos, estar vazio ou
	// nulo")
	@Valid
	@NotNull(message = "Bairro nao pode ser nulo")
	private Bairro bairro;

	// @NotBlank(message = "Cidade nao pode conter apenas espacos, estar vazia ou
	// nula")
	@Valid
	@NotNull(message = "Cidade nao pode ser nula")
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
		return new EqualsBuilder().append(numero, endereco.getNumero()).append(cep, endereco.getCep()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getNumero()).append(getCep()).hashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
