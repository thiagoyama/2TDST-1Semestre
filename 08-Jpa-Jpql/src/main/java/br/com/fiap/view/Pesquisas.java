package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
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
		
		//Listar todos os pacotes com preco maior do que 1000 reais
		pacotes = pacoteDao.listarPorPrecoMaior(1000);
		System.out.println("Pesquisar pacotes por preco maior");
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getPreco());
		}
		
		//Pesquisar um transporte
		TransporteDao transporteDao = new TransporteDaoImpl(em);
		Transporte transporte = transporteDao.pesquisar(3);
		pacotes = pacoteDao.buscarPorTransporte(transporte);
		System.out.println("Pesquisar pacotes pelo transporte");
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa());
		}
		
		//Pesquisar um pacote pela data saida
		Calendar inicio = new GregorianCalendar(2020, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2021, Calendar.DECEMBER, 31);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		System.out.println("Pesquisar pacotes por data de saida");
		pacotes.forEach(p -> System.out.println(p.getDescricao()));
		
		//Somar os valores dos pacotes por um transporte
		transporte = transporteDao.pesquisar(1);
		double soma = pacoteDao.somarPrecosPorTransporte(transporte);
		System.out.println("A soma dos preços dos pacote é: " + soma);
		
		//Pesquisar os pacotes por intervalo de dias
		pacotes = pacoteDao.buscarPorQuantidadeDias(8, 10);
		System.out.println("Buscar por intervalo de quantidade de dias");
		//Exibir a descrição e a qtd Dias
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getQtdDias());
		}
		
	}//main
}//class





