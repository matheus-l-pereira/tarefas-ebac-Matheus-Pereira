package br.com.mpereira.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;
import java.util.zip.DataFormatException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import br.com.mpereira.dao.jpa.ClienteJpaDao;
import br.com.mpereira.dao.jpa.IClienteJpaDao;
import br.com.mpereira.dao.jpa.IProdutoJpaDao;
import br.com.mpereira.dao.jpa.IVendaJpaDao;
import br.com.mpereira.dao.jpa.ProdutoJpaDao;
import br.com.mpereira.dao.jpa.VendaExclusaoJpaDao;
import br.com.mpereira.dao.jpa.VendaJpaDao;
import br.com.mpereira.domain.jpa.ClienteJpa;
import br.com.mpereira.domain.jpa.ProdutoJpa;
import br.com.mpereira.domain.jpa.VendaJpa;
import br.com.mpereira.domain.jpa.VendaJpa.Status;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.MaisDeUmRegistroException;
import br.com.mpereira.exceptions.TableException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

public class VendaJpaDaoTest {
	private IVendaJpaDao vendaDao;
	
	private IVendaJpaDao vendaExclusaoDao;
	
	private IClienteJpaDao clienteDao;
	
	private IProdutoJpaDao produtoDao;
	
	private Random rd;
	
	private ClienteJpa cliente;
	
	private ProdutoJpa produto;
	
	public VendaJpaDaoTest() {
		this.vendaDao = new VendaJpaDao();
		vendaExclusaoDao = new VendaExclusaoJpaDao();
		this.clienteDao = new ClienteJpaDao();
		this.produtoDao = new ProdutoJpaDao();
		rd = new Random();
	}
	
	@Before
	public void init() throws MaisDeUmRegistroException, DAOException, TableException, TipoChaveNaoEncontradaException{
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
	}
	
	@After
	public void end() throws DAOException{
		excluirVendas();
		excluirProdutos();
		clienteDao.excluir(this.cliente);
	}
	
	@Test
	public void pesquisar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		VendaJpa venda = criarVenda("A1");
		VendaJpa retorno = vendaDao.cadastrar(venda);
		Assert.assertNotNull(retorno);
		
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
		Assert.assertNotNull(vendaConsultada);
		Assert.assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		VendaJpa venda = criarVenda("A2");
		VendaJpa retorno = vendaDao.cadastrar(venda);
		Assert.assertNotNull(retorno);
		
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
		
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
		assertTrue(vendaConsultada != null);
		assertEquals(vendaConsultada.getCodigo(), venda.getCodigo());
	}
		
	@Test
	public void cancelarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A3";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(venda.getCodigo(), codigoVenda);
		
		retorno.setStatus(Status.CANCELADA);
		vendaDao.cancelarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
		assertEquals(vendaConsultada.getCodigo(), codigoVenda);
		assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
	}
	
	@Test
	public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A4";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(produto, 1);
		
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	}
	
	@Test
	public void adicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A5";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
		
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test(expected = DAOException.class)
	public void salvarVendaMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
		VendaJpa venda = criarVenda("A6");
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
	
		VendaJpa venda1 = criarVenda("A6");
		VendaJpa retorno1 = vendaDao.cadastrar(venda1);
		assertNull(retorno1);
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void removerProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A7";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		
		
		vendaConsultada.removerProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void removerApenasUmProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A8";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		
		
		vendaConsultada.removerProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 

	@Test
	public void removerTodosProdutos() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A9";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		
		
		vendaConsultada.removerTodosProdutos();
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 0);
		assertTrue(vendaConsultada.getValorTotal().equals(BigDecimal.valueOf(0)));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	} 
	
	@Test
	public void finalizarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A10";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void tentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A11";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
		
		vendaConsultada.adicionarProduto(this.produto, 1);
		
	}
	private VendaJpa criarVenda(String codigo) {
		VendaJpa venda = new VendaJpa();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.INICIADA);
		venda.adicionarProduto(this.produto, 2);
		return venda;
	}

	private ProdutoJpa cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(codigo);
		produto.setDescricao("Pamonha de Piracicaba");
		produto.setNome("Pamonha");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		return produto;
	}
	
	private ClienteJpa cadastrarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Matheus");
		cliente.setCidade("São Paulo");
		cliente.setEnd("Rua das goiabinhas");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1192345678L);
		clienteDao.cadastrar(cliente);
		return cliente;
	}
	
	private void excluirVendas() throws DAOException {
		Collection<VendaJpa> list = this.vendaExclusaoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.vendaExclusaoDao.excluir(prod);
			} catch(DAOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private void excluirProdutos() throws DAOException{
		Collection<ProdutoJpa> list = this.produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.produtoDao.excluir(prod);
			}catch (DAOException e) {
				e.printStackTrace();
			}
		});
		
	}

	
}
