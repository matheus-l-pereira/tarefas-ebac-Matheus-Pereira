package br.com.mpereira.dao;

import br.com.mpereira.domain.Cliente;
import br.com.mpereira.generics.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    public ClienteDAO(){
        super();
    }

}
