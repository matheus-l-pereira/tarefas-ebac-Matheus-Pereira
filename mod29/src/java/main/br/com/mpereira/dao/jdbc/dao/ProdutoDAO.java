package br.com.mpereira.dao.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.mpereira.dao.jdbc.ConnectionFactory;
import br.com.mpereira.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		//estabelecer conexão com o banco e preparar stm;
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			//inicializar o connection e atribuir a string a variável sql
			connection = ConnectionFactory.getConnection();
			String sql = "insert into tb_produto_2 (id, codigo, nome) values (nextval('sq_produto_2'), ?, ?)";
			//stm.setString
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getCodigo());
			stm.setString(2, produto.getNome());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
			// fechar stm e connection
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
	}

	@Override
	public Produto consultar(String codigo) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_produto_2 where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
			}
			return produto;
		}catch (Exception e){
			throw e;
		}finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer excluir(Produto produtoBD) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "delete from tb_produto_2 where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produtoBD.getCodigo());
			return stm.executeUpdate();
		}catch(Exception e) {
			throw e; 
		}finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public List<Produto> buscarTodos() throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		List<Produto> list = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_produto_2";
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				produto = new Produto();
				Long id = rs.getLong("id");
				String codigo = rs.getString("codigo");
				String nome = rs.getString("nome");
				produto.setId(id);
				produto.setCodigo(codigo);
				produto.setNome(nome);
				list.add(produto);
				
				}
			}catch(Exception e) {
				throw e;
			} finally {
				if(stm != null && !stm.isClosed()) {
					stm.close();
				}
				if(connection != null && !connection.isClosed()) {
					connection.close();
				}
			}
			return list;
		}

	@Override
	public Integer atualizar(Produto produtoBD) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "update tb_produto_2 set nome = ?, codigo = ? where id = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produtoBD.getNome());
			stm.setString(2, produtoBD.getCodigo());
			stm.setLong(3, produtoBD.getId());
			return stm.executeUpdate();
			
			}catch (Exception e) {
				throw e;
			}finally {
				if (stm != null && !stm.isClosed()) {
					stm.close();
				}
				if(connection != null && !connection.isClosed()) {
					connection.close();
				}	
			}
		}
	
	}

