package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.Estoque;
import br.com.senac.ecommerce.service.EstoqueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estoques")
@Tag(name = "Estoques")
@CrossOrigin("*")
public class EstoqueController extends BaseCrudController<Estoque> {

    public EstoqueController(EstoqueService service) {
        super(service);
    }
}
