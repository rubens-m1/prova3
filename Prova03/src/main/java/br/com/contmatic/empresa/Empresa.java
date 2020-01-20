package br.com.contmatic.empresa;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.joda.time.LocalDate;

import br.com.contmatic.empresa.endereco.Endereco;
import br.com.contmatic.empresa.funcionario.Funcionario;
import br.com.contmatic.empresa.telefone.Telefone;

/**
 * The Class Empresa.
 */
public final class Empresa {
 
	/** The cnpj. */
	@NotBlank(message = "CNPJ nao pode conter apenas espacos, estar vazio ou nulo")
	@CNPJ(message = "CNPJ invalido.")
	private String cnpj;

	
	/** The razao social. */
	@NotBlank(message = "Razão social não pode conter apenas espacos, estar vazia ou nula")
	@Size(min=1, max=100, message = "Razão social deve ter de 1 a 100 caracteres")
	private String razaoSocial;

	/** The nome fantasia. */
	@Size(min=1, max=100, message = "Nome Fantasia deve ter de 1 a 100 caracteres")
	private String nomeFantasia;

	/** The endereco. */
	@Valid
	@NotNull(message = "Endereço não pode ser nulo")
	@Size.List({ @Size(min = 1, message = "A lista de endereço está vazia"),
		@Size(max = 100, message = "A quantidade maxima é de 100 enderecos") })
	private Set<Endereco> endereco;

	/** The telefone. */
	@Valid
	@NotNull(message = "Telefone não pode ser nulo")
	@Size.List({ @Size(min = 1, message = "A lista de telefone esta vazia"),
		@Size(max = 100, message = "A quantidade maxima é de 100 telefones") })
	private Set<Telefone> telefone;

	/** The funcionario. */
	@Valid
	@NotNull(message = "Funcionario não pode ser nulo")
	@Size.List({ @Size(min = 1, message = "A lista de funcionarios esta vazia"),
		@Size(max = 100, message = "A quantidade maxima é de 100 funcionarios") })
	private Set<Funcionario> funcionario;

	/** The email empresa. */
	@Valid
	@NotNull(message = "E-mail não pode ser nulo")
	@Size.List({ @Size(min = 1, message = "A lista de e-mails deve conter pelo menos um email"),
		@Size(max = 100, message = "A quantidade maxima é de 100 emails") })
	private Set<Email> emailEmpresa;

	/** The site. */
	@Valid
	@Size.List({@Size(max = 100, message = "A quantidade maxima é de 100 sites") })	
	private Set<SitesEmpresa> site;

	/** The data de registro. */
	@Past(message = "Data de nascimento não pode ser no futuro")
	@NotNull(message = "Data de registro não pode ser nula")
	@Future
	private LocalDate dataDeRegistro;

	/**
	 * Instantiates a new empresa.
	 */
	public Empresa() {
		
	}
	
	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Gets the razao social.
	 *
	 * @return the razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Sets the razao social.
	 *
	 * @param razaoSocial the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Gets the nome fantasia.
	 *
	 * @return the nome fantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * Sets the nome fantasia.
	 *
	 * @param nomeFantasia the new nome fantasia
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public Set<Endereco> getEndereco() {
		return endereco;
	}

	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(Set<Endereco> endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public Set<Telefone> getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	/**
	 * Gets the funcionario.
	 *
	 * @return the funcionario
	 */
	public Set<Funcionario> getFuncionario() {
		return funcionario;
	}

	/**
	 * Sets the funcionario.
	 *
	 * @param funcionario the new funcionario
	 */
	public void setFuncionario(Set<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Gets the email empresa.
	 *
	 * @return the email empresa
	 */
	public Set<Email> getEmailEmpresa() {
		return emailEmpresa;
	}

	/**
	 * Sets the email empresa.
	 *
	 * @param emailEmpresa the new email empresa
	 */
	public void setEmailEmpresa(Set<Email> emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	/**
	 * Gets the site.
	 *
	 * @return the site
	 */
	public Set<SitesEmpresa> getSite() {
		return site;
	}

	/**
	 * Sets the site.
	 *
	 * @param site the new site
	 */
	public void setSite(Set<SitesEmpresa> site) {
		this.site = site;
	}

	/**
	 * Gets the data de registro.
	 *
	 * @return the data de registro
	 */
	public LocalDate getDataDeRegistro() {
		return dataDeRegistro;
	}

	/**
	 * Sets the data de registro.
	 *
	 * @param dataDeRegistro the new data de registro
	 */
	public void setDataDeRegistro(LocalDate dataDeRegistro) {
		this.dataDeRegistro = dataDeRegistro;
	}
	
    /**
     * Acicionar endereco.
     *
     * @param endereco the endereco
     * @return true, if successful
     */
    public boolean acicionarEndereco(Endereco endereco) {
        checkNotNull(endereco, "Endereço não pode ser nulo.");
        this.endereco.add(endereco);
        return true;
    }

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public final boolean equals(Object obj) {
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

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(cnpj).toHashCode();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
