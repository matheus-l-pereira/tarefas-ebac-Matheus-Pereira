package br.com.mpereira.dao.jpa;

import br.com.mpereira.dao.generic.jpa.IGenericJpaDao;
import br.com.mpereira.domain.jpa.VendaJpa;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDao extends IGenericJpaDao<VendaJpa, Long>{

	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public VendaJpa consultarComCollection(Long id);
}
