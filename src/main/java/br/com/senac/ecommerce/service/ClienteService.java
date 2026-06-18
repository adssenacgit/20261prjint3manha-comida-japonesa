package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.Cliente;
import br.com.senac.ecommerce.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseCrudService<Cliente> {

    public ClienteService(ClienteRepository repository) {
        super(repository, Cliente.class, "Cliente");
    }
}
