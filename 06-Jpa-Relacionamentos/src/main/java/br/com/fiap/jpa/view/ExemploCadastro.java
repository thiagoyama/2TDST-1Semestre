package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDao;
import br.com.fiap.jpa.dao.NotaFiscalDaoImpl;
import br.com.fiap.jpa.dao.PedidoDao;
import br.com.fiap.jpa.dao.PedidoDaoImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.sigleton.EntityManagerFactorySingleton;

public class ExemploCadastro {

	public static void main(String[] args) {
		//Instanciar a Fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		//Instanciar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar os Daos
		PedidoDao pedidoDao = new PedidoDaoImpl(em);
		NotaFiscalDao notaDao = new NotaFiscalDaoImpl(em);
		
		//Instanciar um Pedido
		Pedido pedido = new Pedido(Calendar.getInstance(), 50.0);
		
		//Cadastrar o Pedido

		
		//Instanciar uma Nota
		
		//Cadastrar a Nota Fiscal
		
	}
}