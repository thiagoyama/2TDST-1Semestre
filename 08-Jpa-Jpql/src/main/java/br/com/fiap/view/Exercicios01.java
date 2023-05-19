package br.com.fiap.view;

import java.util.ArrayList;
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
		List<Cliente> clientes = clienteDao.listar(2, 3);
		System.out.println("Listar todos os Clientes");
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
		}
		
		//Buscar os clientes por parte do nome
		clientes = clienteDao.buscarPorNome("A");
		System.out.println("Buscar clientes por parte do nome");
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
		}
		
		//Buscar os clientes por estado
		clientes = clienteDao.buscarPorEstado("PR");
		System.out.println("Buscar os clientes por estado");
		for (Cliente c: clientes) {
			//Exibir o nome do cliente e o estado
			System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf());
		}
		
		//Buscar os clientes pelo numero de dias de reserva
		clientes = clienteDao.buscarPorDiasReserva(10);
		System.out.println("Buscar os clientes por dia de reserva");
		for (Cliente c: clientes) {
			System.out.println(c.getNome());
		}
		
		//Buscar os clientes por parte do nome e nome da cidade
		clientes = clienteDao.buscar("Paulo", "a");
		System.out.println("Buscar os clientes por nome e cidade");
		//Exibir o nome e o nome da cidade
		clientes.forEach(c -> System.out.println(c.getNome() + " " + 
				c.getEndereco().getCidade().getNome()));
		
		//Buscar os clientes por estados
		//Criar a lista com os estados
		List<String> estados = new ArrayList<String>();
		estados.add("BA");
		estados.add("PR");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar os clientes por estados");
		//Exibir o nome e o estado do cliente
		clientes.forEach(c -> System.out.println(c.getNome() + " " +
				c.getEndereco().getCidade().getUf()));
		
		
		//Contar os clientes por estado
		long qtd = clienteDao.contarPorEstado("PR");
		System.out.println("Quantidade de clientes: " + qtd );
		
		//Pesquisar cliente pelo CPF
		Cliente cliente = clienteDao.buscarPorCpf("50293494030");
		System.out.println("Buscar Cliente por CPF");
		System.out.println(cliente.getNome() + " " + cliente.getCpf());
		
	}//main
}//class








