package br.com.senac.ecommerce.service;

import br.com.senac.ecommerce.entity.StatusAware;
import br.com.senac.ecommerce.exception.ResourceNotFoundException;
import br.com.senac.ecommerce.repository.BaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseCrudService<T> {

    protected static final Integer STATUS_EXCLUIDO = -1;
    protected static final Integer STATUS_INATIVO = 0;
    protected static final Integer STATUS_ATIVO = 1;

    private final BaseRepository<T, Integer> repository;
    private final Class<T> entityClass;
    private final String entityName;
    private final String idProperty;

    protected BaseCrudService(BaseRepository<T, Integer> repository, Class<T> entityClass, String entityName) {
        this.repository = repository;
        this.entityClass = entityClass;
        this.entityName = entityName;
        this.idProperty = "id";
    }

    @Transactional(readOnly = true)
    public List<T> listar() {
        if (StatusAware.class.isAssignableFrom(entityClass)) {
            Specification<T> naoExcluido = (root, query, cb) -> cb.notEqual(root.get("status"), STATUS_EXCLUIDO);
            return repository.findAll(naoExcluido);
        }
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public T buscarPorId(Integer id) {
        T entidade = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(entityName + " não encontrado(a) com id " + id));

        if (entidade instanceof StatusAware statusAware && STATUS_EXCLUIDO.equals(statusAware.getStatus())) {
            throw new ResourceNotFoundException(entityName + " não encontrado(a) com id " + id);
        }

        return entidade;
    }

    @Transactional
    public T criar(T entidade) {
        if (entidade instanceof StatusAware statusAware && statusAware.getStatus() == null) {
            statusAware.setStatus(STATUS_ATIVO);
        }
        return repository.save(entidade);
    }

    @Transactional
    public T atualizar(Integer id, T dadosAtualizados) {
        T entidadeAtual = buscarPorId(id);
        BeanUtils.copyProperties(dadosAtualizados, entidadeAtual, idProperty);
        return repository.save(entidadeAtual);
    }

    @Transactional
    public void excluir(Integer id) {
        T entidade = buscarPorId(id);

        if (entidade instanceof StatusAware statusAware) {
            statusAware.setStatus(STATUS_EXCLUIDO);
            repository.save(entidade);
            return;
        }

        repository.delete(entidade);
    }

    @Transactional
    public T ativar(Integer id) {
        return alterarStatus(id, STATUS_ATIVO);
    }

    @Transactional
    public T inativar(Integer id) {
        return alterarStatus(id, STATUS_INATIVO);
    }

    private T alterarStatus(Integer id, Integer novoStatus) {
        T entidade = buscarPorId(id);

        if (!(entidade instanceof StatusAware statusAware)) {
            throw new IllegalStateException(entityName + " não possui campo de status numérico para ativar/inativar.");
        }

        statusAware.setStatus(novoStatus);
        return repository.save(entidade);
    }
}
