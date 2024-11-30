package modeloproductorconsumidor;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Sagnay
 */
public class Consumidor extends Thread{
    private Buffer buffer;

    public Consumidor(Buffer b) {
        this.buffer = b;
    }
    
    public void run(){
        while(true){
            try {
                char c = this.buffer.consumir();
                System.out.println("Recogido el caracter: " +c +" del buffer por el Consumidor " +getName());
                
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
