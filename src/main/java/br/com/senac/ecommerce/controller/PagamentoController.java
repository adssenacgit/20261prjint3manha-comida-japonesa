package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.Pagamento;
import br.com.senac.ecommerce.service.PagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
@Tag(name = "Pagamentos")
@CrossOrigin("*")
public class PagamentoController extends BaseCrudController<Pagamento> {

    public PagamentoController(PagamentoService service) {
        super(service);
    }
}
