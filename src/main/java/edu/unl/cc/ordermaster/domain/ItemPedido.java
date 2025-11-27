package edu.unl.cc.ordermaster.domain;

public class ItemPedido {
    private int cantidad;
    private float subtotal;
    //relaciones
    private ItemMenu item;

    public ItemPedido() {
    }

    public ItemPedido(int cantidad, ItemMenu item) {
        this.cantidad = cantidad;
        this.item = item;
        this.subtotal = calcularSubtotal();
    }

    public float calcularSubtotal(){
        return this.cantidad * this.getItem().getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ItemMenu getItem() {
        return item;
    }

    public void setItem(ItemMenu item) {
        this.item = item;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "cantidad=" + cantidad +
                ", item=" + item +
                '}';
    }
}
