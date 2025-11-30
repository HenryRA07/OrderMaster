package edu.unl.cc.ordermaster.domain;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class ComprobanteVenta {
    private String nombreRestaurante;
    private String direccionRestaurante;
    private LocalDate fechaComprobante;
    //Relaciones
    private Pedido pedido;
    private MetodoPago metodoPago;
    private PDFgenerator pdf;
    private Gmail gmail;

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
        for(ItemPedido pedidos:pedido.getItemPedido()){
            s.append(String.format("-%s -- %d -- %.2f\n",pedidos.getItem().getProducto().getNombre(),
                    pedidos.getCantidad(),pedidos.getSubtotal()));
        }
        s.append("---------------------------------------------------\n");
        s.append("Metodo de pago: " + metodoPago +"\n");
        s.append("Total pagar: "+pedido.getPrecioTotal());
        return s.toString();
    }

    public void generarPDF() throws DocumentException, FileNotFoundException {
        pdf = new PDFgenerator();
        pdf.generar(generarComprobante());
        enviarCorreo();
    }
    private void enviarCorreo() {
        gmail = new Gmail();
        gmail.enviarEmail(this.pedido.getCliente().getEmail(),this.fechaComprobante,"Evio comprobante de venta", "Se adjunta el archivo pdf en este mensaje");
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
}
