
package carrera;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Future<Long>> resultado = new ArrayList<>();
        
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++) {
            resultado.add(
               pool.submit(new Corredor1(50)));
        }

        pool.shutdown();
        
        for(Future<Long> fl : resultado) {
            try {
                System.out.println("Callable: " + fl.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Main1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
