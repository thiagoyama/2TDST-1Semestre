package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.model.Aluno;

//Contrato com as assinaturas dos m�todos
public interface AlunoDao {

	void cadastrar(Aluno aluno);
	
	List<Aluno> listar();
	
}
