package br.com.mpereira.SpringBootPrimeiroProjeto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.mpereira.domain.Cliente;
import br.com.mpereira.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.mpereira.repository")
@EntityScan("br.com.mpereira.*")  
@ComponentScan(basePackages = "br.com.mpereira")
public class SpringBootPrimeiroProjetoApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(SpringBootPrimeiroProjetoApplication.class);

	@Autowired
	private IClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPrimeiroProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("SP")
				.cpf(12312312310L)
				.email("Teste@teste.com")
				.end("End")
				.estado("SP")
				.nome("Teste Spring Boot")
				.numero(102030)
				.tel(10203040L)
				.build();
	}
}
