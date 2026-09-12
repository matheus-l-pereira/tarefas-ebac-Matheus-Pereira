package br.com.mpereira.jpa;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.mpereira.dao.jpa.IProdutoJpaDao;
import br.com.mpereira.dao.jpa.ProdutoJpaDao;
import br.com.mpereira.domain.jpa.ProdutoJpa;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.MaisDeUmRegistroException;
import br.com.mpereira.exceptions.TableException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoJpaDaoTest {
	
	private IProdutoJpaDao produtoDao;
	
	public ProdutoJpaDaoTest() {
		this.produtoDao = new ProdutoJpaDao();
	}
	
	@After
	public void end() throws DAOException{
		Collection<ProdutoJpa> list = produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				produtoDao.excluir(prod);
			}catch (DAOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisar() throws MaisDeUmRegistroException, DAOException, TableException, TipoChaveNaoEncontradaException{
		ProdutoJpa produto = criarProduto("A1");
		Assert.assertNotNull(produto);
		
		ProdutoJpa produtoConsultado = this.produtoDao.consultar(produto.getId());
		
		Assert.assertNotNull(produtoConsultado);
	}
	
	@Test
	public void salvar() throws MaisDeUmRegistroException, DAOException, TableException, TipoChaveNaoEncontradaException {
		ProdutoJpa produto = criarProduto("A2");
		Assert.assertNotNull(produto);
	}
	
	@Test
	public void excluir() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		ProdutoJpa produto = criarProduto("A3");
		Assert.assertNotNull(produto);
		
		this.produtoDao.excluir(produto);
		ProdutoJpa produtoDB = this.produtoDao.consultar(produto.getId());
		
		Assert.assertNull(produtoDB);
	}
	
	@Test
	public void alterarProduto() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		ProdutoJpa produto = criarProduto("A4");
		Assert.assertNotNull(produto);
		
		produto.setNome("Moranguete");
		produto.setDescricao("Moranguetes gostosos");
		produtoDao.alterar(produto);
		ProdutoJpa produtoDB = this.produtoDao.consultar(produto.getId());
		Assert.assertNotNull(produtoDB);
		Assert.assertEquals("Moranguete", produtoDB.getNome());
		Assert.assertEquals("Moranguetes gostosos", produtoDB.getDescricao());
	}
	
	@Test
	public void buscarTodos() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<ProdutoJpa> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (ProdutoJpa prod : list) {
			this.produtoDao.excluir(prod);
		}
		
		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
	}
	

	private ProdutoJpa criarProduto(String codigo) throws MaisDeUmRegistroException, DAOException, TableException, TipoChaveNaoEncontradaException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(codigo);
		produto.setDescricao("Goiabinhas gostosas");
		produto.setNome("Goiabinha");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
		return produto;
	}
	
}
