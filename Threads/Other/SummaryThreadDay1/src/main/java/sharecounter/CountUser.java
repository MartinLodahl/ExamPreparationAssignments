/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharecounter;

/**
 *
 * @author MartinLodahl
 */
public class CountUser implements Runnable{
    
    Counter counter;
    int numberOfCounts;
   public CountUser(Counter counter, int numberOfCounts){
        this.counter=counter;
        this.numberOfCounts = numberOfCounts;
    }
    @Override
    public void run() {
        for (int i = 0; i < numberOfCounts; i++) {
        counter.inc();
        }        
    }
    
}
