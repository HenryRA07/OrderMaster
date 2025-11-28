package edu.unl.cc.ordermaster.domain;

public class Efectivo extends MetodoPago{
    private float cambioEntregado;

    public Efectivo(float cantidad, float cambioEntregado) {
        super(cantidad);
        if (cantidad <= 0) {
            throw new IllegalArgumentException("El cantidad debe ser mayor a 0");
        }
        this.cambioEntregado = cambioEntregado;
    }

    public float getCambioEntregado() {
        return cambioEntregado;
    }

    public void setCambioEntregado(float cambioEntregado) {
        this.cambioEntregado = cambioEntregado;
    }

    @Override
    public String toString() {
        return "Efectivo [" + super.toString() +
                " cambioEntregado = " + cambioEntregado +
                ']';
    }
}
