package edu.unl.cc.ordermaster.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ComprobanteVenta {
    private String nombreRestaurante;
    private String direccionRestaurante;
    private LocalDate fechaComprobante;
    //Relaciones
    private Pedido pedido;
    private List<ItemComprobante> itemComprobante;
    private MetodoPago metodoPago;

    public ComprobanteVenta() {
        this.fechaComprobante = LocalDate.now();
    }

    public ComprobanteVenta(String nombreRestaurante, String direccionRestaurante, Pedido pedido, MetodoPago metodoPago) {
        this();
        this.nombreRestaurante = nombreRestaurante;
        this.direccionRestaurante = direccionRestaurante;
        this.pedido = pedido;
        this.metodoPago = metodoPago;
    }

    public void agregarItem(ItemComprobante item){
        if(itemComprobante==null){
            itemComprobante = new ArrayList<>();
        }
        if(!itemComprobante.contains(item)){
            itemComprobante.add(item);
        }
    }

    public void agregarItems(ItemComprobante... itemComprobantes){
        for(ItemComprobante items: itemComprobantes){
            agregarItem(items);
        }
    }

    public void eliminarItem(ItemComprobante item){
        if(item == null){
            throw new IllegalArgumentException("El item no puede ser nulo");
        }
        if(!itemComprobante.contains(item)) {
            throw new IllegalArgumentException("El item no puede ser eliminado");
        }
        itemComprobante.remove(item);
    }

    public String generarComprobante() throws IllegalArgumentException {
        if (pedido == null || pedido.getItemPedido() == null) {
            throw new IllegalArgumentException("No hay pedido para generar comprobante");
        }
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------\n");
        s.append("Restaurante: " + this.nombreRestaurante+"\n");
        s.append("Direccion: " + this.direccionRestaurante+"\n");
        s.append("Nombre Cliente: " + this.pedido.getCliente().getNombreCompleto()+"\n");
        s.append("Fecha de Comprobante: " + this.fechaComprobante+"\n");
        s.append("Productos consumidos: \n");
        if (itemComprobante != null && !itemComprobante.isEmpty()) {
            s.append("| # | Item | Cantidad | Precio U. | Subtotal |\n");
            s.append("|---|------|----------|-----------|----------|\n");


            int contador = 1;
            for (ItemComprobante item : itemComprobante) {

                s.append(String.format("| %-1d | %-4s | %-4d | $%.2f | $%.2f |\n",
                        contador++,
                        item.getItem().getItem().getProducto().getNombre(),
                        item.getItem().getCantidad(),
                        item.getItem().getItem().getPrecio(),
                        item.getItem().getSubtotal()));
            }
        } else {
            s.append("No hay items agregados al pedido.\n");
        }
        s.append("----------------------------\n");
        s.append("---------------------------------------------------\n");
        s.append("Metodo de pago: " + metodoPago.getClass().getSimpleName() +"\n");
        s.append("Total pagar: $"+ pedido.getPrecioTotal() + "\n");
        s.append("" + metodoPago );
        return s.toString();
    }


    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getDireccionRestaurante() {
        return direccionRestaurante;
    }

    public void setDireccionRestaurante(String direccionRestaurante) {
        this.direccionRestaurante = direccionRestaurante;
    }

    public LocalDate getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(LocalDate fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
