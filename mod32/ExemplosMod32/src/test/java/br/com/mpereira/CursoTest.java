package br.com.mpereira;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.mpereira.dao.CursoDao;
import br.com.mpereira.dao.ICursoDao;
import br.com.mpereira.domain.Curso;

public class CursoTest {
	
	private ICursoDao cursoDao;

	public CursoTest() {
		cursoDao = new CursoDao();
	
	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setNome("Curso de Java Backend");
		curso.setDescricicao("CURSO TESTE");
		
		curso = cursoDao.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
	}
}
