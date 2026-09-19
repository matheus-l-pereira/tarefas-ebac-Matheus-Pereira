package br.com.mpereira.dao.generic.jpa;

import java.io.Serializable;

import br.com.mpereira.dao.jpa.Persistente;

public abstract class GenericJpaDB3Dao <T extends Persistente, E extends Serializable>
extends GenericJpaDao<T,E>{
	
	public GenericJpaDB3Dao(Class<T> persistenteClass) {
		super(persistenteClass, "Mysql1");
	}

}
