package br.com.nt.sistema.notificacao.domain.model;

public enum TipoNotificacao {

    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    private final String valor;

    TipoNotificacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
