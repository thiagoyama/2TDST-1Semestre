package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TesteData {

	public static void main(String[] args) {
		//Criar um objeto do tipo Calendar com a data atual
		Calendar dataHoje = Calendar.getInstance();
		
		//Exibir a data
		System.out.println(dataHoje);

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println(formatador.format(dataHoje.getTime()));
		
	}
}