package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.TipoCliente;
import br.com.senac.ecommerce.repository.TipoClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoClienteService extends BaseCrudService<TipoCliente> {

    public TipoClienteService(TipoClienteRepository repository) {
        super(repository, TipoCliente.class, "Tipo de cliente");
    }
}
