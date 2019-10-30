package br.com.contmatic.empresa.funcionarios;

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

public class EnderecoDoFuncionario {

	@Length
	@NotBlank
	private String logradouroFuncionario;

	@NotNull(message = "numero nao pode ser nulo")
	@Min(value = 0, message = "numero nao pode ser menor que 0")
	@Max(value = 999999, message = "numero nao pode ser maior que 999999")
	private String numeroFuncionario;

	@NotBlank(message = "cep nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 8, max = 8, message = "cep fora do tamanho")
	// @Pattern(regexp = ExpressoesRegulares.CEP, message = "cep invalido")
	private String cepFuncionario;

	@Size
	private String complementoFuncionario;

	private String bairroFuncionario;

	private String cidadeFuncionario;

	private String estadoFuncionario;

	public String getLogradouroFuncionario() {
		return logradouroFuncionario;
	}

	public void setLogradouroFuncionario(String logradouroFuncionario) {
		this.logradouroFuncionario = logradouroFuncionario;
	}

	public String getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(String numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	public String getCepFuncionario() {
		return cepFuncionario;
	}

	public void setCepFuncionario(String cepFuncionario) {
		this.cepFuncionario = cepFuncionario;
	}

	public String getComplementoFuncionario() {
		return complementoFuncionario;
	}

	public void setComplementoFuncionario(String complementoFuncionario) {
		this.complementoFuncionario = complementoFuncionario;
	}

	public String getBairroFuncionario() {
		return bairroFuncionario;
	}

	public void setBairroFuncionario(String bairroFuncionario) {
		this.bairroFuncionario = bairroFuncionario;
	}

	public String getCidadeFuncionario() {
		return cidadeFuncionario;
	}

	public void setCidadeFuncionario(String cidadeFuncionario) {
		this.cidadeFuncionario = cidadeFuncionario;
	}

	public String getEstadoFuncionario() {
		return estadoFuncionario;
	}

	public void setEstadoFuncionario(String estadoFuncionario) {
		this.estadoFuncionario = estadoFuncionario;
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

		EnderecoDoFuncionario enderecoDoFuncionario = (EnderecoDoFuncionario) obj;
		return new EqualsBuilder().append(numeroFuncionario, enderecoDoFuncionario.getNumeroFuncionario())
				.append(cepFuncionario, enderecoDoFuncionario.getCepFuncionario())
				.append(complementoFuncionario, enderecoDoFuncionario.getComplementoFuncionario()).isEquals();

	}

	public int hashCode() {
		return new HashCodeBuilder().append(getNumeroFuncionario()).append(getCepFuncionario())
				.append(getComplementoFuncionario()).hashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
