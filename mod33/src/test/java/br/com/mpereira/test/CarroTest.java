package br.com.mpereira.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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

public class CarroTest {
	
private IAcessoriosDao acessoriosDao;
	
	
	private IMarcaDao marcaDao;
	
	private ICarroDao carroDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
		acessoriosDao = new AcessoriosDao();
		marcaDao = new MarcaDao();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = criarMarca("A1");
		
		Carro carro = new Carro();
		carro.setCodigo("A1");
		carro.setModelo("Astra");
		carro.setDescricao("Carro aesthetic");
		carro.setMarca(marca);
		
		carro = carroDao.cadastrar(carro);
		
		Acessorios acessorio = criarAcessorio("A1", carro);
		
		List<Acessorios> acessorios = new ArrayList<>();
		acessorios.add(acessorio);
		carro.setAcessorio(acessorios);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
	

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("Chevrolet");
		return marcaDao.cadastrar(marca);
	}

	private Acessorios criarAcessorio (String codigo, Carro carro) {
		Acessorios acessorio = new Acessorios();
		acessorio.setCodigo(codigo);
		acessorio.setNome("Vidro elétrico");
		acessorio.setDescricao("Vidros que abrem e fecham ao toque da chave");
		acessorio.setCarro(carro);
		
		return acessoriosDao.cadastrar(acessorio);
	}
}
