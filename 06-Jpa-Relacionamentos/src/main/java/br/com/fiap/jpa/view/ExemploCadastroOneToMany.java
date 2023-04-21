package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.dao.ClienteDaoImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.sigleton.EntityManagerFactorySingleton;

public class ExemploCadastroOneToMany {

	public static void main(String[] args) {
		// Instanciar um cliente com nome e data nascimento
		Cliente cliente = new Cliente("Guilherme", 
				new GregorianCalendar(2002, Calendar.APRIL, 21));
		
		// Instanciar dois Pedidos com valor e data
		Pedido pedido1 = new Pedido(Calendar.getInstance(), 120.0);
		Pedido pedido2 = new Pedido(Calendar.getInstance(), 1000.0);
		
		//Adicionar os pedidos no cliente
		cliente.addPedido(pedido1);
		cliente.addPedido(pedido2);
		
		//Cadastrar os Produtos (com cascade)
		//Instanciar dois Produtos
		Produto sabonete = new Produto("Sabonete Azul", 5.00, 100);
		Produto pasta = new Produto("Pasta de dente", 10.0, 50);
		
		//Criar uma Lista de Produtos e adicionar os produtos
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(sabonete);
		produtos.add(pasta);
		
		//Setar a lista de produtos no Pedido
		pedido1.setProdutos(produtos);
		pedido2.setProdutos(produtos);
		
		// Instanciar a fabrica e o entity manager
		EntityManager em = EntityManagerFactorySingleton
								.getInstance().createEntityManager();
		
		// Instanciar o ClienteDao
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		// Cadastra o Cliente (cadastra o pedido com cascade)
		try {
			clienteDao.salvar(cliente);
			clienteDao.commit();
			System.out.println("Cliente e pedidos cadastrados!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
}//class