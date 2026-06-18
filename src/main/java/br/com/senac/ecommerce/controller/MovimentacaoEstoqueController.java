package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.MovimentacaoEstoque;
import br.com.senac.ecommerce.service.MovimentacaoEstoqueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimentacoes-estoque")
@Tag(name = "Movimentações de estoque")
@CrossOrigin("*")
public class MovimentacaoEstoqueController extends BaseCrudController<MovimentacaoEstoque> {

    public MovimentacaoEstoqueController(MovimentacaoEstoqueService service) {
        super(service);
    }
}
