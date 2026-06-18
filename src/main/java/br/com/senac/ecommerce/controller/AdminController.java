package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.entity.Admin;
import br.com.senac.ecommerce.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
@Tag(name = "Administradores")
@CrossOrigin("*")
public class AdminController extends BaseCrudController<Admin> {

    public AdminController(AdminService service) {
        super(service);
    }
}
