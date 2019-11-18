package br.com.contmatic.empresa.util;

public final class ExpressoesRegulares {
	
	public static final String ALFABETO_COM_ESPACO_Ç_E_ACENTOS = "([a-zA-Z][ç][ ][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*";
	
	public static final String ALFABETO_COM_Ç_E_ACENTOS = "([a-zA-Z][ç][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*";
	
	public static final String ALFANUMERICO_COM_ESPAÇO_Ç_E_ACENTOS = "([a-zA-Z][0-9][ç][ ][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*";
	
	public static final String CEP = "[^00000000][0-9]{5}[-]?[0-9]{3}";
	
	public static final String CNPJ_00000000000000_INVALIDO = "[^00000000000000]";
	
	public static final String RESTRIÇAO_DE_ESPAÇOS = "[^ ]";
	
	public static final String FORMATACAO_EMAIL_SIMPLES = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]{2,3}";
	
}
