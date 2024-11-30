package modeloproductorconsumidor;

/**
 *
 * @author Luis Sagnay
 */
public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Buffer b = new Buffer(10);
        Productor p = new Productor(b);
//        Productor p1 = new Productor(b);
        Consumidor c = new Consumidor(b);
        Consumidor c1 = new Consumidor(b);
        
        p.start();
//        p1.start();
        c.start();
        c1.start();
    }
}
