/**
 * 
 */
package br.com.mpereira.services;

import br.com.mpereira.dao.IProdutoDAO;
import br.com.mpereira.domain.Produto;
import br.com.mpereira.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
