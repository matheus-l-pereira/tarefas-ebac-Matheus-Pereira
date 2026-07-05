package br.com.mpereira;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.ArrayAsIterableMatcher;
import org.junit.Before;
import org.junit.Test;

import br.com.mpereira.dao.jdbc.dao.ClienteDAO;
import br.com.mpereira.dao.jdbc.dao.IProdutoDAO;
import br.com.mpereira.dao.jdbc.dao.ProdutoDAO;
import br.com.mpereira.domain.Cliente;
import br.com.mpereira.domain.Produto;

public class ProdutoTest {
	
	private IProdutoDAO produtoDAO;
	
	@Before
    public void setUp() throws Exception {
        produtoDAO = new ProdutoDAO();
        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
        	produtoDAO.excluir(prod);
        }
    }
	
	@Test
	public void cadastrarTest() throws Exception{
		//instanciar o Produto dao e o produto
		//settar nome e codigo, qtd assertTrue
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("01");
		produto.setNome("Goiabinha");
		
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		//consultar
		Produto produtoBD = dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produtoBD.getCodigo(), produto.getCodigo());
		assertEquals(produtoBD.getNome(), produto.getNome());
		
		Integer qtdDel = dao.excluir(produtoBD);
		assertNotNull(qtdDel);
	}
	
	@Test
	public void consultarTest() throws Exception{
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("02");
		produto.setNome("Batatinha");
		
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		Produto produtoBD = dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produtoBD.getCodigo(), produto.getCodigo());
		assertEquals(produtoBD.getNome(), produto.getNome());
		
		Integer qtdDel = dao.excluir(produtoBD);
		assertNotNull(qtdDel);
	}
	
	@Test
	public void excluirTest() throws Exception{
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("03");
		produto.setNome("Club Social");
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		Produto produtoBD = dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produtoBD.getCodigo(), produto.getCodigo());
		assertEquals(produtoBD.getNome(), produto.getNome());
		
		Integer qtdDel = dao.excluir(produtoBD);
		assertNotNull(qtdDel);
	}
	
	@Test
	public void buscarTodosTest() throws Exception{
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto1 = new Produto();
		produto1.setCodigo("01");
		produto1.setNome("Goiabinha");
		Integer qtd1 = dao.cadastrar(produto1);
		assertTrue(qtd1 == 1);
		
		Produto produto2 = new Produto();
		produto2.setCodigo("02");
		produto2.setNome("Batatinha");
		Integer qtd2 = dao.cadastrar(produto2);
		assertTrue(qtd2 == 1);
		
		List<Produto> list = dao.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int qtdDel = 0;
		for(Produto prod : list) {
			dao.excluir(prod);
			qtdDel++;
		}
		
		assertEquals(list.size(), qtdDel);
		
		list = dao.buscarTodos();
		assertEquals(list.size(), 0);
	
	}
	
	@Test
	public void atualizarTest() throws Exception{
		IProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("01");
		produto.setNome("Goiabinha");
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);
		
		Produto produtoBD = dao.consultar("01");
		assertNotNull(produtoBD);
		assertEquals(produtoBD.getCodigo(), produto.getCodigo());
		assertEquals(produtoBD.getNome(), produto.getNome());
		
		produtoBD.setCodigo("02");
		produtoBD.setNome("Outro Produto");
		Integer qtdUpd = dao.atualizar(produtoBD);
		assertTrue(qtdUpd == 1); 
		
		Produto produtoBD1 = dao.consultar("02");
		assertNotNull(produtoBD1);
		assertEquals(produtoBD1.getId(), produtoBD.getId());
		assertEquals(produtoBD1.getCodigo(), produtoBD.getCodigo());
		assertEquals(produtoBD1.getNome(), produtoBD.getNome());
		
		List<Produto> list = new ArrayList<>();
		for (Produto prod : list) {
			dao.excluir(prod);
		}
	}
}
