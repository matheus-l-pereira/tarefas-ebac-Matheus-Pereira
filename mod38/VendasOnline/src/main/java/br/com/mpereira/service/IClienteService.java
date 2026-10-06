/**
 * 
 */
package br.com.mpereira.service;

import br.com.mpereira.domain.Cliente;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.services.generic.IGenericService;

/**
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

}
