package br.com.senac.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
public class Produto implements StatusAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Integer id;

    @NotBlank
    @Column(name = "produto_nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "produto_descricao", columnDefinition = "TEXT")
    private String descricao;

    @NotNull
    @Column(name = "produto_preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "produto_imagem", length = 255)
    private String imagem;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_categoria_id")
    private Categoria categoria;

    @Column(name = "produto_status")
    private Integer status = 1;

    @Column(name = "produto_criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEm;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    @Override
    public Integer getStatus() { return status; }
    @Override
    public void setStatus(Integer status) { this.status = status; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
