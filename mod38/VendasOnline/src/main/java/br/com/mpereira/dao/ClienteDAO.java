/**
 * 
 */
package br.com.mpereira.dao;

import br.com.mpereira.dao.generic.GenericDAO;
import br.com.mpereira.domain.Cliente;

/**
 *
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super(Cliente.class);
	}

}
