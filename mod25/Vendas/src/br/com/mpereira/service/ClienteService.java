package br.com.mpereira.service;

import br.com.mpereira.dao.ClienteDAO;
import br.com.mpereira.dao.IClienteDAO;
import br.com.mpereira.domain.Cliente;
import br.com.mpereira.exceptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO){
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);
    }
    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
    }
}
