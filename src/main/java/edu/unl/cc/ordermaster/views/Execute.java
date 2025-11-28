package edu.unl.cc.ordermaster.views;

import edu.unl.cc.ordermaster.domain.*;

public class Execute {
    public static void main(String[] args) {
        Menu menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
        Producto producto1 = new Platillo("sancocho", "sopa de chanco espesa");
        Producto producto2 = new Bebida("Limonada", "Jara de limonada");
        ItemMenu itemMenu = new ItemMenu(15,true, producto1);
        ItemMenu itemMenu2 = new ItemMenu(16,true, producto2);
        menu.agregar(itemMenu);
        menu.agregar(itemMenu2);
        ItemPedido linea1 = new ItemPedido(2,itemMenu);
        ItemPedido linea2 = new ItemPedido(3,itemMenu2);
        Cliente persona1 = new Cliente("paco", "robert","11055432", "098776777","emai@gmauil.com");
        Pedido pedido = new Pedido("paco", 3,"Sancocho sin limon",persona1 );
        pedido.agregarItem(linea1);
        pedido.agregarItem(linea2);
        ComprobanteVenta venta1 = new ComprobanteVenta("ChamanBlack","223333",pedido);
        System.out.println(venta1.generalComprobante());

    }
}
