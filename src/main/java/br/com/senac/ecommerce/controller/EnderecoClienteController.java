package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.EnderecoCliente;
import br.com.senac.ecommerce.service.EnderecoClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos-clientes")
@Tag(name = "Endereços de clientes")
@CrossOrigin("*")
public class EnderecoClienteController extends BaseCrudController<EnderecoCliente> {

    public EnderecoClienteController(EnderecoClienteService service) {
        super(service);
    }
}
