package br.com.senac.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tipo_cliente")
public class TipoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_cliente_id")
    private Integer id;

    @NotBlank
    @Column(name = "tipo_cliente_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "tipo_cliente_descricao", columnDefinition = "TEXT")
    private String descricao;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
