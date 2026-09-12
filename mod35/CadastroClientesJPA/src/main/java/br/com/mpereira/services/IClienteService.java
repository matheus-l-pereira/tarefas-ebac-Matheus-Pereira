/**
 * 
 */
package br.com.mpereira.services;

import br.com.mpereira.domain.Cliente;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;
import br.com.mpereira.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
