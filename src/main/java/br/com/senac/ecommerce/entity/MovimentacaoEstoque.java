package br.com.senac.ecommerce.entity;

import br.com.senac.ecommerce.enums.MovimentacaoTipo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacao_estoque")
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimentacao_id")
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movimentacao_produto_id")
    private Produto produto;

    @Enumerated(EnumType.STRING)
    @Column(name = "movimentacao_tipo", columnDefinition = "enum('entrada','saida')")
    private MovimentacaoTipo tipo;

    @Column(name = "movimentacao_quantidade")
    private Integer quantidade;

    @Column(name = "movimentacao_motivo", length = 255)
    private String motivo;

    @Column(name = "movimentacao_data", insertable = false, updatable = false)
    private LocalDateTime data;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public MovimentacaoTipo getTipo() { return tipo; }
    public void setTipo(MovimentacaoTipo tipo) { this.tipo = tipo; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
