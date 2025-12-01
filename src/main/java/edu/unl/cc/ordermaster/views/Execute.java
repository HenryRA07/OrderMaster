//package edu.unl.cc.ordermaster.views;
//
//import edu.unl.cc.ordermaster.domain.*;
//
//import java.util.List;
//import java.util.Scanner;
//
////public class Execute {
////    private static Menu inicializarMenu() {
////        Menu menuDia = new Menu("Menú del Día", TipoMenu.DESAYUNO);
////        Producto producto1 = new Platillo("Hornado de pollo", "Pollo a la brasa");
////        Producto producto2 = new Bebida("Limonada", "Jarra de limonada refrescante");
////        Producto producto3 = new Platillo("Bolón de verde", "Masa de plátano con queso/chicharrón");
////        Producto producto4 = new Bebida("Café con leche", "Clásico café ecuatoriano");
////        ItemMenu itemMenu1 = new ItemMenu(5.50f, true, producto1);
////        ItemMenu itemMenu2 = new ItemMenu(2.00f, true, producto2);
////        ItemMenu itemMenu3 = new ItemMenu(3.00f, true, producto3);
////        ItemMenu itemMenu4 = new ItemMenu(1.50f, true, producto4);
////        menuDia.agregar(itemMenu1);
////        menuDia.agregar(itemMenu2);
////        menuDia.agregar(itemMenu3);
////        menuDia.agregar(itemMenu4);
////        return menuDia;
////    }
////
////    private static void mostrarMenu(Menu menu) {
////        System.out.println("\n--- " + menu.getNombreMenu() + " (" + menu.getTipoMenu() + ") ---");
////        int contador = 1;
////        for (ItemMenu item : menu.getItemMenu()) {
////            System.out.printf("%d. %s - %.2f $\n", contador++, item.getProducto().getNombre(), item.getPrecio());
////        }
////        System.out.println("----------------------------------------------");
////    }
////
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        Menu menuDia = inicializarMenu();
////        Pedido pedidoActual = null;
////        Cliente cliente = null;
////
////        System.out.println(" Bienvenido al Sistema de Pedidos!");
////
////        System.out.println("\n--- Registro de Cliente ---");
////        System.out.print("Ingrese su Nombre: ");
////        String nombre = scanner.nextLine();
////        System.out.print("Ingrese su Apellido: ");
////        String apellido = scanner.nextLine();
////        System.out.print("Ingrese su Cédula: ");
////        String cedula = scanner.nextLine();
////        System.out.print("Ingrese su teléfono: ");
////        String telefono = scanner.nextLine();
////        System.out.print("Ingrese su email: ");
////        String email = scanner.nextLine();
////        System.out.print("Ingrese el numero de mesa: ");
////        int mesa = scanner.nextInt();
////        scanner.nextLine();
////
////        cliente = new Cliente(nombre, apellido, cedula, telefono, email);
////        pedidoActual = new Pedido(mesa, "", cliente);
////
////        System.out.println(" Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " registrado. Iniciando pedido...");
////
////        int opcion;
////        boolean salir = false;
////
////        while (!salir) {
////            System.out.println("\n--- Menú Principal ---");
////            System.out.println("1. Ver Menú del Día y Agregar Items");
////            System.out.println("2. Ver Resumen del Pedido Actual");
////            System.out.println("3. Finalizar y Pagar Pedido");
////            System.out.println("4. Salir");
////            System.out.print("Seleccione una opción: ");
////
////            try {
////                opcion = scanner.nextInt();
////                scanner.nextLine();
////
////                switch (opcion) {
////                    case 1:
////                        agregarItemsAPedido(menuDia, pedidoActual, scanner);
////                        break;
////                    case 2:
////                        mostrarResumenPedido(pedidoActual);
////                        break;
////                    case 3:
////                        finalizarPedido(pedidoActual, scanner);
////                        salir = true;
////                        break;
////                    case 4:
////                        System.out.println(" Gracias por su visita. Hasta pronto!");
////                        salir = true;
////                        break;
////                    default:
////                        System.out.println("Opción no válida. Intente de nuevo.");
////                }
////            } catch (java.util.InputMismatchException e) {
////                System.out.println(" Entrada no válida. Por favor, ingrese un número.");
////                scanner.nextLine();
////            } catch (Exception e) {
////                System.out.println(" Ocurrió un error: " + e.getMessage());
////                scanner.nextLine();
////            }
////        }
////        scanner.close();
////    }
////
////    private static void agregarItemsAPedido(Menu menu, Pedido pedido, Scanner scanner) {
////        mostrarMenu(menu);
////
////        List<ItemMenu> itemsMenu = menu.getItemMenu();
////
////        while (true) {
////            System.out.print("Ingrese el número del item a pedir (0 para terminar): ");
////            int numItem = scanner.nextInt();
////            scanner.nextLine();
////
////            if (numItem == 0) {
////                System.out.print(" Ingrese comentario/observación del cliente: ");
////                String observacion = scanner.nextLine();
////
////                if (observacion != null && !observacion.trim().isEmpty()) {
////                }
////                break;
////            }
////
////            if (numItem >= 1 && numItem <= itemsMenu.size()) {
////                ItemMenu itemSeleccionado = itemsMenu.get(numItem - 1);
////
////                System.out.print("Ingrese la cantidad (unidades): ");
////                int cantidad = scanner.nextInt();
////                scanner.nextLine();
////
////                if (cantidad > 0) {
////                    ItemPedido linea = new ItemPedido(cantidad, itemSeleccionado);
////                    pedido.agregarItems(linea);
////                    System.out.println(" " + cantidad + "x " + itemSeleccionado.getProducto().getNombre() + " agregado/s al pedido.");
////                } else {
////                    System.out.println(" La cantidad debe ser mayor a cero.");
////                }
////            } else {
////                System.out.println(" Número de item no válido.");
////            }
////        }
////    }
////
////    private static void mostrarResumenPedido(Pedido pedido) {
////        // Asumiendo que Pedido tiene un getMesa()
////        System.out.println("\n--- Resumen del Pedido (Mesa #" + pedido.getMesa() + ") ---");
////
////        List<ItemPedido> itemsPedido = pedido.getItemPedido();
////
////        if (itemsPedido == null || itemsPedido.isEmpty()) {
////            System.out.println("El pedido está vacío.");
////            return;
////        }
////
////        double subtotal = 0;
////        for (ItemPedido item : itemsPedido) {
////            double costoLinea = item.getCantidad() * item.getItem().getPrecio();
////            subtotal += costoLinea;
////            System.out.printf("- %d x %s (%.2f $/u) = %.2f $\n",
////                    item.getCantidad(),
////                    item.getItem().getProducto().getNombre(),
////                    item.getItem().getPrecio(),
////                    costoLinea);
////        }
////
////        double total = subtotal;
////
////        System.out.printf("Subtotal: %.2f $\n", subtotal);
////        System.out.printf("**TOTAL A PAGAR: %.2f $**\n", total);
////        System.out.println("----------------------------------------------");
////    }
////
////    private static void finalizarPedido(Pedido pedido, Scanner scanner) {
////        List<ItemPedido> itemsPedido = pedido.getItemPedido();
////        if (itemsPedido == null || itemsPedido.isEmpty()) {
////            System.out.println(" No se puede finalizar un pedido vacío.");
////            return;
////        }
////
////        mostrarResumenPedido(pedido);
////
////        System.out.println("\n--- Opciones de Pago ---");
////        System.out.println("1. Efectivo");
////        System.out.println("2. Transferencia Bancaria");
////        System.out.print("Seleccione el método de pago: ");
////        int opcionPago = scanner.nextInt();
////        scanner.nextLine();
////
////        MetodoPago metodoPago = null;
////
////        float totalPedido =(float) itemsPedido.stream()
////                .mapToDouble(item -> item.getCantidad() * item.getItem().getPrecio())
////                .sum();
////
////        switch (opcionPago) {
////            case 1:
////                System.out.print("Monto entregado por el cliente: ");
////                float entregado = scanner.nextFloat();
////                scanner.nextLine();
////                double cambio =  entregado - totalPedido;
////
////                metodoPago = new Efectivo(entregado, totalPedido);
////                System.out.printf("Cambio a devolver: %.2f $\n", cambio);
////                break;
////            case 2:
////                System.out.print("Nombre del titular de la cuenta: ");
////                String titular = scanner.nextLine();
////                System.out.print("Número de cuenta/referencia: ");
////                String cuenta = scanner.nextLine();
////
////                metodoPago = new Transferencia(totalPedido, titular, cuenta);
////                System.out.println("Procesando transferencia...");
////                break;
////            default:
////                System.out.println(" Opción de pago no válida. Cancelando proceso de venta.");
////                return;
////        }
////
////        ComprobanteVenta venta = new ComprobanteVenta("ShamanBlack", "RUC1234567890", pedido, metodoPago);
////        System.out.println("\n*** COMPROBANTE DE VENTA GENERADO ***");
////
////        System.out.println(venta.generarComprobante());
////        System.out.println("****************************************");
////        System.out.println("¡PEDIDO FINALIZADO CON ÉXITO!");
////    }
//}
////        Menu menu = new Menu("MenuDelDia", TipoMenu.DESAYUNO);
////        Producto producto1 = new Platillo("sancocho", "sopa de chanco espesa");
////        Producto producto2 = new Bebida("Limonada", "Jara de limonada");
////        ItemMenu itemMenu = new ItemMenu(15,true, producto1);
////        ItemMenu itemMenu2 = new ItemMenu(16,true, producto2);
////        menu.agregar(itemMenu);
////        menu.agregar(itemMenu2);
////        ItemPedido linea1 = new ItemPedido(2,itemMenu);
////        ItemPedido linea2 = new ItemPedido(3,itemMenu2);
////        Cliente persona1 = new Cliente("Henry", "Romero","11055432", "098776777","email@gmail.com");
////        Pedido pedido = new Pedido( 3,"Sancocho sin limon",persona1 );
////        pedido.agregarItems(linea1, linea2);
////        MetodoPago jaja = new Efectivo(100, 22);
////        MetodoPago jeje = new Transferencia(100, "PEpes", "03403249230");
////        ComprobanteVenta venta1 = new ComprobanteVenta("ShamanBlack","223333",pedido,jeje );
////        ComprobanteVenta venta2 = new ComprobanteVenta("ShamanBlack","223333",pedido,jaja );
////        System.out.println(venta1.generaComprobante());
////        System.out.println(venta2.generaComprobante());



