package edu.unl.cc.ordermaster.domain;

public class ItemMenu {
    private float precio;
    private boolean disponibilidad;
    //extensiones
    private Producto producto;

    public ItemMenu() {
    }

    public ItemMenu(float precio, boolean disponibilidad, Producto producto) {
        setPrecio(precio);
        setProducto(producto);
        this.disponibilidad = disponibilidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ItemMenu{" +
                "precio=" + precio +
                ", disponibilidad=" + disponibilidad +
                ", alimento=" + producto;
    }
}
