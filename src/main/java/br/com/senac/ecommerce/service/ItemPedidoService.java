package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.ItemPedido;
import br.com.senac.ecommerce.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService extends BaseCrudService<ItemPedido> {

    public ItemPedidoService(ItemPedidoRepository repository) {
        super(repository, ItemPedido.class, "Item do pedido");
    }
}
