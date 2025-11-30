package edu.unl.cc.ordermaster.domain;

public class Efectivo extends MetodoPago{
    private float cambioEntregado;
    private Pedido pedido;


    public Efectivo(float cantidad, Pedido pedido) {
        super(cantidad);
        this.pedido = pedido;
        setCambioEntregado(cambio());
    }

    public float getCambioEntregado() {
        return cambioEntregado;
    }

    public float cambio(){
        cambioEntregado = super.getCantidad() -  this.getPedido().getPrecioTotal();
        return cambioEntregado;
    }
    public void setCambioEntregado(float cambioEntregado) {

        this.cambioEntregado = cambioEntregado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return  "Efectivo dado: $" + super.getCantidad() +  "\n" + "Cambio a entregar: $" + this.cambio();
    }
}
