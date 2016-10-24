
package carrera;

import java.util.concurrent.Callable;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Corredor1 implements Callable<Long> {
    private final long ms;
    
    public Corredor1(long ms) {
        this.ms = ms;
    }

    @Override
    public Long call() throws Exception {
        long inicio = System.currentTimeMillis();
        long counter = 0;
        while(System.currentTimeMillis() < (inicio + ms)) {
            counter++;    
        }
        return counter;
    }
}
