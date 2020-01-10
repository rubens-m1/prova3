package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

import static com.google.common.base.Preconditions.checkNotNull;

public class Empresa {

	@NotBlank(message = "CNPJ nao pode conter apenas espacos, estar vazio ou nulo")
	@CNPJ(message = "CNPJ invalido.")
	private String cnpj;

	
	@NotBlank(message = "Razão social não pode conter apenas espacos, estar vazia ou nula")
	@Size(min=1, max=100, message = "Razão social deve ter de 1 a 100 caracteres")
	private String razaoSocial;

	@Size(min=1, max=100, message = "Nome Fantasia deve ter de 1 a 100 caracteres")
	private String nomeFantasia;

	@Valid
	@NotNull(message = "Endereço não pode ser nulo")
	@Size.List({ @Size(min = 1, message = "A lista de endereço está vazia"),
		@Size(max = 100, message = "A quantidade maxima é de 100 enderecos") })
	private Set<Endereco> endereco;

	@Valid
	@NotNull(message = "Telefone não pode ser nulo")
	@Size.List({ @Size(min = 1, message = "A lista de telefone esta vazia"),
		@Size(max = 100, message = "A quantidade maxima é de 100 telefones") })
	private Set<Telefone> telefone;

	@Valid
	@NotNull(message = "Funcionario não pode ser nulo")
	@Size.List({ @Size(min = 1, message = "A lista de funcionarios esta vazia"),
		@Size(max = 100, message = "A quantidade maxima é de 100 funcionarios") })
	private Set<Funcionario> funcionario;

	@Valid
	@NotNull
	// @Size.List
	// @Size
	private Set<Email> emailEmpresa;

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
		checkNotNull(cnpj, "CNPJ nao pode ser nulo"); 
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

	public Set<Email> getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(Set<Email> emailEmpresa) {
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

	@Override
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cnpj).toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
