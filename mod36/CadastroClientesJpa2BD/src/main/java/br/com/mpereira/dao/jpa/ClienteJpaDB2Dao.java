package br.com.mpereira.dao.jpa;

import br.com.mpereira.dao.generic.jpa.GenericJpaDB2Dao;
import br.com.mpereira.domain.jpa.ClienteJpa;

public class ClienteJpaDB2Dao extends GenericJpaDB2Dao<ClienteJpa, Long> implements IClienteJpaDao<ClienteJpa> {
	
	public ClienteJpaDB2Dao() {
		super(ClienteJpa.class);
	}
}
