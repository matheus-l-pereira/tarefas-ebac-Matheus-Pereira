package br.com.mpereira.dao;

import br.com.mpereira.mock.ContratoDaoMock;

public class ContratoDao implements IContratoDao {
    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }
}
