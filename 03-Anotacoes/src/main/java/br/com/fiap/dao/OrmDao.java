package br.com.fiap.dao;

import br.com.fiap.anotacao.Tabela;

public class OrmDao {

	//Metodo que recebe um Object e exibe o comando SQL
	public void pesquisar(Object obj) {
		//Recuperar a anota��o @Tabela da classe
		Tabela anotacao = obj.getClass().getAnnotation(Tabela.class);
		//Recuperar o nome configurado na anota��o @Tabela
		String nomeTabela = anotacao.nome();
		//Exibir o comando SQL
		System.out.println("SELECT * FROM " + nomeTabela);
	}
	
}
