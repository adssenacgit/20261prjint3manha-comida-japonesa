package br.com.senac.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
public class Cliente implements StatusAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer id;

    @NotBlank
    @Column(name = "cliente_nome", nullable = false, length = 150)
    private String nome;

    @Email
    @NotBlank
    @Column(name = "cliente_email", nullable = false, unique = true, length = 150)
    private String email;

    @NotBlank
    @Column(name = "cliente_senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "cliente_telefone", length = 20)
    private String telefone;

    @Column(name = "cliente_cnpj", length = 20)
    private String cnpj;

    @Column(name = "cliente_cpf", length = 20)
    private String cpf;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_tipo_id")
    private TipoCliente tipoCliente;

    @Column(name = "cliente_status")
    private Integer status = 1;

    @Column(name = "cliente_criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEm;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }
    @Override
    public Integer getStatus() { return status; }
    @Override
    public void setStatus(Integer status) { this.status = status; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
