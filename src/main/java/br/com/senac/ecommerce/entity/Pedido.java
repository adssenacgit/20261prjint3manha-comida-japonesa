package br.com.senac.ecommerce.entity;

import br.com.senac.ecommerce.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_cliente_id")
    private Cliente cliente;

    @Column(name = "pedido_total", precision = 10, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "pedido_status", columnDefinition = "enum('pendente','pago','enviado','entregue','cancelado')")
    private PedidoStatus status = PedidoStatus.pendente;

    @Column(name = "pedido_data", insertable = false, updatable = false)
    private LocalDateTime data;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public PedidoStatus getStatus() { return status; }
    public void setStatus(PedidoStatus status) { this.status = status; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
