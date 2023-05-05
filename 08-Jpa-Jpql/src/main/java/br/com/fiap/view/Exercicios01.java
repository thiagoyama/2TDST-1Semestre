package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.impl.ClienteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Exercicios01 {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um ClienteDao
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		//Listar todos os nomes dos clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar todos os Clientes");
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
		}
		
		//Buscar os clientes por parte do nome
		clientes = clienteDao.buscarPorNome("Ju");
		System.out.println("Buscar clientes por parte do nome");
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
		}
		
	}//main
}//class