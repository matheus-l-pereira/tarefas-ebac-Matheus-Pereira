package br.com.mpereira.dao.jpa;


import br.com.mpereira.dao.generic.jpa.GenericJpaDB1Dao;
import br.com.mpereira.domain.jpa.ClienteJpa;


public class ClienteJpaDao extends GenericJpaDB1Dao<ClienteJpa, Long> implements IClienteJpaDao<ClienteJpa> {

	public ClienteJpaDao() {
		super(ClienteJpa.class);
	}
}
