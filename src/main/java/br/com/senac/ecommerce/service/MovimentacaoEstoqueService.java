package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.MovimentacaoEstoque;
import br.com.senac.ecommerce.repository.MovimentacaoEstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoEstoqueService extends BaseCrudService<MovimentacaoEstoque> {

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository repository) {
        super(repository, MovimentacaoEstoque.class, "Movimentação de estoque");
    }
}
