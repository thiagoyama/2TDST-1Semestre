package br.com.fiap.view;

import br.com.fiap.model.Aluno;

public class Teste {

	//Criar o método main
	public static void main(String[] args) {
		//Instanciar um aluno com o nome
		Aluno a1 = new Aluno("Guilherme", 17);
		
		//Exibir o nome e idade do aluno
		System.out.println(a1.getNome() + " " + a1.getIdade());
		
		a1.descansar();
		
	}
}