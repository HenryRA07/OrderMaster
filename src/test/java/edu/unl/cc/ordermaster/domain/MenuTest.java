package edu.unl.cc.ordermaster.domain;

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
        Alimento alimento = new Platillo("sancocho", "sopa de chanco espesa");
        ItemMenu itemMenu = new ItemMenu(15,true,alimento);
        menu.agregar(itemMenu);
        ItemPedido linea1 = new ItemPedido(3,itemMenu);
        System.out.println(linea1.getSubtotal());
        System.out.println(menu.getTipoMenu());
        assertEquals(1,menu.getItemMenu().size());
    }

    @org.junit.jupiter.api.Test
    void eliminar() {
        Menu menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
        Alimento alimento = new Platillo("sancocho", "sopa de chanco espesa");
        Alimento alimento2 = new Platillo("tigrillo", "queso huevo frito");
        ItemMenu itemMenu = new ItemMenu(15,true,alimento);
        ItemMenu itemMenu2 = new ItemMenu(16,true,alimento2);
        menu.agregar(itemMenu);
        menu.agregar(itemMenu2);
        menu.eliminar(itemMenu);
        assertEquals(1,menu.getItemMenu().size());
    }
}