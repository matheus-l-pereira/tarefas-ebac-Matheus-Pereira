package br.com.mpereira.dao.jpa;

import br.com.mpereira.dao.generic.jpa.GenericJpaDao;
import br.com.mpereira.domain.jpa.ProdutoJpa;

public class ProdutoJpaDao extends GenericJpaDao<ProdutoJpa, Long> implements IProdutoJpaDao {
	
	public ProdutoJpaDao() {
		super(ProdutoJpa.class);
	}
}
