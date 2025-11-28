package edu.unl.cc.ordermaster.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Menu menu1;
    private Cliente clienteTest, clienteTest2;
    private Producto p1, p2, b1, b2;
    private ItemMenu item1, item2, item3, item4;
    private ItemPedido linea1, linea2, linea3, linea4, linea5;
    private Pedido pedidoTest, pedidoTest2;

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
        linea3 = new ItemPedido(1, item3);
        linea4 = new ItemPedido(2, item4);
        linea5 = new ItemPedido(3, item2);

        pedidoTest = new Pedido(4, "Hola", clienteTest);
        pedidoTest2 = new Pedido(5, "Hola", clienteTest2);

        item3 = new ItemMenu(12.00f, true, b1);
        linea3 = new ItemPedido(1, item3);  // 12.00

        pedidoTest.agregarItems(linea1, linea2, linea3);
    }

    @Test
    void agregarItems() {

        assertEquals(3, pedidoTest.getItemPedido().size());
        assertEquals(76.50f, pedidoTest.getPrecioTotal(), 0.001f);
        pedidoTest2.agregarItem(linea5);
        assertEquals(43.50f, pedidoTest2.getPrecioTotal(), 0.001f);
    }

    @Test
    void eliminarItem() {
        //
    }
}
