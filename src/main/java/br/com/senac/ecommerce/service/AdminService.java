package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.Admin;
import br.com.senac.ecommerce.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseCrudService<Admin> {

    public AdminService(AdminRepository repository) {
        super(repository, Admin.class, "Admin");
    }
}
