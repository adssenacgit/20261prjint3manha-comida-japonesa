package br.com.senac.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco_cliente")
public class EnderecoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_cliente_id")
    private Cliente cliente;

    @Column(name = "endereco_rua", length = 150)
    private String rua;

    @Column(name = "endereco_numero", length = 20)
    private String numero;

    @Column(name = "endereco_bairro", length = 100)
    private String bairro;

    @Column(name = "endereco_cidade", length = 100)
    private String cidade;

    @Column(name = "endereco_estado", length = 50)
    private String estado;

    @Column(name = "endereco_cep", length = 20)
    private String cep;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}
