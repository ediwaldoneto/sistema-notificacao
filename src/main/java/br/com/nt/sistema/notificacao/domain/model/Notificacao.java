package br.com.nt.sistema.notificacao.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Notificacao {

    private String id;
    private TipoNotificacao tipo;
    private String destino;
    private String mensagem;
    private LocalDateTime criadoEm;

    public Notificacao() {
        this.id = UUID.randomUUID().toString();
        this.criadoEm = LocalDateTime.now();
    }

    public Notificacao(TipoNotificacao tipo, String destino, String mensagem) {
        this();
        this.tipo = tipo;
        this.destino = destino;
        this.mensagem = mensagem;
    }

    public boolean isValida() {
        return destino != null && !destino.isBlank()
                && mensagem != null && !mensagem.isBlank()
                && tipo != null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoNotificacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacao tipo) {
        this.tipo = tipo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
