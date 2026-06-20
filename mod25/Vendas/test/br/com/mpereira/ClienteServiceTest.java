package br.com.mpereira;

import br.com.mpereira.dao.IClienteDAO;
import br.com.mpereira.domain.Cliente;
import br.com.mpereira.dao.ClienteDaoMock;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;
import br.com.mpereira.service.ClienteService;
import br.com.mpereira.service.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {
    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }
    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(1234567890L);
        cliente.setNome("Matheus");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(11999999999L);

    }

    @Test
    public void pesquisarCliente(){

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
        Boolean retorno = clienteService.salvar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente()throws TipoChaveNaoEncontradaException{
        cliente.setNome("Matheus Pereira");
        clienteService.alterar(cliente);

        Assert.assertEquals("Matheus Pereira", cliente.getNome());
    }
}
