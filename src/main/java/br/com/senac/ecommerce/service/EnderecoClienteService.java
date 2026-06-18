package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.EnderecoCliente;
import br.com.senac.ecommerce.repository.EnderecoClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoClienteService extends BaseCrudService<EnderecoCliente> {

    public EnderecoClienteService(EnderecoClienteRepository repository) {
        super(repository, EnderecoCliente.class, "Endereço do cliente");
    }
}
