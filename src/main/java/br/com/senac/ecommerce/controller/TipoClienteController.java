package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.TipoCliente;
import br.com.senac.ecommerce.service.TipoClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipos-clientes")
@Tag(name = "Tipos de cliente")
@CrossOrigin("*")
public class TipoClienteController extends BaseCrudController<TipoCliente> {

    public TipoClienteController(TipoClienteService service) {
        super(service);
    }
}
