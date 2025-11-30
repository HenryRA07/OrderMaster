package edu.unl.cc.ordermaster.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComprobanteVentaTest {

    private Menu menu1;
    private Cliente clienteTest, clienteTest2;
    private Producto p1, p2, b1, b2;
    private ItemMenu item1, item2, item3, item4;
    private ItemPedido linea1, linea2, linea3, linea4, linea5;
    private Pedido pedidoTest, pedidoTest2;
    private ComprobanteVenta comprobanteVenta;
    private ItemComprobante itemComprobante, itemComprobante1, itemComprobante2, itemComprobante3;

    @BeforeEach
    void setUp() {

        menu1 = new Menu("MenuLunes", TipoMenu.ALMUERZO);
        clienteTest = new Cliente("Juan", "Pérez", "03243202", "098789458", "email.google.com");
        clienteTest2 = new Cliente("Maria", "Lopez", "03243203", "098123456", "maria@test.com");

        p1 = new Platillo("Tacos de Barbacoa", "Descripción");
        p2 = new Platillo("Ensalada de atún", "Descripción");
        b1 = new Bebida("Brisa Andina", "Descripción");
        b2 = new Bebida("Cacao Nocturno", "Descripción");

        item1 = new ItemMenu(10.50f, true, p1);
        item2 = new ItemMenu(14.50f, true, p2);
        item3 = new ItemMenu(10.50f, true, b1);
        item4 = new ItemMenu(4.70f, true, b2);

        linea1 = new ItemPedido(2, item1);
        linea2 = new ItemPedido(3, item2);
        linea3 = new ItemPedido(4, item3);
        linea4 = new ItemPedido(2, item4);
        linea5 = new ItemPedido(3, item2);

        pedidoTest = new Pedido(4, "ninguna",  clienteTest);
        pedidoTest2 = new Pedido(5, "Nada jajaj", clienteTest2);
//        pedidoTest.cambiarEstado(EstadoPedido.PENDIENTE); ---Devolvera una excepcion
        pedidoTest2.cambiarEstado(EstadoPedido.LISTO);
        item3 = new ItemMenu(12.00f, true, b1);
        linea3 = new ItemPedido(1, item3);
        MetodoPago metodoPago1 = new Efectivo(100,pedidoTest);

        itemComprobante1 = new ItemComprobante(linea1);
        itemComprobante2 = new ItemComprobante(linea2);
        itemComprobante3 = new ItemComprobante(linea3);
        itemComprobante = new ItemComprobante(linea4);


        pedidoTest.agregarItems(linea1, linea2, linea3);
        comprobanteVenta = new ComprobanteVenta("sdfsd", "sdfsd", pedidoTest, metodoPago1);
        comprobanteVenta.agregarItems(itemComprobante, itemComprobante1, itemComprobante2, itemComprobante3);
    }

    @Test
    void generarComprobante() {
        System.out.println(comprobanteVenta.generarComprobante());
    }

}