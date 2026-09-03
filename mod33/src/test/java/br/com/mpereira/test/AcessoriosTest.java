package br.com.mpereira.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.mpereira.dao.AcessoriosDao;
import br.com.mpereira.dao.CarroDao;
import br.com.mpereira.dao.IAcessoriosDao;
import br.com.mpereira.dao.ICarroDao;
import br.com.mpereira.dao.IMarcaDao;
import br.com.mpereira.dao.MarcaDao;
import br.com.mpereira.domain.Acessorios;
import br.com.mpereira.domain.Carro;
import br.com.mpereira.domain.Marca;

public class AcessoriosTest {

	private IAcessoriosDao acessorioDao;
	
	private ICarroDao carroDao;
	
	private IMarcaDao marcaDao;
	
	public AcessoriosTest() {
		acessorioDao = new AcessoriosDao();
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
	}
	
	@Test
	public void cadastrar() {
		Carro carro = criarCarro("A1");
		Marca marca = criarMarca("A1");
		
		Acessorios acessorio = new Acessorios();
		acessorio.setCodigo("A1");
		acessorio.setNome("leitor dvd");
		acessorio.setDescricao("Equipamento toca dvd");
		acessorio.setCarro(carro);
		
		acessorio = acessorioDao.cadastrar(acessorio);
		
		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("Chevrolet");
		return marcaDao.cadastrar(marca);
	}

	private Carro criarCarro(String codigo) {
		Carro carro = new Carro();
		carro.setCodigo(codigo);
		carro.setModelo("Astra");
		carro.setDescricao("O maior carro de todos os tempos");
		
		return carroDao.cadastrar(carro);
	}
}
