package edu.unl.cc.ordermaster.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int mesa;
    private String observacion;
    private float precioTotal;
    private EstadoPedido estado;
    //relaciones
    private List<ItemPedido> itemPedido;
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int mesa, String observacion, Cliente cliente) {
        this.mesa = mesa;
        this.observacion = observacion;
        this.cliente = cliente;
    }


    private String getNombreCliente() {
        return this.cliente.getNombreCompleto();
    }

    public void agregarItem(ItemPedido item){
        if(itemPedido==null){
            itemPedido=new ArrayList<>();
        }
        if(!itemPedido.contains(item)){
            itemPedido.add(item);
        }
    }

    public void agregarItems(ItemPedido... itemPedido){
        for(ItemPedido items: itemPedido){
            agregarItem(items);
        }
    }

    public void eliminarItem(ItemPedido item){
        if(item == null){
            throw new IllegalArgumentException("El item no puede ser nulo");
        }
        if(!itemPedido.contains(item)) {
            throw new IllegalArgumentException("El item no puede ser eliminado");
        }
            itemPedido.remove(item);
    }

    private float calcularTotal(){
        float total = 0;
        for(ItemPedido item:itemPedido) {
            total += item.getSubtotal();
        }
        return total;
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
        return calcularTotal();
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nombreCliente='" + cliente.getNombreCompleto() + '\'' +
                ", mesa=" + mesa +
                ", observacion='" + observacion + '\'' +
                ", precioTotal=" + precioTotal +
                ", estado=" + estado +
                ", itemPedido=" + itemPedido +
                '}';
    }
}
