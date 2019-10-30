package br.com.contmatic.empresa.endereco;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public enum UFBRASIL {

	AC("AC", "Acre"),
	AL("AL", "Alagoas"),
	AM("AM", "Amazonas"),
	AP("AP", "Amapá"),
	BA("BA", "Bahia"),
	CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Espírito Santo"),
	GO("GO", "Goiás"),
	MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Pará"),
	PB("PB", "Paraíba"),
	PR("PR", "Paraná"),
	PE("PE", "Pernambuco"),
	PI("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rondônia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "São Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");
	
	private String uf;
	
	private String regiao;

	private UFBRASIL(String uf, String regiao) {
		this.uf = uf;
		this.regiao = regiao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	
	
}
