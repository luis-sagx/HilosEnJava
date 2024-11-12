package thread;

/**
 *
 * @author Luis Sagnay
 */
public class MainRunnable implements Runnable{
	
	private Cliente cliente;
	private Cajera cajera;
	private long initialTime;
	
	public MainRunnable (Cliente cliente, Cajera cajera, long initialTime){
		this.cajera = cajera;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
                Cliente cliente3 = new Cliente("Cliente 3", new int[] { 2, 1, 2, 3 });
		
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");
		Cajera cajera3 = new Cajera("Cajera 3");
                
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		Runnable proceso1 = new MainRunnable(cliente1, cajera1, initialTime);
		Runnable proceso2 = new MainRunnable(cliente2, cajera2, initialTime);
		Runnable proceso3 = new MainRunnable(cliente3, cajera3, initialTime);

		new Thread(proceso1).start();
		new Thread(proceso2).start();
                new Thread(proceso3).start();

	}

	@Override
	public void run() {
		this.cajera.procesarCompra(this.cliente, this.initialTime);
	}

}
