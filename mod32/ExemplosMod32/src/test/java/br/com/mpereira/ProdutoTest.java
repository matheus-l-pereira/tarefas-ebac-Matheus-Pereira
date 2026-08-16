/**
 * 
 */
package br.com.mpereira;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.mpereira.dao.IProdutoDao;
import br.com.mpereira.dao.ProdutoDao;
import br.com.mpereira.domain.Produto;

/**
 * 
 */
public class ProdutoTest {
	
	private IProdutoDao produtoDao;
	
	public ProdutoTest() {
		produtoDao = new ProdutoDao();
	}
	
	@Test
	public void cadastrar() {
		
		Produto produto = new Produto();
		produto.setNome("Goiabinhas");
		produto.setCodigo("A01");
		produto.setDescricao("Biscoito recheado sabor goiaba");
		
		produto = produtoDao.cadastrar(produto);
		
		assertNotNull(produto);
		assertNotNull(produto.getId());
	}
}
