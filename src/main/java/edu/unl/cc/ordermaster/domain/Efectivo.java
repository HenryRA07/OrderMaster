package edu.unl.cc.ordermaster.domain;

public class Efectivo extends MetodoPago{
    private float cambioEntregado;
    private ComprobanteVenta comprobanteVenta;


    public Efectivo(float cantidad, ComprobanteVenta comprobanteVenta) {
        super(cantidad);
        this.comprobanteVenta = comprobanteVenta;
        cambio();
    }

    public float getCambioEntregado() {
        return cambioEntregado;
    }

    public void cambio(){
        this.cambioEntregado = super.getCantidad() -  this.comprobanteVenta.getPedido().getPrecioTotal();
    }

    public void setCambioEntregado(float cambioEntregado) {

        this.cambioEntregado = cambioEntregado;
    }


    @Override
    public String toString() {
        return  "Efectivo dado: $" + super.getCantidad() +  "\n" + "Cambio a entregar: $" + this.cambioEntregado;
    }
}
