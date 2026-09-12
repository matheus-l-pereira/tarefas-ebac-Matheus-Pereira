package br.com.mpereira.services.jpa;

import java.io.Serializable;
import java.util.Collection;

import br.com.mpereira.dao.Persistente;
import br.com.mpereira.dao.generic.jpa.IGenericJpaDao;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.MaisDeUmRegistroException;
import br.com.mpereira.exceptions.TableException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable> implements IGenericJpaService<T, E>{

	
protected IGenericJpaDao<T, E> dao;
	
	public GenericJpaService(IGenericJpaDao<T, E> dao) {
		this.dao = dao;
	}
	

	@Override
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(T entity) throws DAOException {
		this.dao.excluir(entity);
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
		return this.dao.consultar(valor);
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}
}
