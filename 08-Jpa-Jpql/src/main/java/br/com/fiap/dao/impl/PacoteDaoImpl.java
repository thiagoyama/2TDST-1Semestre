package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.entity.Pacote;

public class PacoteDaoImpl extends GenericDaoImpl<Pacote,Integer> implements PacoteDao{

	public PacoteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Pacote> listar() {
		//Criar o comando JPQL
		TypedQuery<Pacote> query = 
				em.createQuery("from Pacote", Pacote.class);
		//Executar o comando
		return query.getResultList();
	}

	public List<Pacote> listarPorPrecoMaior(float preco) {
//		//Criar o comando JPQL
//		TypedQuery<Pacote> query = 
//				em.createQuery("from Pacote p where p.preco > :pre", Pacote.class);
//		//Setar o parametro no comando
//		query.setParameter("pre", preco);
//		//Executar o comando
//		return query.getResultList();
		return em.createQuery(
				"from Pacote p where p.preco > :pre", Pacote.class)
				.setParameter("pre", preco)
				.getResultList();
	}

}
