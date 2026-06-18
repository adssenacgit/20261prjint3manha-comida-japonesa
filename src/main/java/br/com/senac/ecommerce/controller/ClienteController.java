package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.Cliente;
import br.com.senac.ecommerce.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes")
@CrossOrigin("*")
public class ClienteController extends BaseCrudController<Cliente> {

    public ClienteController(ClienteService service) {
        super(service);
    }
}
