package edu.unl.cc.ordermaster.domain;

public class Transferencia extends MetodoPago{
    private String banco;
    private String numeroComprobante;

    public Transferencia(float cantidad, String banco, String numeroComprobante){
        super(cantidad);
        if (banco == null || banco.trim().isEmpty()){
            throw new IllegalArgumentException("El banco no puede estar vacío");
        }
        this.banco = banco;
        if (numeroComprobante == null || numeroComprobante.trim().isEmpty()){
            throw new IllegalArgumentException("El número de comprobante no puede estar vacio");
        }
        this.numeroComprobante = numeroComprobante;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        if(banco == null || banco.trim().isEmpty()){
            throw new IllegalArgumentException("El banco no puede estar vacio");
        }
        this.banco = banco;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        if(numeroComprobante == null || numeroComprobante.trim().isEmpty()){
            throw new IllegalArgumentException("El número de comprobante no puede estar vacio");
        }
        this.numeroComprobante = numeroComprobante;
    }

    @Override
    public String toString() {
        return "Transferencia [" + super.toString() +
                "banco='" + banco + '\'' +
                ", numeroComprobante='" + numeroComprobante + '\'' +
                ']';
    }

}
