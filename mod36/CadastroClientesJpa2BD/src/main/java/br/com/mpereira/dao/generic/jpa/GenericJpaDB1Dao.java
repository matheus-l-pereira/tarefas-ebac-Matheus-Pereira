package br.com.mpereira.dao.generic.jpa;

import java.io.Serializable;

import br.com.mpereira.dao.jpa.Persistente;

public abstract class GenericJpaDB1Dao<T extends Persistente, E extends Serializable>
	extends GenericJpaDao<T, E>{
	
	public GenericJpaDB1Dao(Class<T> persitenteClass) {
		super(persitenteClass, "Postgre1");
	}

}
