/**
 * 
 */
package br.com.mpereira.dao;

import br.com.mpereira.dao.generic.IGenericDAO;
import br.com.mpereira.domain.Venda;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
