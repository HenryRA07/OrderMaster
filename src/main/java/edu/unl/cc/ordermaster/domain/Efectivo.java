package edu.unl.cc.ordermaster.domain;

public class Efectivo extends MetodoPago {
    private float cambioEntregado;
    private Pedido pedido;

    public Efectivo(float cantidad, Pedido pedido) {
        super(cantidad);
        this.pedido = pedido;
        cambio();
    }

    private float cambio() {
        this.cambioEntregado = super.getCantidad() - this.pedido.getPrecioTotal();
        return cambioEntregado;
    }

    public float getCambioEntregado() {
        return cambioEntregado;
    }

    public void setCambioEntregado(float cambioEntregado) {
        this.cambioEntregado = cambioEntregado;
    }

    @Override
    public String toString() {
        return  "Efectivo dado: $" + super.getCantidad() +  "\n" + "Cambio a entregar: $" + getCambioEntregado();
    }
}
