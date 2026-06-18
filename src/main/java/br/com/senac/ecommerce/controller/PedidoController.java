package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.Pedido;
import br.com.senac.ecommerce.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos")
@CrossOrigin("*")
public class PedidoController extends BaseCrudController<Pedido> {

    public PedidoController(PedidoService service) {
        super(service);
    }
}
