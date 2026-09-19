package br.com.mpereira.jpa;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.mpereira.dao.jpa.ClienteJpaDB2Dao;
import br.com.mpereira.dao.jpa.ClienteJpaDB3Dao;
import br.com.mpereira.dao.jpa.ClienteJpaDao;
import br.com.mpereira.dao.jpa.IClienteJpaDao;
import br.com.mpereira.domain.jpa.ClienteJpa;
import br.com.mpereira.domain.jpa.ClienteJpa2;
import br.com.mpereira.exceptions.DAOException;
import br.com.mpereira.exceptions.MaisDeUmRegistroException;
import br.com.mpereira.exceptions.TableException;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;


public class ClienteJpaDao3BancosTest {
	
	private IClienteJpaDao<ClienteJpa> clienteDao;
	
	private IClienteJpaDao<ClienteJpa> clienteDB2Dao;
	
	private IClienteJpaDao<ClienteJpa2> clienteDB3Dao;
	
	private Random rd;
	
	public ClienteJpaDao3BancosTest() {
		this.clienteDao = new ClienteJpaDao();
		this.clienteDB2Dao = new ClienteJpaDB2Dao();
		this.clienteDB3Dao = new ClienteJpaDB3Dao();
		rd = new Random();
	}

	@After
	public void end() throws DAOException {
		Collection<ClienteJpa> list = clienteDao.buscarTodos();
		excluir(list, clienteDao);
		
		Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
		excluir(list2, clienteDB2Dao);
		
		Collection<ClienteJpa2> list3 = clienteDB3Dao.buscarTodos();
		excluir3(list3, clienteDB3Dao);

	}


	private void excluir(Collection<ClienteJpa> list, IClienteJpaDao<ClienteJpa> clienteDao) {
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch(DAOException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	private void excluir3(Collection<ClienteJpa2> list, IClienteJpaDao<ClienteJpa2> clienteDB3Dao) {
		list.forEach(cli -> {
			try {
				clienteDB3Dao.excluir(cli);
			}catch(DAOException e) {
				e.printStackTrace();
			}
		});
		
	}
	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, TableException, MaisDeUmRegistroException, DAOException{
		ClienteJpa cliente = criarCliente();
		clienteDao.cadastrar(cliente);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		cliente.setId(null);
		clienteDB2Dao.cadastrar(cliente);
		
		ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado2);
		
		ClienteJpa2 cliente2 = criarCliente2();
		clienteDB3Dao.cadastrar(cliente2);
		
		ClienteJpa2 clienteConsultado3 = clienteDB3Dao.consultar(cliente2.getId());
		Assert.assertNotNull(clienteConsultado3);
		
	}

	private ClienteJpa criarCliente() {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Matheus");
		cliente.setCidade("Mauá");
		cliente.setEnd("Rua das Goiabinhas");
		cliente.setNumero(456);
		cliente.setEstado("SP");
		cliente.setTel(1192345678L);
		return cliente;
	}
	
	private ClienteJpa2 criarCliente2() {
		ClienteJpa2 cliente = new ClienteJpa2();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Matheus");
		cliente.setCidade("Mauá");
		cliente.setEnd("Rua das Goiabinhas");
		cliente.setNumero(456);
		cliente.setEstado("SP");
		cliente.setTel(1192345678L);
		return cliente;
	}
}