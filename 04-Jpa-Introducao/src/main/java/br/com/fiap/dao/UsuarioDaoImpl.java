package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private EntityManager em;
	
	//construtor que recebe o em
	public UsuarioDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Usuario usuario) {
		em.persist(usuario);
	}

	public Usuario pesquisar(int id) {
		return null;
	}

	public void atualizar(Usuario usuario) {
		em.merge(usuario);
	}

	public void deletar(int id) {
		
	}

}