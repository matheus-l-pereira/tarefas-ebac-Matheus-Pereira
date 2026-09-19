package br.com.mpereira.dao.jpa;

import br.com.mpereira.dao.generic.jpa.GenericJpaDB3Dao;
import br.com.mpereira.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3Dao extends GenericJpaDB3Dao<ClienteJpa2, Long> implements IClienteJpaDao<ClienteJpa2> {
	public ClienteJpaDB3Dao() {
		super(ClienteJpa2.class);
	}
}
