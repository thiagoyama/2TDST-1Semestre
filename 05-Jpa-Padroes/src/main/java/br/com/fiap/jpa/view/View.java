package br.com.fiap.jpa.view;

import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.sigleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter uma fabrica de Entity Manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
	}
}