package modeloproductorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Luis Sagnay
 */
public class Buffer {
    private char[] buffer;
    private int siguiente; 
    private boolean estaVacia;
    private boolean estaLlena;

    public Buffer(int size) {
        this.buffer = new char[size];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }
    
    public synchronized char consumir(){
        while(this.estaVacia){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        siguiente--;
        
        if(siguiente == 0){
            this.estaVacia = true;
        }
        
        notifyAll();
        return this.buffer[this.siguiente];
    }
    
    public synchronized void producir(char c){
        while(this.estaLlena){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        buffer[siguiente] = c;
        siguiente++;
        
        this.estaVacia = false;
        if(siguiente == this.buffer.length){
            this.estaLlena = true;
        }
        
        notifyAll();
    }
    
}
