package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dao.UsuarioDaoImpl;

public class TesteDao {

	//Verificar se os metodos do DAO estao funcionando
	public static void main(String[] args) {
		//Criar uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		//Criar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um DAO
		UsuarioDao dao = new UsuarioDaoImpl(em);
		
		//Cadastrar um usuario
		
		//Pesquisar um usuario
		
		//Atualizar um usuario
		
		//Remover um usuario
		
	}
}
