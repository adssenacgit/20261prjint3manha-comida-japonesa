package br.com.senac.ecommerce.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private LocalDateTime timestamp;
    private Integer status;
    private String erro;
    private List<String> mensagens;

    public ApiError(Integer status, String erro, List<String> mensagens) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.erro = erro;
        this.mensagens = mensagens;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getErro() { return erro; }
    public void setErro(String erro) { this.erro = erro; }
    public List<String> getMensagens() { return mensagens; }
    public void setMensagens(List<String> mensagens) { this.mensagens = mensagens; }
}
