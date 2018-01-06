/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MartinLodahl
 */
public class Consumer extends Thread {

    ArrayBlockingQueue<Long> s2;
    int amount;
    static Counter counter;
    static long sum;
 
    Consumer(ArrayBlockingQueue<Long> s2, Counter counter) {
        this.s2 = s2;
        this.counter = counter;
    }

    public void run() {
        Boolean b = true;
        while (b) {
            if (counter.getCounter() > 0) {
                try {
                    long l = s2.take();
                    counter.decrease();
                    addSum(l);
                    System.out.println("This fibonacchi number" + l);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("You want SUM!?: " + sum);
                b = false;
            }

        }

    }
    
    private synchronized void addSum(long l){
        sum+=l;
    }

}
