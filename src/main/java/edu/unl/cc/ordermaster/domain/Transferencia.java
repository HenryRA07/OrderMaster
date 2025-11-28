package edu.unl.cc.ordermaster.domain;

public class Transferencia extends MetodoPago{
    private String banco;
    private String numeroComprobante;

    public Transferencia(float cantidad, String banco, String numeroComprobante) {
        super(cantidad);
        this.banco = banco;
        this.numeroComprobante = numeroComprobante;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

}
