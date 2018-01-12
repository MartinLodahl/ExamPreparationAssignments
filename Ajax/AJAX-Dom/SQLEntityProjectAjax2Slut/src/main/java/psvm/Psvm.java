package psvm;

import javax.persistence.Persistence;

/**
 *
 * @author MartinLodahl
 */
public class Psvm {
    
    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);
    }
    
}
