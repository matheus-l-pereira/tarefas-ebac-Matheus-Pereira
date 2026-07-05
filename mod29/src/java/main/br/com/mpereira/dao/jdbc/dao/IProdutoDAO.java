package br.com.mpereira.dao.jdbc.dao;

import java.util.List;

import br.com.mpereira.domain.Produto;

public interface IProdutoDAO {

	Integer cadastrar(Produto produto) throws Exception;

	Produto consultar(String codigo) throws Exception;

	Integer excluir(Produto produtoBD) throws Exception;

	List<Produto> buscarTodos() throws Exception;

	Integer atualizar(Produto produtoBD) throws Exception;
	
	

}
