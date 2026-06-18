package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.Pagamento;
import br.com.senac.ecommerce.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService extends BaseCrudService<Pagamento> {

    public PagamentoService(PagamentoRepository repository) {
        super(repository, Pagamento.class, "Pagamento");
    }
}
