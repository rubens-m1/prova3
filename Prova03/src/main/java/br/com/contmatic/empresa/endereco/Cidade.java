package br.com.contmatic.empresa.endereco;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.contmatic.empresa.util.ExpressoesRegulares;

public class Cidade {
	
	@Valid
	@NotNull(message = "A lista de bairros nao pode ser nula")
	private Set<Bairro> bairro;
	
	@Pattern(regexp = ExpressoesRegulares.ALFABETO_COM_ESPACO_Ç_E_ACENTOS, message = "Caractere invalido")
	@NotBlank(message = "Nome da cidade nao pode conter apenas espacos, estar vazio ou nulo")
	@Size(min = 1, max = 100, message = "Quantidade de caracteres no nome da cidade deve estar entre 1 e 100")
	private String nomeCidade;

	@Valid
	@NotNull(message = "UF da cidade nao pode ser nulo")
	private UFBRASIL uf;

	public Set<Bairro> getBairro() {
		return bairro;
	}

	public void setBairro(Set<Bairro> bairro) {
		this.bairro = bairro;
	}

	public UFBRASIL getUf() {
		return uf;
	}

	public void setUf(UFBRASIL uf) {
		this.uf = uf;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (obj.getClass() != getClass()){
			return false;
		}
		
		Cidade cidade = (Cidade) obj;
		return new EqualsBuilder().append(nomeCidade, cidade.getNomeCidade()).append(bairro, cidade.getBairro()).isEquals();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(nomeCidade).append(uf).hashCode();
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
