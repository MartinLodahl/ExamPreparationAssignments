/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MartinLodahl
 */
public class Producer extends Thread {

    ArrayBlockingQueue<Long> s1;
    ArrayBlockingQueue<Long> s2;

    Producer(ArrayBlockingQueue<Long> s1, ArrayBlockingQueue<Long> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run() {
        Boolean b = true;
        while (b) {
            Long l = s1.poll();
            if (l == null) {
                b = false;
                break;
            }
            long fibL = fib(l);
            try {
                s2.put(fibL);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }

    }

}
