
package carrera;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Corredor implements Runnable {
    private int resultado = -1;
    private final long ms;
    
    public Corredor(long ms) {
        this.ms = ms;
    }
    
    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        int counter = 0;
        while(System.currentTimeMillis() < (inicio + ms)) {
            counter++;    
        }
        resultado = counter;
        System.out.println("Runnable: " + resultado);
    }

}
