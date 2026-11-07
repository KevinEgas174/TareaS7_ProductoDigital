public class ProductoDigital {
    private String nombre;
    private double precio;
    private int stock;

    public ProductoDigital(String nombre, double precio, int stock) {
        this.nombre = nombre;
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio debe ser positivo. Se asignara 1.0 por defecto.");
            this.precio = 1.0;
        }

        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("El stock no puede ser negativo. Se asignara 0 por defecto.");
            this.stock = 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("Error: El precio debe ser positivo.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
            System.out.println("Stock actualizado correctamente.");
        } else {
            System.out.println("El stock debe ser positivo (mayor o igual a 0).");
        }
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + " | Precio: $" + precio + " | Stock: " + stock + " unidades");
    }
}