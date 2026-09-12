package br.com.mpereira.dao.jpa;

import br.com.mpereira.dao.generic.jpa.GenericJpaDao;
import br.com.mpereira.domain.jpa.VendaJpa;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

/**
 *
 * Classe utilizada somente no teste para fazer a exclusão das vendas
 *
 */
public class VendaExclusaoJpaDao extends GenericJpaDao<VendaJpa, Long> implements IVendaJpaDao {
	
	public VendaExclusaoJpaDao() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
