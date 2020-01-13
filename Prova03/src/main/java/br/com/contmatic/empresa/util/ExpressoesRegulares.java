package br.com.contmatic.empresa.util;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpressoesRegulares.
 */
public final class ExpressoesRegulares {
	
	/** The Constant ALFABETO_COM_ESPACO_Ç_E_ACENTOS. */
	public static final String ALFABETO_COM_ESPACO_Ç_E_ACENTOS = "([a-zA-Z][ç][ ][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*";
	
	/** The Constant ALFABETO_COM_Ç_E_ACENTOS. */
	public static final String ALFABETO_COM_Ç_E_ACENTOS = "([a-zA-Z][ç][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*";
	
	/** The Constant ALFANUMERICO_COM_ESPAÇO_Ç_E_ACENTOS. */
	public static final String ALFANUMERICO_COM_ESPAÇO_Ç_E_ACENTOS = "([a-zA-Z][0-9][ç][ ][áéíóúÁÉÍÓÚàÀãõÃÕâêôÂÊÔ])*";
	
	/** The Constant CEP. */
	public static final String CEP = "[^00000000][0-9]{5}[-]?[0-9]{3}";
	
	/** The Constant CNPJ_00000000000000_INVALIDO. */
	public static final String CNPJ_00000000000000_INVALIDO = "[^00000000000000]";
	
	/** The Constant RESTRIÇAO_DE_ESPAÇOS. */
	public static final String RESTRIÇAO_DE_ESPAÇOS = "[^ ]";
	
	/** The Constant FORMATACAO_EMAIL_SIMPLES. */
	public static final String FORMATACAO_EMAIL_SIMPLES = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]{2,3}";
	
	/** The Constant FORMATACAO_URL. */
	public static final String FORMATACAO_URL = "\"^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$\"";
	
}
