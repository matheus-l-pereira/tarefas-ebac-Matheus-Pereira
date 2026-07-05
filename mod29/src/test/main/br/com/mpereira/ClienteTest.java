package br.com.mpereira;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.mpereira.dao.jdbc.dao.ClienteDAO;
import br.com.mpereira.dao.jdbc.dao.IClienteDAO;
import br.com.mpereira.domain.Cliente;

public class ClienteTest {

	private IClienteDAO clienteDAO;
	
	 @Before
	    public void setUp() throws Exception {
	        clienteDAO = new ClienteDAO();
	        List<Cliente> list = clienteDAO.buscarTodos();
	        for (Cliente cli : list) {
	            clienteDAO.excluir(cli);
	        }
	    }
	 
	@Test
	public void cadastrarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Matheus Pereira");
		
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}
	
	@Test
	public void consultarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Matheus Pereira");
		
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}
	
	@Test
	public void buscarTodosTest() throws Exception {
		
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Matheus Pereira");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clientes = new Cliente();
		clientes.setCodigo("02");
		clientes.setNome("Julius Jorge");
		Integer qtd2 = dao.cadastrar(clientes);
		
		List<Cliente> list = dao.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int qtdDel = 0;
		for(Cliente cli : list) {
			dao.excluir(cli);
			qtdDel++;
		}
		
		assertEquals(list.size(), qtdDel);
		
		list = dao.buscarTodos();
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void atualizarTest() throws Exception{
		clienteDAO = new ClienteDAO();
		//cadastrar o primeiro cliente
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Matheus Pereira");
		Integer qtd = clienteDAO.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		//verificar se o cliente foi cadastrado
		Cliente clienteBD = clienteDAO.consultar("10");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		//atualizar clienteBD
		clienteBD.setCodigo("20");
		clienteBD.setNome("Outro Nome");
		Integer qtdUpdate = clienteDAO.atualizar(clienteBD);
		assertTrue(qtdUpdate == 1);
		
		//verificar se o cliente foi atualizado
		Cliente clienteBD1 = clienteDAO.consultar("20");
		assertNotNull(clienteBD1);
		assertEquals(clienteBD1.getId(), clienteBD.getId());
		assertEquals(clienteBD1.getCodigo(), clienteBD.getCodigo());
		assertEquals(clienteBD1.getNome(), clienteBD.getNome());
		
		//excluir todos os dados testados no banco
		List<Cliente> list = new ArrayList<>();
		for (Cliente cli : list) {
			clienteDAO.excluir(cli);
		}
		
	}
	
	@Test
	public void excluirTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Matheus Pereira");
		
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}
}
