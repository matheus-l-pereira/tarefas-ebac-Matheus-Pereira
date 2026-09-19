package br.com.mpereira.jpa;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.mpereira.dao.jpa.ClienteJpaDB2Dao;
import br.com.mpereira.dao.jpa.ClienteJpaDao;
import br.com.mpereira.dao.jpa.IClienteJpaDao;
import br.com.mpereira.domain.jpa.ClienteJpa;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.MaisDeUmRegistroException;
import br.com.mpereira.exceptions.TableException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

public class ClienteJpaDao2BancosTest {
	
	private IClienteJpaDao<ClienteJpa> clienteDao;
	
	private IClienteJpaDao<ClienteJpa> clienteDB2Dao;
	
	private Random rd;
	
	public ClienteJpaDao2BancosTest() {
		this.clienteDao = new ClienteJpaDao();
		this.clienteDB2Dao = new ClienteJpaDB2Dao();
		rd = new Random();
	}

	@After
	public void end() {
	    try {
	        Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
	        excluir1(list1);
	    } catch (DAOException e) {
	        e.printStackTrace();
	    }

	    try {
	        Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
	        excluir2(list2);
	    } catch (DAOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void excluir1(Collection<ClienteJpa> list) {
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private void excluir2(Collection<ClienteJpa> list) {
		list.forEach(cli -> {
			try {
				clienteDB2Dao.excluir(cli);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, DAOException, TableException, TipoChaveNaoEncontradaException{
		ClienteJpa cliente = criarCliente();
		clienteDao.cadastrar(cliente);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		cliente.setId(null);
		clienteDB2Dao.cadastrar(cliente);
		
		ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado2);
		
	}
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		
		ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
		Assert.assertNull(clienteConsultado1);
	}
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Rodrigo Pires");
		clienteDao.alterar(clienteConsultado);
		
		ClienteJpa clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa cliente1 = criarCliente();
		ClienteJpa retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertNotNull(retorno1);
		
		Collection<ClienteJpa> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});
		
		Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private ClienteJpa criarCliente() {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Matheus");
		cliente.setCidade("Mauá");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

	
}
