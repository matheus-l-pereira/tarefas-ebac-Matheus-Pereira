package br.com.mpereira.dao.jpa;


import br.com.mpereira.dao.generic.jpa.GenericJpaDao;
import br.com.mpereira.domain.jpa.ClienteJpa;


public class ClienteJpaDao extends GenericJpaDao<ClienteJpa, Long> implements IClienteJpaDao {

	public ClienteJpaDao() {
		super(ClienteJpa.class);
	}
}
