package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.joda.time.LocalDate;

import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.Telefone;

public class Empresa {

	// size?
	// tirar o caso 000000000000
	@NotBlank
	@CNPJ
	private String cnpj;

	@NotBlank
	@Length
	@Pattern(regexp = "")
	private String razaoSocial;

	@Null
	@Length
	private String nomeFantasia;

	@Valid
	@NotNull
	// @Size.List
	// @Size
	private Set<Endereco> endereco;

	@Valid
	@NotNull
	// @Size.List
	// @Size
	private Set<Telefone> telefone;

	@Valid
	@NotNull
	// @Size.List
	// @Size
	private Set<Funcionario> funcionario;

	@Valid
	@NotNull
	// @Size.List
	// @Size
	private Set<EmailsEmpresa> emailEmpresa;

	@Valid
	@NotNull
	// @Size.List
	private Set<SitesEmpresa> site;

	// ESTA DATA TEM QUE SER IGUAL OU ANTERIOR A DATA ATUAL
	@Past
	private LocalDate dataDeRegistro;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Set<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(Set<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Set<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Set<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Set<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	public Set<EmailsEmpresa> getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(Set<EmailsEmpresa> emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public Set<SitesEmpresa> getSite() {
		return site;
	}

	public void setSite(Set<SitesEmpresa> site) {
		this.site = site;
	}

	public LocalDate getDataDeRegistro() {
		return dataDeRegistro;
	}

	public void setDataDeRegistro(LocalDate dataDeRegistro) {
		this.dataDeRegistro = dataDeRegistro;
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

		Empresa empresa = (Empresa) obj;
		return new EqualsBuilder().append(cnpj, empresa.cnpj).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(cnpj).hashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
