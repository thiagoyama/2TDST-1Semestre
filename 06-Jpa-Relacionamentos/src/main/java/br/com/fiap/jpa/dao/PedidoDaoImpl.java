package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Pedido;

public class PedidoDaoImpl 
				extends GenericDaoImpl<Pedido, Integer>
										implements PedidoDao {

	public PedidoDaoImpl(EntityManager em) {
		super(em);
	}

}
