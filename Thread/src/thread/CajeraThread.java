package thread;

/**
 *
 * @author Luis Sagnay
 */
public class CajeraThread extends Thread {

	private String nombre;

	private Cliente cliente;

	private long initialTime;


	public CajeraThread() {
	}

	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
        System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " 
                    + this.cliente.getNombre() + " EN EL TIEMPO: " 
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

        int totalProductos = cliente.getCarroCompra().length;

        for (int i = 0; i < totalProductos; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + 
                    " del cliente " + cliente.getNombre() + " ->Tiempo: " + 
                    (System.currentTimeMillis() - initialTime) / 1000 + "seg");
        }

        tiempoPorProducto(totalProductos, initialTime);
    }

    private void tiempoPorProducto(int totalProductos, long initialTime) {
        long tiempoTotal = (System.currentTimeMillis() - initialTime) / 1000;
        double tiempoPromedioPorProducto = (double) tiempoTotal / totalProductos;

        System.out.println("La cajera " + this.nombre + " preceso " + totalProductos +
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