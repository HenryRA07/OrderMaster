package edu.unl.cc.ordermaster.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String nombreCliente;
    private int mesa;
    private String observacion;
    private float precioTotal;
    private EstadoPedido estado;
    //relaciones
    private List<ItemPedido> itemPedido;
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(String nombreCliente, int mesa, String observacion, Cliente cliente) {
        this.nombreCliente = nombreCliente;
        this.mesa = mesa;
        this.observacion = observacion;
        this.cliente = cliente;
    }

    public void agregarItem(ItemPedido item){
        if(itemPedido==null){
            itemPedido=new ArrayList<>();
        }
        if(!itemPedido.contains(item)){
            itemPedido.add(item);
        }
    }

    public void eliminarItem(ItemPedido item){
        if(itemPedido.contains(item)){
            itemPedido.remove(item);
        }
    }

    public float calcularTotal(){
        float total = 0;
        for(ItemPedido item:itemPedido){
            total += item.getSubtotal();
        }
        return total;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", mesa=" + mesa +
                ", observacion='" + observacion + '\'' +
                ", precioTotal=" + precioTotal +
                ", estado=" + estado +
                ", itemPedido=" + itemPedido +
                '}';
    }
}
