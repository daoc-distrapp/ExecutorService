
package carrera;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<Long> ecs = new ExecutorCompletionService<>(pool);
        for(int i = 0; i < 100; i++)
            ecs.submit(new Corredor1(50));

        pool.shutdown();
        
        for(int i = 0; i < 100; i++) {
            try {
                System.out.println("CompletionService: " + ecs.take().get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
