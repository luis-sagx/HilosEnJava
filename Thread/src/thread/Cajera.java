package thread;

/**
 *
 * @author Luis Sagnay
 */
public class Cajera {

	private String nombre;

	public Cajera() {
	}

	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("La cajera " + this.nombre + 
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + 
                " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        int totalProductos = cliente.getCarroCompra().length;

        for (int i = 0; i < totalProductos; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + 
                    " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }

        tiempoPorProducto(totalProductos, timeStamp);
    }

    private void tiempoPorProducto(int totalProductos, long timeStamp) {
        long tiempoTotal = (System.currentTimeMillis() - timeStamp) / 1000;
        double tiempoPromedioPorProducto = (double) tiempoTotal / totalProductos;

        System.out.println("La cajera " + this.nombre + " proceso " + totalProductos +
            " productos con un tiempo promedio por producto de: " + tiempoPromedioPorProducto + " segundos.");
    }

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}