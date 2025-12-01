package edu.unl.cc.ordermaster.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void agregar() {
        Menu menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
        Producto producto = new Platillo("sancocho", "sopa de chanco espesa");
        ItemMenu itemMenu = new ItemMenu(15, true, producto);
        menu.agregar(itemMenu);
        ItemPedido linea1 = new ItemPedido(3, itemMenu);
        System.out.println(linea1.getSubtotal());
        System.out.println(menu.getTipoMenu());
        assertEquals(1, menu.getItemMenu().size());
    }

    @org.junit.jupiter.api.Test
    void eliminar() {
        Menu menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
        Producto producto = new Platillo("sancocho", "sopa de chanco espesa");
        Producto producto2 = new Platillo("tigrillo", "queso huevo frito");
        ItemMenu itemMenu = new ItemMenu(15, true, producto);
        ItemMenu itemMenu2 = new ItemMenu(16, true, producto2);
        menu.agregar(itemMenu);
        menu.agregar(itemMenu2);
        menu.eliminar(itemMenu);
        assertEquals(1, menu.getItemMenu().size());
    }
    private Pedido pedidoTest;
    @Test
    void visualizarMenu() {
        Menu menuDía = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
        Producto producto = new Platillo("sancocho", "sopa de chanco espesa");
        Producto producto2 = new Platillo("tigrillo", "queso huevo frito");
        Producto producto3 = new Platillo("Repe", "Con guinero y lecche");
        ItemMenu itemMenu = new ItemMenu(15, true, producto);
        ItemMenu itemMenu2 = new ItemMenu(16, true, producto2);
        ItemMenu itemMenu3 = new ItemMenu(17, false, producto3);
        menuDía.agregar(itemMenu);
        menuDía.agregar(itemMenu2);
        menuDía.agregar(itemMenu3);
        System.out.println(menuDía.visualizarMenu());
    }
}