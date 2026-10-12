/**
 * 
 */
package br.com.mpereira.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mpereira.domain.Cliente;


/**
 *
 */
@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long>{

}
