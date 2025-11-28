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
        Cliente persona1 = new Cliente("Henry", "Romero","11055432", "098776777","email@gmail.com");
        Pedido pedido = new Pedido( 3,"Sancocho sin limon",persona1 );
        pedido.agregarItems(linea1, linea2);
        MetodoPago jaja = new Efectivo(100, 22);
        MetodoPago jeje = new Transferencia(100, "PEpes", "03403249230");
        ComprobanteVenta venta1 = new ComprobanteVenta("ShamanBlack","223333",pedido,jeje );
        ComprobanteVenta venta2 = new ComprobanteVenta("ShamanBlack","223333",pedido,jaja );
        System.out.println(venta1.generaComprobante());
        System.out.println(venta2.generaComprobante());

    }
}
