package br.com.mpereira.dao.generic.jpa;

import java.io.Serializable;
import java.util.Collection;

import br.com.mpereira.dao.jpa.Persistente;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.MaisDeUmRegistroException;
import br.com.mpereira.exceptions.TableException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

/**
*
* Interface genérica para métodos de CRUD(Create, Read, Update and Delete)
*/
public interface IGenericJpaDao <T extends Persistente, E extends Serializable> {

	    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

	    public void excluir(T entity) throws DAOException;

	    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

	    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;

	    public Collection<T> buscarTodos() throws DAOException;
	}

