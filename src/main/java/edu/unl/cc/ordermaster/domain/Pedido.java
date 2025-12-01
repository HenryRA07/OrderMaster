package edu.unl.cc.ordermaster.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int mesa;
    private String observacion;
    private float precioTotal;
    private EstadoPedido estado = EstadoPedido.PENDIENTE;
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

    public String visualizarPedido(){
        StringBuilder pedido = new StringBuilder();
        pedido.append("---------------------------------\n");
        pedido.append("Pedido :\n");


        if (cliente != null) {
            pedido.append("Cliente: " + cliente.getNombreCompleto() + "\n");
            pedido.append("Dni: " + cliente.getDni() + "\n");
            pedido.append("Telefono: " + cliente.getTelefono() + "\n");
            pedido.append("Email: " + cliente.getEmail() + "\n");
        } else {
            pedido.append("Cliente: No especificado\n");
        }

        pedido.append("Mesa: " + mesa + "\n");
        pedido.append("Observacion: " + (observacion != null && !observacion.isEmpty() ? observacion : "Ninguna") + "\n");
        pedido.append("\n--- Detalles de Items ---\n");


        if (itemPedido != null && !itemPedido.isEmpty()) {
            pedido.append("| # | Item | Cantidad | Precio U. | Subtotal |\n");
            pedido.append("|---|------|----------|-----------|----------|\n");


            int contador = 1;
            for (ItemPedido item : itemPedido) {

                pedido.append(String.format("| %-1d | %-4s | %-4d | $%.2f | $%.2f |\n",
                        contador++,
                        item.getItem().getProducto().getNombre(),
                        item.getCantidad(),
                        item.getItem().getPrecio(),
                        item.getSubtotal()));
            }
        } else {
            pedido.append("No hay items agregados al pedido.\n");
        }
        pedido.append("----------------------------\n");

        pedido.append("Total de productos: " + (itemPedido != null ? itemPedido.size() : 0) + " items distintos\n");
        pedido.append("Precio Total: $" + String.format("%.2f", precioTotal) + "\n");
        pedido.append("Estado: " + (estado != null ? estado.toString() : "PENDIENTE") + "\n");
        pedido.append("---------------------------------\n");

        return pedido.toString();
    }

    public void agregarItem(ItemPedido item){
        if(itemPedido==null){
            itemPedido = new ArrayList<>();
        }
        if(!itemPedido.contains(item)){
            itemPedido.add(item);
        }
        calcularTotal();
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
        calcularTotal();
    }

    private void calcularTotal(){
        float total = 0;
        for(ItemPedido item:itemPedido) {
            total += item.getSubtotal();
        }
        precioTotal = total;
    }

    public boolean cambiarEstado(EstadoPedido nuevoEstado) {

        if (this.estado == EstadoPedido.PENDIENTE) {

            if (nuevoEstado == EstadoPedido.LISTO) {
                this.estado = nuevoEstado;
                return true;
            } else {
                throw new IllegalArgumentException("El estado ya es pendiente");
            }
        }

        else if (this.estado == EstadoPedido.LISTO) {

            if (nuevoEstado == EstadoPedido.PENDIENTE) {
                throw  new IllegalArgumentException("El estado ya esta listo, no puede ser cambiado");
            }
            return true;
        }

        else {
            return false;
        }
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
