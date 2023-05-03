package br.com.fiap.exercicio.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.exercicio.dao.SistemaDao;
import br.com.fiap.exercicio.dao.impl.SistemaDaoImpl;
import br.com.fiap.exercicio.entity.CasoTeste;
import br.com.fiap.exercicio.entity.ItemTeste;
import br.com.fiap.exercicio.entity.Sistema;
import br.com.fiap.exercicio.entity.Usuario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.sigleton.EntityManagerFactorySingleton;

public class Cadastro {

	// Cadastrar todas as entidades utilizando o cascade
	public static void main(String[] args) {
		// Fabrica e Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Instanciar o SistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);

		// Instanciar o sistema
		Sistema sistema = new Sistema("Portal FIAP");

		// Instanciar 2 casos de teste
		CasoTeste caso1 = new CasoTeste("Notas", "Lançamento de Notas");
		CasoTeste caso2 = new CasoTeste("Aprovação", "Aprovar um aluno");

		// Adicionar os casos de teste no sistema
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);
		
		// Instanciar 2 itens de teste
		ItemTeste item1 = new ItemTeste("Lançar notas para os alunos");
		ItemTeste item2 = new ItemTeste("Aprovar alunos com média");

		// Adicionar os itens de teste no caso de teste
		caso1.addItemTeste(item1);
		caso2.addItemTeste(item2);

		// Instanciar 2 usuarios
		Usuario user1 = new Usuario("Admin");
		Usuario user2 = new Usuario("Prof");

		// Criar uma lista de Usuarios e adicionar os usu�rios
		List<Usuario> lista = new ArrayList<Usuario>();
		lista.add(user1);
		lista.add(user2);

		// Setar a lista de usuario nos itens de teste
		item1.setUsuarios(lista);
		item2.setUsuarios(lista);

		try {
			// Cadastrar o Sistema
			dao.salvar(sistema);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}

	}
}