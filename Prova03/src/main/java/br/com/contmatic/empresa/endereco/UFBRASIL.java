package br.com.contmatic.empresa.endereco;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

// TODO: Auto-generated Javadoc
/**
 * The Enum UFBRASIL.
 */
public enum UFBRASIL {

	/** The ac. */
	AC("AC", "Acre"),
	
	/** The al. */
	AL("AL", "Alagoas"),
	
	/** The am. */
	AM("AM", "Amazonas"),
	
	/** The ap. */
	AP("AP", "Amapá"),
	
	/** The ba. */
	BA("BA", "Bahia"),
	
	/** The ce. */
	CE("CE", "Ceará"),
	
	/** The df. */
	DF("DF", "Distrito Federal"),
	
	/** The es. */
	ES("ES", "Espírito Santo"),
	
	/** The go. */
	GO("GO", "Goiás"),
	
	/** The ma. */
	MA("MA", "Maranhão"),
	
	/** The mt. */
	MT("MT", "Mato Grosso"),
	
	/** The ms. */
	MS("MS", "Mato Grosso do Sul"),
	
	/** The mg. */
	MG("MG", "Minas Gerais"),
	
	/** The pa. */
	PA("PA", "Pará"),
	
	/** The pb. */
	PB("PB", "Paraíba"),
	
	/** The pr. */
	PR("PR", "Paraná"),
	
	/** The pe. */
	PE("PE", "Pernambuco"),
	
	/** The pi. */
	PI("PI", "Piauí"),
	
	/** The rj. */
	RJ("RJ", "Rio de Janeiro"),
	
	/** The rn. */
	RN("RN", "Rio Grande do Norte"),
	
	/** The rs. */
	RS("RS", "Rio Grande do Sul"),
	
	/** The ro. */
	RO("RO", "Rondônia"),
	
	/** The rr. */
	RR("RR", "Roraima"),
	
	/** The sc. */
	SC("SC", "Santa Catarina"),
	
	/** The sp. */
	SP("SP", "São Paulo"),
	
	/** The se. */
	SE("SE", "Sergipe"),
	
	/** The to. */
	TO("TO", "Tocantins");
	
	/** The uf. */
	private String uf;
	
	/** The regiao. */
	private String regiao;

	/**
	 * Instantiates a new ufbrasil.
	 *
	 * @param uf the uf
	 * @param regiao the regiao
	 */
	private UFBRASIL(String uf, String regiao) {
		this.uf = uf;
		this.regiao = regiao;
	}

	/**
	 * Gets the uf.
	 *
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * Sets the uf.
	 *
	 * @param uf the new uf
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * Gets the regiao.
	 *
	 * @return the regiao
	 */
	public String getRegiao() {
		return regiao;
	}

	/**
	 * Sets the regiao.
	 *
	 * @param regiao the new regiao
	 */
	public void setRegiao(String regiao) {
		this.regiao = regiao;
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
