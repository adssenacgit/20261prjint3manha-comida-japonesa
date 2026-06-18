package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.Categoria;
import br.com.senac.ecommerce.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseCrudService<Categoria> {

    public CategoriaService(CategoriaRepository repository) {
        super(repository, Categoria.class, "Categoria");
    }
}
