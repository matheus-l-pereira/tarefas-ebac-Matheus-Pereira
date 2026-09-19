package br.com.mpereira.dao.jpa;

import br.com.mpereira.dao.generic.jpa.GenericJpaDB1Dao;
import br.com.mpereira.domain.jpa.ProdutoJpa;

public class ProdutoJpaDao extends GenericJpaDB1Dao<ProdutoJpa, Long> implements IProdutoJpaDao {
	
	public ProdutoJpaDao() {
		super(ProdutoJpa.class);
	}
}
