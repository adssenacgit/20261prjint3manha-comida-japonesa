package br.com.senac.ecommerce.controller;

import br.com.senac.ecommerce.service.BaseCrudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseCrudController<T> {

    private final BaseCrudService<T> service;

    protected BaseCrudController(BaseCrudService<T> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<T> criar(@Valid @RequestBody T entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(entidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> atualizar(@PathVariable Integer id, @Valid @RequestBody T entidade) {
        return ResponseEntity.ok(service.atualizar(id, entidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/ativar")
    public ResponseEntity<T> ativar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.ativar(id));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<T> inativar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.inativar(id));
    }
}
