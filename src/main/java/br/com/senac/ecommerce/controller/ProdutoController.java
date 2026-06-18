package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.Produto;
import br.com.senac.ecommerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produtos")
@CrossOrigin("*")
public class ProdutoController extends BaseCrudController<Produto> {

    public ProdutoController(ProdutoService service) {
        super(service);
    }
}
