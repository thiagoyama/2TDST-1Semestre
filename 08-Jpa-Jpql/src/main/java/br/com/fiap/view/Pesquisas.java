package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisas {

	public static void main(String[] args) {
		//Instanciar o Entity Manager
		EntityManager em = EntityManagerFactorySingleton
								.getInstance().createEntityManager();

		//Instanciar o PacoteDao
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		
		//Listar todos os pacotes
		List<Pacote> pacotes = pacoteDao.listar();
		System.out.println("Todos os pacotes");
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getPreco());
		}
		
		//Listar todos os pacotes com preço maior do que 1000 reais
		pacotes = pacoteDao.listarPorPrecoMaior(1000);
		System.out.println("Pesquisar pacotes por preço maior");
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getPreco());
		}
		
	}//main
}//class