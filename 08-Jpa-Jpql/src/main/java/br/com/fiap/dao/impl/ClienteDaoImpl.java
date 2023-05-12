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
		return em.createQuery("from Cliente where nome like :n", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setMaxResults(2) //configurando o máximo de resultados da query
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

}
