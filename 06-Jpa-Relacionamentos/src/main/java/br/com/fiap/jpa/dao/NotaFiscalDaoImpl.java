package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.NotaFiscal;

public class NotaFiscalDaoImpl 
			extends GenericDaoImpl<NotaFiscal, Integer>
								implements NotaFiscalDao {

	public NotaFiscalDaoImpl(EntityManager em) {
		super(em);
	}

}
