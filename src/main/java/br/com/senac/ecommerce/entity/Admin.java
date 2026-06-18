package br.com.senac.ecommerce.entity;

import br.com.senac.ecommerce.enums.AdminNivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
public class Admin implements StatusAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer id;

    @NotBlank
    @Column(name = "admin_nome", nullable = false, length = 120)
    private String nome;

    @Email
    @NotBlank
    @Column(name = "admin_email", nullable = false, unique = true, length = 150)
    private String email;

    @NotBlank
    @Column(name = "admin_senha", nullable = false, length = 255)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "admin_nivel", columnDefinition = "enum('super_admin','estoque','financeiro')")
    private AdminNivel nivel = AdminNivel.estoque;

    @Column(name = "admin_status")
    private Integer status = 1;

    @Column(name = "admin_criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEm;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public AdminNivel getNivel() { return nivel; }
    public void setNivel(AdminNivel nivel) { this.nivel = nivel; }
    @Override
    public Integer getStatus() { return status; }
    @Override
    public void setStatus(Integer status) { this.status = status; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
