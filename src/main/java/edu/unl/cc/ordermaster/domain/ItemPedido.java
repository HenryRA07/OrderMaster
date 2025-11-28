package edu.unl.cc.ordermaster.domain;

public class ItemPedido {
    private int cantidad;
    private float subtotal;
    //relaciones
    private ItemMenu item;

    public ItemPedido() {
    }

    public ItemPedido(int cantidad, ItemMenu item) {
        if(cantidad <= 0){
            throw new IllegalArgumentException("La cantidad por lo menos debe ser uno");
        }
        if(item == null){
            throw new IllegalArgumentException("Item no pueder estar vacio");
        }
        this.item = item;
        this.cantidad = cantidad;
    }

    public float calcularSubtotal(){
        return this.cantidad * this.getItem().getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad <= 0){
            throw new IllegalArgumentException("La cantidad por lo menos debe ser uno");
        }
        this.cantidad = cantidad;
    }

    public ItemMenu getItem() {
        return item;
    }

    public void setItem(ItemMenu item) {
        if (item == null) {
            throw new IllegalArgumentException("Item no puede estar vacio");
        }
        this.item = item;
    }

    public float getSubtotal() {
        return calcularSubtotal();
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "cantidad=" + cantidad +
                ", item=" + item +
                '}';
    }
}
