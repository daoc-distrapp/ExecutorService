
package carrera;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++)
            pool.execute(new Corredor(50));
        
        pool.shutdown();
        
        
    }
    
}
