package edu.unl.cc.ordermaster.domain;

public class ItemMenu {
    private float precio;
    private boolean disponibilidad;
    //extensiones
    private Alimento alimento;

    public ItemMenu() {
    }

    public ItemMenu(float precio, boolean disponibilidad, Alimento alimento) {
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.alimento = alimento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "ItemMenu{" +
                "precio=" + precio +
                ", disponibilidad=" + disponibilidad +
                ", alimento=" + alimento +
                '}';
    }
}
