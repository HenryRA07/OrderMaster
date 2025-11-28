package edu.unl.cc.ordermaster.domain;

public abstract class MetodoPago {
    private float cantidad;

    public MetodoPago(float cantidad) {
        this.cantidad = cantidad;
    }



    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "cantidad = " + cantidad + ", ";
    }
}
