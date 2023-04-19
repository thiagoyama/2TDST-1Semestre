package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDao;
import br.com.fiap.jpa.dao.NotaFiscalDaoImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.exception.EntidadeNaoEcontradaException;
import br.com.fiap.jpa.sigleton.EntityManagerFactorySingleton;

public class ExemploPesquisa {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o DAO da Nota
		NotaFiscalDao notaDao = new NotaFiscalDaoImpl(em);
		
		try {
			//Pesquisar a nota fiscal pelo ID
			NotaFiscal nota = notaDao.buscar(2);
			
			//Exibir o Valor da Nota Fiscal e o Valor do Pedido
			System.out.println("Valor da nota: " + nota.getValor());
			//System.out.println("Valor do pedido: " + nota.getPedido().getValor());
		} catch(EntidadeNaoEcontradaException e) {
			System.out.println(e.getMessage());
		}
	}
}