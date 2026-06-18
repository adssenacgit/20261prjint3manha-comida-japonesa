package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.Estoque;
import br.com.senac.ecommerce.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService extends BaseCrudService<Estoque> {

    public EstoqueService(EstoqueRepository repository) {
        super(repository, Estoque.class, "Estoque");
    }
}
