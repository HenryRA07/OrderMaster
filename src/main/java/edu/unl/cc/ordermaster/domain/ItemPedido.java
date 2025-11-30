package edu.unl.cc.ordermaster.domain;

public class ItemPedido {
    private int cantidad;
    private float subtotal;
    //relaciones
    private ItemMenu item;

    public ItemPedido() {
    }

    public ItemPedido(int cantidad, ItemMenu item) {
        setItem(item);
        setCantidad(cantidad);
    }

    private void calcularSubtotal(){
        this.subtotal = this.cantidad * this.getItem().getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad <= 0){
            throw new IllegalArgumentException("La cantidad por lo menos debe ser uno");
        }
        this.cantidad = cantidad;
        calcularSubtotal();
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
        return subtotal;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "cantidad=" + cantidad +
                ", item=" + item +
                '}';
    }
}
