package edu.unl.cc.ordermaster.views;

import edu.unl.cc.ordermaster.domain.*;
import java.util.List;
import java.util.Scanner;

public class Execute {
    private static Menu inicializarMenu() {
        Menu menuDia = new Menu("Menú del Día", TipoMenu.DESAYUNO);
        Producto producto1 = new Platillo("Hornado de pollo", "Pollo a la brasa");
        Producto producto2 = new Bebida("Limonada", "Jarra de limonada refrescante");
        Producto producto3 = new Platillo("Bolón de verde", "Masa de plátano con queso/chicharrón");
        Producto producto4 = new Bebida("Café con leche", "Clásico café ecuatoriano");
        ItemMenu itemMenu1 = new ItemMenu(5.50f, true, producto1);
        ItemMenu itemMenu2 = new ItemMenu(2.00f, true, producto2);
        ItemMenu itemMenu3 = new ItemMenu(3.00f, true, producto3);
        ItemMenu itemMenu4 = new ItemMenu(1.50f, true, producto4);
        menuDia.agregar(itemMenu1);
        menuDia.agregar(itemMenu2);
        menuDia.agregar(itemMenu3);
        menuDia.agregar(itemMenu4);
        return menuDia;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menuDia = inicializarMenu();
        Pedido pedido = null;
        Cliente cliente = null;

        System.out.println("GESTION DE PEDIDOS");

        System.out.println("\n---DATOS DEL CLIENTE---");
        System.out.println("Nombre del cliente");
        String nombre = sc.nextLine();
        System.out.println("Apellido del cliente");
        String apellido = sc.nextLine();
        System.out.println("Cédula del cliente");
        String cedula = sc.nextLine();
        System.out.println("Numero de telefono");
        String telefono = sc.nextLine();
        System.out.println("Email del cliente");
        String email = sc.nextLine();
        System.out.println("Numero de mesa");
        int mesa = sc.nextInt();

        sc.nextLine();

        cliente = new Cliente(nombre, apellido, cedula, telefono, email);
        pedido = new Pedido(mesa, "", cliente);
        System.out.println(" Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " registrado ... Iniciando pedido...");
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Ver Menú del Día");
            System.out.println("2. Realizar Pedido");
            System.out.println("3. Confirmar Pedido");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println(menuDia.visualizarMenu());
                        break;
                    case 2:
                        while (true) {

                            List<ItemMenu> items = menuDia.getItemMenu();
                            if (items == null || items.isEmpty()) {
                                System.out.println(" El menú está vacío.");
                                break;
                            }

                            System.out.println("\n--- MENÚ DEL DÍA ---");
                            for (int i = 0; i < items.size(); i++) {
                                ItemMenu it = items.get(i);
                                System.out.printf("%d. %s - $%.2f (%s)%n",
                                        i + 1,
                                        it.getProducto().getNombre(),
                                        it.getPrecio(),
                                        it.getProducto().getDescripcion());
                            }

                            System.out.print("\nSeleccione producto (0 para salir): ");
                            int seleccion = sc.nextInt();
                            sc.nextLine();

                            if (seleccion == 0) break;
                            if (seleccion < 1 || seleccion > items.size()) {
                                System.out.println(" Selección inválida.");
                                continue;
                            }

                            ItemMenu elegir = items.get(seleccion - 1);

                            System.out.print("Cantidad: ");
                            int cantidad = sc.nextInt();
                            sc.nextLine();

                            if (cantidad <= 0) {
                                System.out.println(" Cantidad inválida.");
                                continue;
                            }

                            ItemPedido itemPedido = new ItemPedido(cantidad, elegir);
                            pedido.agregarItem(itemPedido);

                            System.out.println(" Producto agregado.");

                            System.out.print("¿Agregar otro producto? (si/no): ");
                            String respuesta = sc.nextLine();

                            if (respuesta.equalsIgnoreCase("no")) {
                                System.out.println("Observación:");
                                String observacion = sc.nextLine();
                                pedido.setObservacion(observacion);
                                break;
                            }
                        }
                        System.out.println("\n--- PEDIDO ACTUAL ---");
                        System.out.println(pedido.visualizarPedido());
                        break;
                    case 3:
                        System.out.println("\n--- Opciones de Pago ---");
                        System.out.println("1. Efectivo");
                        System.out.println("2. Transferencia Bancaria");
                        System.out.print("Seleccione el método de pago: ");
                        int opcionPago = sc.nextInt();
                        sc.nextLine();

                        MetodoPago metodoPago = null;

                        if (opcionPago == 1) {
                            System.out.print("Monto entregado por el cliente: ");
                            float entregado = sc.nextFloat();
                            sc.nextLine();
                            Efectivo efectivo = new Efectivo(entregado,pedido);
                            System.out.printf("Cambio a devolver: %.2f $\n", efectivo.getCambioEntregado());
                            System.out.println();

                        } else if (opcionPago == 2) {

                            System.out.println("Monto depositado por el cliente: ");
                            float depositado = sc.nextFloat();
                            System.out.println("Nombre del banco");
                            String banco = sc.nextLine();
                            sc.nextLine();
                            System.out.print("Número de cuenta/referencia: ");
                            String cuenta = sc.nextLine();

                            Transferencia transferencia = new Transferencia(depositado,banco,cuenta);
                            System.out.println("Procesando transferencia...");
                            System.out.println("Tranferencia exitisamente...");

                        } else {
                            System.out.println(" Opción de pago no válida. Cancelando proceso de venta.");
                        }
                        break;
                        case 4:
                            System.out.println(" Gracias por su visita. Hasta pronto!");
                            salir = true;
                            break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println(" Entrada no válida. Por favor, ingrese un número.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(" Ocurrió un error: " + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}




//        Menu menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
//        Producto producto1 = new Platillo("sancocho", "sopa de chanco espesa");
//        Producto producto2 = new Bebida("Limonada", "Jara de limonada");
//        ItemMenu itemMenu = new ItemMenu(15,true, producto1);
//        ItemMenu itemMenu2 = new ItemMenu(16,true, producto2);
//        menu.agregar(itemMenu);
//        menu.agregar(itemMenu2);
//        ItemPedido linea1 = new ItemPedido(2,itemMenu);
//        ItemPedido linea2 = new ItemPedido(3,itemMenu2);
//        Cliente persona1 = new Cliente("Henry", "Romero","11055432", "098776777","email@gmail.com");
//        Pedido pedido = new Pedido( 3,"Sancocho sin limon",persona1 );
//        pedido.agregarItems(linea1, linea2);
//        MetodoPago jaja = new Efectivo(100, 22);
//        MetodoPago jeje = new Transferencia(100, "PEpes", "03403249230");
//        ComprobanteVenta venta1 = new ComprobanteVenta("ShamanBlack","223333",pedido,jeje );
//        ComprobanteVenta venta2 = new ComprobanteVenta("ShamanBlack","223333",pedido,jaja );
//        System.out.println(venta1.generaComprobante());
//        System.out.println(venta2.generaComprobante());

