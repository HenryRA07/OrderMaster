package edu.unl.cc.ordermaster.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private LocalDate fechaCreacion;
    private String nombreMenu;
    private TipoMenu tipoMenu;
    //Extensiones
    private List<ItemMenu> itemMenu;

    public Menu() {
        fechaCreacion = LocalDate.now();
    }

    public Menu(String nombreMenu, TipoMenu tipoMenu) {
        this();
        this.nombreMenu = nombreMenu;
        this.tipoMenu = tipoMenu;
    }

    public void agregar(ItemMenu item) {
        if (itemMenu == null) {
            itemMenu = new ArrayList<>();
        }
        if (!this.itemMenu.contains(item)) {
            itemMenu.add(item);
        }
    }

    public void eliminar(ItemMenu item) {
        if (itemMenu == null) {
            throw new IllegalArgumentException("La lista de items no está inicializada");
        }
        if (item == null) {
            throw new IllegalArgumentException("El item a eliminar no puede ser nulo");
        }
        this.itemMenu.remove(item);
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fecharCreacion) {
        this.fechaCreacion = fecharCreacion;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public TipoMenu getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(TipoMenu tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public List<ItemMenu> getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(List<ItemMenu> itemMenu) {
        if (itemMenu == null) {
            throw new IllegalArgumentException("La lista de items no ha sido inicializada");
        }
        this.itemMenu = itemMenu;
    }

    public String VisualizarMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("La fecha de creación es: ").append(fechaCreacion).append("\n");
        sb.append("El nombre del menu es: ").append(nombreMenu).append("\n");
        sb.append("El tipo de menu es: ").append(tipoMenu).append("\n");
        sb.append("El menu disponible es: ").append("\n").append(itemMenu).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Menu {" +
                "fecharCreacion=" + fechaCreacion +
                ", nombreMenu='" + nombreMenu + '\'' +
                ", tipoMenu=" + tipoMenu;
    }
}
