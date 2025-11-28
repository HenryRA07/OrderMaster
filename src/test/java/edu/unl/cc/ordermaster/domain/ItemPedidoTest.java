package edu.unl.cc.ordermaster.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

    private Menu menu;
    private Producto producto;
    private ItemMenu itemMenu;
    private ItemPedido linea1;
    @BeforeEach
    void setUp() {

        menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
        producto = new Platillo("sancocho", "sopa de chanco espesa");
        itemMenu = new ItemMenu(15,true, producto);
        menu.agregar(itemMenu);
        linea1 = new ItemPedido(-5,itemMenu);

    }

    @Test
    void calcularSubtotal() {

    }
}