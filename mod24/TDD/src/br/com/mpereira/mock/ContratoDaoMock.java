package br.com.mpereira.mock;

import br.com.mpereira.dao.IContratoDao;

public class ContratoDaoMock implements IContratoDao {

    @Override
    public void salvar() {

    }

    public static interface IContratoDao {
        void salvar();
    }
}
