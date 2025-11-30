package edu.unl.cc.ordermaster.domain;

public abstract class MetodoPago {
    private float cantidad;

    public MetodoPago(float cantidad) {
        setCantidad(cantidad);
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        if (cantidad <= 0){
            throw new IllegalArgumentException("El cantidad debe ser mayor a 0");
        }
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "cantidad = " + cantidad + ", ";
    }

}
