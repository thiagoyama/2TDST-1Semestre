package br.com.fiap.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente,Integer> implements ClienteDao {

	public ClienteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Cliente> buscarPorNome(String nome) {
		return em.createQuery("from Cliente where lower(nome) like lower(:n)", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setMaxResults(2) //configurando o m�ximo de resultados da query
				.getResultList();
	}

	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :e", Cliente.class)
				.setParameter("e", estado)				
				.getResultList();
	}

	public List<Cliente> buscarPorDiasReserva(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :dias", Cliente.class)
				.setParameter("dias", dias)
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :churros "
				+ "and c.endereco.cidade.nome like :coca", Cliente.class)
				.setParameter("coca", "%" + cidade + "%")
				.setParameter("churros", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where "
				+ "c.endereco.cidade.uf in :soda", Cliente.class)
				.setParameter("soda", estados)
				.getResultList();
	}

}








