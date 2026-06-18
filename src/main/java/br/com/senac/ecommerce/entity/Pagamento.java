package br.com.senac.ecommerce.entity;

import br.com.senac.ecommerce.enums.PagamentoMetodo;
import br.com.senac.ecommerce.enums.PagamentoStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamento_id")
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pagamento_pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "pagamento_metodo", columnDefinition = "enum('pix','cartao','boleto')")
    private PagamentoMetodo metodo;

    @Enumerated(EnumType.STRING)
    @Column(name = "pagamento_status", columnDefinition = "enum('pendente','aprovado','recusado')")
    private PagamentoStatus status = PagamentoStatus.pendente;

    @Column(name = "pagamento_valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "pagamento_data", insertable = false, updatable = false)
    private LocalDateTime data;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public PagamentoMetodo getMetodo() { return metodo; }
    public void setMetodo(PagamentoMetodo metodo) { this.metodo = metodo; }
    public PagamentoStatus getStatus() { return status; }
    public void setStatus(PagamentoStatus status) { this.status = status; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
