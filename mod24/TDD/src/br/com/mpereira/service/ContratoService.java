package br.com.mpereira.service;

import br.com.mpereira.dao.IContratoDao;

public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso!";
    }

    @Override
    public String buscar() {
        return "Busca!";
    }

    @Override
    public String excluir() {
        return "Excluir!";
    }

    @Override
    public String atualizar() {
        return "Atualizar!";
    }
}
