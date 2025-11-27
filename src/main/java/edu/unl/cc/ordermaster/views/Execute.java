package edu.unl.cc.ordermaster.views;

import edu.unl.cc.ordermaster.domain.*;

public class Execute {
    public static void main(String[] args) {
        Menu menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
        Alimento alimento = new Platillo("sancocho", "sopa de chanco espesa");
        ItemMenu itemMenu = new ItemMenu(15,true,alimento);
        menu.agregar(itemMenu);
        System.out.println(menu.getTipoMenu());
        menu.getItemMenu().forEach(item -> System.out.println(item));

    }
}
