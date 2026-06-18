package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.ItemPedido;
import br.com.senac.ecommerce.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itens-pedidos")
@Tag(name = "Itens de pedido")
@CrossOrigin("*")
public class ItemPedidoController extends BaseCrudController<ItemPedido> {

    public ItemPedidoController(ItemPedidoService service) {
        super(service);
    }
}
