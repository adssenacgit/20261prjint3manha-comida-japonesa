package br.com.senac.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_id")
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estoque_produto_id")
    private Produto produto;

    @Column(name = "estoque_quantidade")
    private Integer quantidade = 0;

    @Column(name = "estoque_minimo")
    private Integer minimo = 5;

    @Column(name = "estoque_atualizado_em", insertable = false, updatable = false)
    private LocalDateTime atualizadoEm;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Integer getMinimo() { return minimo; }
    public void setMinimo(Integer minimo) { this.minimo = minimo; }
    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}
