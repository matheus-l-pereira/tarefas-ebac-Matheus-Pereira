package br.com.mpereira.dao.jpa;

import br.com.mpereira.dao.generic.jpa.IGenericJpaDao;
import br.com.mpereira.domain.jpa.ClienteJpa;

public interface IClienteJpaDao<T extends Persistente> extends IGenericJpaDao<T, Long> {

}
