package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.Produto;
import br.com.senac.ecommerce.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends BaseCrudService<Produto> {

    public ProdutoService(ProdutoRepository repository) {
        super(repository, Produto.class, "Produto");
    }
}
