package br.com.contmatic.empresa.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class FormatoDataBr {
	
	//private LocalDate dataDeNascimento;
	
	//private static LocalDate maiorDeIdade;
	
	public static void main(String[] g) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatadorDataBr = DateTimeFormat.forPattern("dd/MM/yyyy");
		System.out.println(hoje.toString(formatadorDataBr));
		LocalDate gg = LocalDate.parse(hoje.toString(formatadorDataBr), formatadorDataBr);
		System.out.println(gg);
		System.out.println((hoje.equals(gg)));
	}
	
}


