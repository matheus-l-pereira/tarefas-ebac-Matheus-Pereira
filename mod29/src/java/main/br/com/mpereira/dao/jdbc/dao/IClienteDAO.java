package br.com.mpereira.dao.jdbc.dao;

import java.util.List;

import br.com.mpereira.domain.Cliente;

public interface IClienteDAO {

	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD)throws Exception;

	public List<Cliente> buscarTodos() throws Exception;

	public Integer atualizar(Cliente clienteBD) throws Exception;
}
