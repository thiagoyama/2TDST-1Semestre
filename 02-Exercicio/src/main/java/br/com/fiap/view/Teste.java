package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Teste {

	public static void main(String[] args) {
		
		//Exemplo 1
		//Calendar data = new GregorianCalendar(2020, Calendar.FEBRUARY, 23);
		//ContaCorrente cc = new ContaCorrente(123, 321, data, 500, TipoConta.COMUM);
		
		//Instanciar uma Conta Corrente e uma Conta Poupança
		ContaCorrente cc = new ContaCorrente(123, 321, new GregorianCalendar(2020, Calendar.FEBRUARY, 23), 500, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(123,  333, Calendar.getInstance(), 1000, 2);
		
		//Chamar o método retirar da Conta Corrente
		try {
			cc.retirar(501);
			System.out.println("");
		}catch (SaldoInsuficienteException e) {
			
		}
		
		//Criar uma lista de Contas Correntes
		
		
		//Exibir os saldos das contas
		
		
	}
}