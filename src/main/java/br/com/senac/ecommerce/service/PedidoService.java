package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.Pedido;
import br.com.senac.ecommerce.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends BaseCrudService<Pedido> {

    public PedidoService(PedidoRepository repository) {
        super(repository, Pedido.class, "Pedido");
    }
}
