package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.dao.ClienteDaoImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.exception.EntidadeNaoEcontradaException;
import br.com.fiap.jpa.sigleton.EntityManagerFactorySingleton;

public class ExemploPesquisaOneToMany {

	public static void main(String[] args) {
		//Criar o Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar o ClienteDao
		ClienteDao dao = new ClienteDaoImpl(em);
		
		try {
			//Pesquisar o cliente pelo codigo
			Cliente cliente = dao.buscar(2);
			//Exibir o nome do cliente
			System.out.println(cliente.getNome());
			//Exibir os valores dos pedidos do cliente
			System.out.println("Pedidos:");
			for (Pedido pedido : cliente.getPedidos()) {
				System.out.println(pedido.getValor());
				//Exibir os produtos do Pedido!
				System.out.println("Produtos");
				for (Produto produto : pedido.getProdutos()) {
					System.out.println(produto.getNome());
				}
			}
		} catch (EntidadeNaoEcontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}