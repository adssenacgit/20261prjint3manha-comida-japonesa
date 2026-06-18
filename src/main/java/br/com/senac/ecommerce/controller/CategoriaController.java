package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.Categoria;
import br.com.senac.ecommerce.service.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categorias")
@CrossOrigin("*")
public class CategoriaController extends BaseCrudController<Categoria> {

    public CategoriaController(CategoriaService service) {
        super(service);
    }
}
