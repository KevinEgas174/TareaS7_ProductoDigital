import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 5;
        int indice = 0;
        int cantidad;
        String nombre;
        double precio;
        int stock;
        int opc = 0;
        int pos;

        ProductoDigital productos[] = new ProductoDigital[MAX];
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n--- Menu Tienda ---");
            System.out.println("1. Ingresar una cantidad X de productos");
            System.out.println("2. Actualizar precio de un producto (por indice)");
            System.out.println("3. Actualizar stock de un producto (por indice)");
            System.out.println("4. Mostrar informacion de los productos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Cuantos productos desea ingresar: ");
                    cantidad = Integer.parseInt(sc.nextLine());

                    if ((indice + cantidad) <= MAX && cantidad > 0) {
                        int contador = 0;
                        while (contador < cantidad) {
                            System.out.println("\n--- Registro de Producto ---");
                            System.out.print("Ingrese el nombre del producto: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el precio: ");
                            precio = Double.parseDouble(sc.nextLine());
                            System.out.print("Ingrese el stock disponible: ");
                            stock = Integer.parseInt(sc.nextLine());

                            productos[indice++] = new ProductoDigital(nombre, precio, stock);
                            contador++;
                        }
                        System.out.println("Lote de productos registrado correctamente.");
                    } else {
                        System.out.println("No hay espacio suficiente en el arreglo.");
                    }
                    break;

                case 2:
                    if (indice > 0) {
                        System.out.print("Ingrese el indice del producto (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());

                        if (pos >= 0 && pos < indice) {
                            System.out.print("Ingrese el nuevo precio para [" + productos[pos].getNombre() + "]: ");
                            precio = Double.parseDouble(sc.nextLine());
                            productos[pos].setPrecio(precio);
                        } else {
                            System.out.println("Indice no valido.");
                        }
                    } else {
                        System.out.println("Primero debe registrar al menos un producto.");
                    }
                    break;

                case 3:
                    if (indice > 0) {
                        System.out.print("Ingrese el indice del producto (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());

                        if (pos >= 0 && pos < indice) {
                            System.out.print("Ingrese el nuevo stock para [" + productos[pos].getNombre() + "]: ");
                            stock = Integer.parseInt(sc.nextLine());
                            productos[pos].setStock(stock);
                        } else {
                            System.out.println("Indice no valido.");
                        }
                    } else {
                        System.out.println("Primero debe registrar al menos un producto.");
                    }
                    break;

                case 4:
                    if (indice > 0) {
                        System.out.println("\n--- INVENTARIO DE PRODUCTOS DIGITALES ---");
                        for (int i = 0; i < indice; i++) {
                            productos[i].mostrarInfo();
                        }
                    } else {
                        System.out.println("No hay productos registrados todavia.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opc != 5);
    }
}
