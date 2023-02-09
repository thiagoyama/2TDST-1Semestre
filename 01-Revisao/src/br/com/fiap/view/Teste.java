package br.com.fiap.view;

import br.com.fiap.model.Aluno;

public class Teste {

	//Criar o m�todo main
	public static void main(String[] args) {
		
		//Instanciar um aluno com o nome
		Aluno a1 = new Aluno("Guilherme", 17);
		
		//Exibir o nome e idade do aluno
		System.out.println(a1.getNome() + " " + a1.getIdade());
		
		a1.descansar();
		String nome = "Guilherme";
		
		//Verificar se o nome do aluno � "Guilherme" -> se sim, exibir "Sim", sen�o exibir "N�o"
		if (a1.getNome().equals(nome)) { 
			System.out.println("Sim");
		} else { 
			System.out.println("N�o");
		}
		
		//Operador tern�rio -> (condicao ? se sim : se n�o)
		System.out.println(a1.getNome().equals("Guilherme")?"Sim":"N�o");
		
	}
}