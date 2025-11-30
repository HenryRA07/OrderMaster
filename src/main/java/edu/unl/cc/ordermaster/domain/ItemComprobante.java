package edu.unl.cc.ordermaster.domain;

public class ItemComprobante {
    //relaciones
    private ItemPedido item;

    public ItemComprobante() {
    };

    public ItemComprobante(ItemPedido item) {
        this.item = item;
    }



    public ItemPedido getItem() {
        return item;
    }
    public void setItem(ItemPedido item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemComprobante{" +
                "item=" + item +
                '}';
    }
}